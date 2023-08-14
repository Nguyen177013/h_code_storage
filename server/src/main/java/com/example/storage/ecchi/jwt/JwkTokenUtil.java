package com.example.storage.ecchi.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;


public class JwkTokenUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(JwkTokenUtil.class);
	
	private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000;
	
	@Value("this is secret key")
	private String SECRET_KEY;
	
	public String generareAccessToken() {
		return "";
	}
}
