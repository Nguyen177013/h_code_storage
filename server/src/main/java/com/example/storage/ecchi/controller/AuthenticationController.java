package com.example.storage.ecchi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storage.ecchi.entity.User;
import com.example.storage.ecchi.jwt.JwtTokenUtil;

@RestController
@RequestMapping("api/auth/")
public class AuthenticationController {
	
	@Autowired
	JwtTokenUtil jwtUtil;

	@GetMapping("login")
	String greeting() {
		User user = new User();
		user.setId(1);
		user.setUserName("Phan Nguyen");
		user.setUserEmail("phannguyendoremon@gmail.com");
		user.setUserPassword("177013");
		return "Xin Chao Cac Ban";
	}
}
