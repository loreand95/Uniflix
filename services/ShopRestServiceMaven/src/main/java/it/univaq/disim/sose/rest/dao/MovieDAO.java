package it.univaq.disim.sose.rest.dao;

import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.sose.rest.model.Movie;


public class MovieDAO {
	public MovieDAO() {
		super();
	}

	public List<Movie> getAllMovies(){
		
		List <Movie> movies = new ArrayList<Movie>();
		Movie movie1 = new Movie("via col vento", null, null);
		Movie movie2 = new Movie("Avengers", null, null);
		Movie movie3 = new Movie("Howard il Papero", null, null);
		Movie movie4 = new Movie("Harry Potter e il Calice di Fuoco", null, null);
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		return movies;
				};
	
}
