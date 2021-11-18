package it.univaq.disim.sose.rest.repository;

import java.util.Set;
import it.univaq.disim.sose.rest.model.Order;
import it.univaq.disim.sose.rest.model.MovieBO;
import it.univaq.disim.sose.rest.model.User;




public interface UserRepository {

	User signIn(User user);

	User signUp(User user);

	Set<MovieBO> getLibrary(String userId);

	MovieBO getMovie(long movieId);

	boolean addToLibrary(String userId,long movieId, Order order);
}
