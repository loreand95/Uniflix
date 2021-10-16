package it.uniflix.userservice.service.impl.repository;

import it.uniflix.userservice.model.User;

public interface UserRepository {
	
	User signIn(User user);

}
