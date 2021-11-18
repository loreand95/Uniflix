package it.uniflix.userservice.repository;

import java.util.Set;

import it.uniflix.userservice.dto.AvailableFieldsReq;
import it.uniflix.userservice.dto.AvailableFieldsRes;
import it.uniflix.userservice.model.Movie;
import it.uniflix.userservice.model.User;

public interface UserRepository {
	
	User signIn(User user);
	
	User signUp(User user);
	
	Set<Movie> getLibrary(String userId);
	
	Movie getMovie(long movieId);

	AvailableFieldsRes available(AvailableFieldsReq fields);
}
