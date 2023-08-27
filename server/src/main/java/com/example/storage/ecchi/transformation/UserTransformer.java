package com.example.storage.ecchi.transformation;

import org.springframework.stereotype.Component;

import com.example.storage.ecchi.entity.User;
import com.example.storage.ecchi.model.UserModel;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserTransformer {
	
	public UserModel entityToModel(User user) {
		UserModel userModel = new UserModel();
		userModel.setUserName(user.getUserName());
		userModel.setPassword(user.getUserPassword());
		return userModel;
	}
	
	public User modelToEntity(UserModel usermodel) {
		User user = new User();
		user.setUserName(usermodel.getUserName());
		user.setUserPassword(usermodel.getPassword());
		return user;
	}
}
