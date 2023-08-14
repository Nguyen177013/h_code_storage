package com.example.storage.ecchi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth/")
public class AuthenticationController {
	@GetMapping("login")
	String greeting() {
		return "Hello world";
	}
}
