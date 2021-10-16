package it.uniflix.userservice.service.impl.repository;

import java.util.Set;

import it.uniflix.userservice.model.Movie;
import it.uniflix.userservice.model.User;

public interface UserRepository {
	
	User signIn(User user);
	
	User signUp(User user);
	
	Set<Movie> getLibrary(String userId);
	
	Movie getMovie(String movieId);
}
