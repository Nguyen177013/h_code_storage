package com.example.storage.ecchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;

@SpringBootApplication(exclude = {ReactiveSecurityAutoConfiguration.class})

public class NunkeCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NunkeCodeApplication.class, args);
	}
}
