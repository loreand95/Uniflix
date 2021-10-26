package it.univaq.disim.sose.rest.service.impl;

import java.util.ArrayList;
import java.util.List;
import it.univaq.disim.sose.rest.service.ShopRestService;
import it.univaq.disim.sose.rest.dao.MovieDAO;
import it.univaq.disim.sose.rest.domain.Movie;

public class ShopRestServiceImpl implements ShopRestService {
	
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		List <Movie> movies = new ArrayList<Movie>();
		MovieDAO movieRepository = new MovieDAO();
		movies = movieRepository.getAllMovies();
		return movies;
	}

	

}
