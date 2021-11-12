package it.uniflix.movieservice.repository.impl;

import com.mongodb.client.MongoCollection;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;

import java.util.ArrayList;
import java.util.List;

import it.uniflix.movieservice.model.Movie;
import it.uniflix.movieservice.repository.MovieRepo;
import it.uniflix.movieservice.service.MongoConnection;

public class MovieRepoImpl implements MovieRepo {
	
	private MongoCollection<Movie> moviesColl;
	
	public MovieRepoImpl() {
		moviesColl = MongoConnection.getDatabase().getCollection("Movies", Movie.class);
	}
	
	public Movie getMovie(long id) {
				
		Movie movie = moviesColl.find(eq("movieId",id)).first();
		
		if (movie == null) {
		    return null;
		} else {
		    return movie;
		}
	}

	public List<Movie> getPopularMovies() {

		List<Movie> movies = moviesColl.find().limit(50).into(new ArrayList<Movie>());
		
		if (movies == null) {
		    return null;
		} else {
		    return movies;
		}
	}

	public List<Movie> getMoviesByGenre(long genreId) {
		List<Movie> movies = moviesColl.find(elemMatch("genres", eq("genreId", genreId))).into(new ArrayList<Movie>());
		
		if (movies == null) {
		    return null;
		} else {
		    return movies;
		}
	}

}
