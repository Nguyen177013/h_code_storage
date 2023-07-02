package com.example.storage.ecchi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		System.out.println("hello yanket");
		registry.addMapping("/api/**").allowedOrigins("http://127.0.0.1:5173")
				.allowedMethods("GET", "POST", "PUT", "DELETE").allowedHeaders("*");
	}

	@Value(value = "${cors.endpoints.allowed-origins}")
	private String[] allowedOrigins;

    @Bean
    WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(allowedOrigins).allowedHeaders("*")
                        .allowedMethods("GET", "PUT", "POST", "DELETE", "OPTIONS").maxAge(86400);
            }
        };
    }
}
