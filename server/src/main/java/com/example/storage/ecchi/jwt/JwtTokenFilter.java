package com.example.storage.ecchi.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.storage.ecchi.entity.User;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = getAccessToken(request);
		if (!jwtUtil.validateAccessToken(token, null)) {
			filterChain.doFilter(request, response);
			return;
		}
		setAuthenticationContext(token, request);
		filterChain.doFilter(request, response);
	}

	private String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (header == null) {
			return "";
		}
		String token = header.split(" ")[1].trim();
		return token;
	}

	private User getUserDetail(String token) {
		User userDetails = new User();
		Claims jwtBody = jwtUtil.parseClaims(token);
		userDetails.setId(Integer.parseInt(jwtBody.get("id").toString()));
		userDetails.setUserName(jwtBody.get("userName").toString());
		return userDetails;
	}

	private void setAuthenticationContext(String token, HttpServletRequest request) {
		User userDetails = getUserDetail(token);
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				null);
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
