package it.uniflix.userservice.service.impl;

import java.util.Set;
import it.uniflix.userservice.model.Movie;
import it.uniflix.userservice.model.User;
import it.uniflix.userservice.service.UserService;
import it.uniflix.userservice.service.impl.repository.UserRepository;
import it.uniflix.userservice.service.impl.repository.impl.mongo.UserRepositoryMongo;
import it.uniflix.userservice.utils.JWTHelpers;

public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	
	public UserServiceImpl() {
		userRepository = new UserRepositoryMongo();
	}

	@Override
	public User signIn(User user) {
		user  = userRepository.signIn(user);

		//Create token
		if(user != null) {
			user.setToken(JWTHelpers.generateToken(user));
		}
		
		return user;
	}
	
	@Override
	public User signUp(User user) {
		
		user = userRepository.signUp(user);
		
		//Create token
		if(user != null) {
			user.setToken(JWTHelpers.generateToken(user));
		}
		
		return user;
	}

	@Override
	public Set<Movie> getLibrary(String userId) {
		return userRepository.getLibrary(userId);
	}
}
