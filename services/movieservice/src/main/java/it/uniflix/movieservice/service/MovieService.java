package it.uniflix.movieservice.service;

import java.util.List;

import it.uniflix.movieservice.model.Movie;

public interface MovieService {
	Movie getMovieById(long id);
	
	List<Movie> getPopularMovies();
	
	List<Movie> getMoviesByGenre(long genreId);
	
	boolean isMoviePresent(long movieId);

}
