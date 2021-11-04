package it.univaq.disim.sose.rest.repository;

import java.util.Set;

import it.univaq.disim.sose.rest.model.Movie_old;
import it.univaq.disim.sose.rest.model.PurchasedMovie;
import it.univaq.disim.sose.rest.model.User;




public interface UserRepository {
	
	User signIn(User user);
	
	User signUp(User user);
	
	Set<PurchasedMovie> getLibrary(String userId);
	
	PurchasedMovie getMovie(long movieId);
}
