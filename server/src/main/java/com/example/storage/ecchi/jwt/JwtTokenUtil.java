package com.example.storage.ecchi.jwt;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.example.storage.ecchi.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
// Base on https://github.com/codejava-official/spring-jwt-authentication/blob/main/src/main/java/net/codejava/jwt/JwtTokenUtil.java

@Component
public class JwtTokenUtil {
	private static final long EXPIRE_DURATION = 30 * 1000;

	private String accessToken = System.getenv("ACCESS_TOKEN_KEY");

	public String generateToken(User user, String tokenKey) {
		JwtBuilder builder = Jwts.builder().setIssuer("HStorage").setSubject("token").claim("id", user.getId())
				.claim("userName", user.getUserName()).setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS512, tokenKey);
		if (tokenKey == accessToken) {
			System.out.println("Access Token Ne!");
			builder.setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION));
		}
		return builder.compact();
	}

	public boolean validateAccessToken(String token, String tokenCode) {
		if (ObjectUtils.isEmpty(token)) {
			return false;
		}
		String tokenType = (tokenCode == null ? accessToken : tokenCode);
		try {
			Jwts.parser().setSigningKey(tokenType).parseClaimsJws(token);
			return true;
		} catch (ExpiredJwtException ex) {
			System.err.println("JWT expired: " + ex.getMessage());
		} catch (IllegalArgumentException ex) {
			System.err.println("Token is null, empty or only whitespace: " + ex.getMessage());
		} catch (MalformedJwtException ex) {
			System.err.println("JWT is invalid: " + ex);
		} catch (UnsupportedJwtException ex) {
			System.err.println("JWT is not supported: " + ex);
		} catch (SignatureException ex) {
			System.err.println("Signature validation failed");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

	public Claims parseClaims(String token) {
		return Jwts.parser().setSigningKey(accessToken).parseClaimsJws(token).getBody();
	}
}
