package it.univaq.disim.sose.rest.service;

import java.util.List;

import it.univaq.disim.sose.rest.model.PurchasedMovie;
import it.univaq.disim.sose.rest.service.impl.MovieServiceImpl;

public interface BusinessService {

public List<PurchasedMovie> shopMovieTicketing(String authTokenHeader, MovieServiceImpl movieService,
			String userId);
	
}
