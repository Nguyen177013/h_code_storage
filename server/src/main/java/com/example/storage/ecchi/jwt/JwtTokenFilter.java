package com.example.storage.ecchi.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.storage.ecchi.entity.User;

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
	}

	private boolean hasAuthorizationBearer(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
			return false;
		}
		return true;
	}

	private String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		String token = header.split(" ")[1].trim();
		return token;
	}

	private User getUserDetail(String token) {
		User userDetails = new User();
		String[] jwtSubject = jwtUtil.getSubjet(token).split(",");
		userDetails.setId(Integer.parseInt(jwtSubject[0]));
		userDetails.setUserName(jwtSubject[1]);

		return userDetails;
	}

	private void setAuthenticationContext(String token, HttpServletRequest request) {
		User userDetails = getUserDetail(token);

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				null);
		;
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
