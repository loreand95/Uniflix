

package it.univaq.disim.sose.rest.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import it.univaq.disim.sose.rest.controller.ShopServiceRestApi;
import it.univaq.disim.sose.rest.model.Movie_old;
import it.univaq.disim.sose.rest.service.impl.MovieServiceImpl;

public class ShopRestServiceApiImpl implements ShopServiceRestApi{
	
	//@Context
	//HttpServletRequest httpServletRequest;
	
	@Override
	public List<Movie_old> getAllMovies() {
		List <Movie_old> movies = new ArrayList<>();
		MovieServiceImpl movieService = new MovieServiceImpl();
		movies = movieService.getAll();
		System.out.println("--------GET ALL MOVIES");
		System.out.println(movies.size());
		System.out.println("titolo-------"+movies.get(1).getTitle());
		return movies;
	}

	@Override
	public Movie_old getMovie(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
