package it.univaq.disim.sose.rest.repository;

import java.util.Set;

import it.univaq.disim.sose.rest.model.Movie;
import it.univaq.disim.sose.rest.model.User;




public interface UserRepository {
	
	User signIn(User user);
	
	User signUp(User user);
	
	Set<Movie> getLibrary(String userId);
	
	Movie getMovie(long movieId);
}
