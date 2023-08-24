package com.example.storage.ecchi.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storage.ecchi.model.AuthResponse;
import com.example.storage.ecchi.model.UserModel;
import com.example.storage.ecchi.service.UserService;

@RestController
@RequestMapping("api/auth/")
public class AuthenticationController {

	@Autowired
	UserService userService;
	
	@PostMapping("login")
	AuthResponse login (@RequestBody UserModel user) {
		return userService.userLogin(user);
	}
	
	@PostMapping("register")
	AuthResponse register (@RequestBody UserModel user) {
		return userService.userRegister(user);
	}
	
	@PostMapping("refresh-token")
	AuthResponse refreshToken(@RequestBody HashMap<String, String> refreshToken) {
		return userService.refreshToken(refreshToken);
	}
}
