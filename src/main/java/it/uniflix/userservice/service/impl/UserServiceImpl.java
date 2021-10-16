package it.uniflix.userservice.service.impl;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import io.jsonwebtoken.Jwts;
import it.uniflix.userservice.controller.rest.JWTHelpers;
import it.uniflix.userservice.model.User;
import it.uniflix.userservice.service.UserService;
import it.uniflix.userservice.service.impl.repository.UserRepository;
import it.uniflix.userservice.service.impl.repository.impl.mongo.UserRepositoryMongo;

public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		userRepository = new UserRepositoryMongo();
	}

	public User signIn(User user) {
		user  = userRepository.signIn(user);

		//Create token
		if(user != null) {
			JWTHelpers.getInstance();
			user.setToken(JWTHelpers.generateToken(user));
		}
		
		return user;
	}
	
	public User signUp(User user) {
		
		user  = userRepository.signIn(user);
		
		return user;
	}
}
