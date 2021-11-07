package it.uniflix.movieservice.service.impl;

import java.util.List;

import it.uniflix.movieservice.model.Movie;
import it.uniflix.movieservice.repository.MovieRepo;
import it.uniflix.movieservice.repository.impl.MovieRepoImpl;
import it.uniflix.movieservice.service.MovieService;

public class MovieServiceImpl implements MovieService{
	
	private MovieRepo movieRepo;
	
	public MovieServiceImpl() {
		movieRepo = new MovieRepoImpl();
	}

	public Movie getMovieById(long id) {
		return movieRepo.getMovie(id);
	}

	public List<Movie> getPopularMovies() {
		return movieRepo.getPopularMovies();
	}

	public List<Movie> getMoviesByGenre(long genreId) {
		return movieRepo.getMoviesByGenre(genreId);
	}

}
