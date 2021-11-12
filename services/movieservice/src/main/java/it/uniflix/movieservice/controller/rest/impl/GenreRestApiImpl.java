package it.uniflix.movieservice.controller.rest.impl;

import java.util.List;

import it.uniflix.movieservice.controller.rest.GenreRestApi;
import it.uniflix.movieservice.model.Genre;
import it.uniflix.movieservice.model.Movie;
import it.uniflix.movieservice.service.GenreService;
import it.uniflix.movieservice.service.MovieService;
import it.uniflix.movieservice.service.impl.GenreServiceImpl;
import it.uniflix.movieservice.service.impl.MovieServiceImpl;

public class GenreRestApiImpl implements GenreRestApi {

	public List<Genre> getGenres() {
		GenreService genreService = new GenreServiceImpl();
		return genreService.getAll();
	}


	public List<Movie> getMoviesByGenre(long id) {
		MovieService movieService = new MovieServiceImpl();
		return movieService.getMoviesByGenre(id);
	}

}
