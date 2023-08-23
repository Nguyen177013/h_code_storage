package com.example.storage.ecchi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.storage.ecchi.model.UserModel;
import com.example.storage.ecchi.service.UserService;

@RestController
@RequestMapping("api/auth/")
public class AuthenticationController {

	@Autowired
	UserService userService;
	
	@PostMapping("login")
	String login (@RequestBody UserModel user) {
		return userService.userLogin(user);
	}
	
	@PostMapping("register")
	String register (@RequestBody UserModel user) {
		return userService.userRegister(user);
	}
}
