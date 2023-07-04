package com.example.storage.ecchi.config;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class WebConfig {

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.addAllowedOriginPattern("*");
	    config.setAllowedHeaders(Arrays.asList(HttpHeaders.AUTHORIZATION, HttpHeaders.CONTENT_TYPE, HttpHeaders.ACCEPT));
	    config.setAllowedMethods(Arrays.asList(
	        HttpMethod.GET.name(), HttpMethod.POST.name(), HttpMethod.PUT.name(), HttpMethod.DELETE.name()));
	    
	    // Calculate the dynamic Max-Age value
	    long maxAgeSeconds = calculateMaxAge();

	    // Set the dynamic Max-Age value
	    config.setMaxAge(maxAgeSeconds);

	    source.registerCorsConfiguration("/**", config);
	    FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
	    bean.setOrder(-102);
	    return bean;
	}

	// Helper method to calculate the Max-Age value based on the current time
	private long calculateMaxAge() {
	    LocalDateTime currentTime = LocalDateTime.now();
	    LocalDateTime expirationTime = currentTime.plusHours(1); // Set the expiration time to 1 hour from the current time
	    Duration duration = Duration.between(currentTime, expirationTime);
	    return duration.getSeconds();
	}
}
