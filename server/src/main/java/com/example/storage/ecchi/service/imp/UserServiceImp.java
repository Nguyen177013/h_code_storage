package com.example.storage.ecchi.service.imp;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.storage.ecchi.entity.User;
import com.example.storage.ecchi.jwt.JwtTokenUtil;
import com.example.storage.ecchi.model.UserModel;
import com.example.storage.ecchi.repository.UserRepository;
import com.example.storage.ecchi.service.UserService;
import com.example.storage.ecchi.transformation.UserTransformer;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	JwtTokenUtil jwtUtils;

	@Autowired
	UserRepository userRepositiory;

	@Autowired
	UserTransformer userTransformer;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String userLogin(UserModel user) {
		User userLogin = userRepositiory.findUser(user.getEmail(), user.getUserName());
		boolean checkUserPassword = passwordEncoder.matches(user.getPassword(), userLogin.getUserPassword());
		if (checkUserPassword) {
			return jwtUtils.generareAccessToken(userLogin);
		}
		return "Wrong password or user name please check again";
	}

	@Override
	public String userRegister(UserModel user) {
		String encriptPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encriptPassword);
		User newUser = userTransformer.modelToEntity(user);
		if (Objects.isNull(userRepositiory.findUser(newUser.getUserEmail(), newUser.getUserName()))) {
			newUser = userRepositiory.save(newUser);
			return jwtUtils.generareAccessToken(newUser);
		}
		return "This email is already exist";
	}

}
