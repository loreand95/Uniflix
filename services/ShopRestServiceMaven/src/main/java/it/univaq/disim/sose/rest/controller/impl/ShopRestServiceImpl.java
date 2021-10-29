/*package it.univaq.disim.sose.rest.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import it.univaq.disim.sose.rest.controller.ShopRestService;
import it.univaq.disim.sose.rest.dao.MovieDAO;
import it.univaq.disim.sose.rest.model.Movie;

public class ShopRestServiceImpl implements ShopRestService {
	
	
	@Context
	HttpServletRequest httpServletRequest;
	
	public List<Movie> getAllMovies() {
		// TODO Auto-generated method stub
		List <Movie> movies = new ArrayList<Movie>();
		MovieDAO movieRepository = new MovieDAO();
		movies = movieRepository.getAllMovies();
		return movies;
	}

	

}*/
