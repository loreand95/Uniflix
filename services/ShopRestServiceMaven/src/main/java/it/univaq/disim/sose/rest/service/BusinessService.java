package it.univaq.disim.sose.rest.service;

import java.util.List;

import it.univaq.disim.sose.rest.model.MovieBO;
import it.univaq.disim.sose.rest.service.impl.MovieServiceImpl;

public interface BusinessService {

	public List<MovieBO> shopMovieTicketing(String authTokenHeader,
			String userId);

	public void buyMovie(String movieId, String userId,String authTokenHeader);

}
