package com.example.storage.ecchi.service.imp;

import java.util.HashMap;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.storage.ecchi.entity.User;
import com.example.storage.ecchi.jwt.JwtTokenUtil;
import com.example.storage.ecchi.model.AuthResponse;
import com.example.storage.ecchi.model.UserModel;
import com.example.storage.ecchi.repository.UserRepository;
import com.example.storage.ecchi.service.UserService;
import com.example.storage.ecchi.transformation.UserTransformer;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

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

	private String accessTokenCode = System.getenv("ACCESS_TOKEN_KEY");

	private String refreshTokenCode = System.getenv("REFRESH_TOKEN_KEY");

	@Override
	public AuthResponse userLogin(UserModel user) {
		AuthResponse authResponse = new AuthResponse();
		User userLogin = userRepositiory.findUser(user.getEmail(), user.getUserName());
		boolean checkUserPassword = passwordEncoder.matches(user.getPassword(), userLogin.getUserPassword());
		if (checkUserPassword) {
			String accessToken = jwtUtils.generateToken(userLogin, accessTokenCode);
			String refreshToken = jwtUtils.generateToken(userLogin, refreshTokenCode);
			authResponse.setAccessToken(accessToken);
			authResponse.setRefreshToken(refreshToken);
			authResponse.setMessage("Success");
		} else {
			authResponse.setMessage("Can not generate token");
		}
		return authResponse;
	}

	@Override
	public AuthResponse userRegister(UserModel user) {
		AuthResponse authResponse = new AuthResponse();
		String encriptPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encriptPassword);
		User newUser = userTransformer.modelToEntity(user);
		if (Objects.isNull(userRepositiory.findUser(newUser.getUserEmail(), newUser.getUserName()))) {
			newUser = userRepositiory.save(newUser);
			String accessToken = jwtUtils.generateToken(newUser, accessTokenCode);
			String refreshToken = jwtUtils.generateToken(newUser, refreshTokenCode);
			authResponse.setAccessToken(accessToken);
			authResponse.setRefreshToken(refreshToken);
			authResponse.setMessage("Success");
		} else {
			authResponse.setMessage("This email is already exist");
		}
		return authResponse;
	}

	@Override
	public AuthResponse refreshToken(HashMap<String, String> refreshToken) {
		AuthResponse authResponse = new AuthResponse();
		String token = refreshToken.get("refreshToken");
		if(Objects.isNull(token)) {
			authResponse.setMessage("Refresh token is empty");
			return authResponse;
		}
		if(!jwtUtils.validateAccessToken(token, refreshTokenCode)) {
			authResponse.setMessage("Refresh token is invalid");
			return authResponse;
		}
		Claims claims = Jwts.parser().setSigningKey(refreshTokenCode).parseClaimsJws(token).getBody();		// wtf I am doing :D ?
		User user = new User();
		user.setId(Integer.parseInt(claims.get("id").toString()));
		user.setUserName(claims.get("userName").toString());
		authResponse.setRefreshToken(token);
		authResponse.setAccessToken(jwtUtils.generateToken(user, accessTokenCode));
		return authResponse;
	}

}
