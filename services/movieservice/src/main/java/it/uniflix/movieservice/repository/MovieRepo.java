package it.uniflix.movieservice.repository;

import java.util.List;

import it.uniflix.movieservice.model.Movie;

public interface MovieRepo {

	Movie getMovie(long id);
	
	List<Movie> getPopularMovies();
	
	List<Movie> getMoviesByGenre(long genreId);
}
