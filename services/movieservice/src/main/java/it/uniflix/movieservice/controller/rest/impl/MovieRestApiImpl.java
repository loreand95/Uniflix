package it.uniflix.movieservice.controller.rest.impl;

import java.util.List;

import it.uniflix.movieservice.controller.rest.MovieRestApi;
import it.uniflix.movieservice.model.Movie;
import it.uniflix.movieservice.service.MovieService;
import it.uniflix.movieservice.service.impl.MovieServiceImpl;

public class MovieRestApiImpl implements MovieRestApi {

	public List<Movie> getMovies() {
		MovieService movieService = new MovieServiceImpl();
		return movieService.getPopularMovies();
	}

	public Movie getMovie(String id) {
		MovieService movieService = new MovieServiceImpl();
		return movieService.getMovieById(id);
	}

}
