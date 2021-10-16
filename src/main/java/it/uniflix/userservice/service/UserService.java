package it.uniflix.userservice.service;

import it.uniflix.userservice.model.User;

public interface UserService {
	
	User signIn(User user);
	
	User signUp(User user);
}
