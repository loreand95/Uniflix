package it.univaq.disim.sose.rest.service;

import java.util.List;
import it.univaq.disim.sose.rest.model.MovieBO;

public interface MovieService {
	public List<MovieBO> getAll();
	public MovieBO getMovieById(String movieId,String userId, String authTokenHeader);
}
