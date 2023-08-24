package com.example.storage.ecchi.service;

import java.util.HashMap;

import com.example.storage.ecchi.model.AuthResponse;
import com.example.storage.ecchi.model.UserModel;

public interface UserService {

	public AuthResponse userLogin(UserModel user);

	public AuthResponse userRegister(UserModel user);
	
	public AuthResponse refreshToken(HashMap<String, String> refreshToken);
	
}
