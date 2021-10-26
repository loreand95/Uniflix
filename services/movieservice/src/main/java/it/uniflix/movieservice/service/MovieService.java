package it.uniflix.movieservice.service;

import java.util.List;

import it.uniflix.movieservice.model.Movie;

public interface MovieService {
	Movie getMovieById(String id);
	
	List<Movie> getPopularMovies();
	
	List<Movie> getMoviesByGenre(int genreId);

}
