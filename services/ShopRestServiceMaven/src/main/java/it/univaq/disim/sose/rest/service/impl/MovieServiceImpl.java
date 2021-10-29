package it.univaq.disim.sose.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.univaq.disim.sose.rest.utils.EndPointApi;
import it.univaq.disim.sose.rest.model.Movie;
import it.univaq.disim.sose.rest.model.MovieList;
import it.univaq.disim.sose.rest.model.Movie_old;


public class MovieServiceImpl {
	
	
	
	public MovieServiceImpl() {
		super();
	}

	public List<Movie_old> getAll(){
		
		WebClient client = WebClient.create( EndPointApi.MOVIE_SERVICE);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();

		String value = response.readEntity(String.class);

		
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println("The response is -------------------------- " + value);
		Movie value2 = response.readEntity(Movie.class);

		//System.out.println("The value2 size -------------------------- " + value2.size());
		List <Movie_old> movies = new ArrayList<Movie_old>();
		Movie_old movie1 = new Movie_old("via col vento", null, null);
		Movie_old movie2 = new Movie_old("Avengers", null, null);
		Movie_old movie3 = new Movie_old("Howard il Papero", null, null);
		Movie_old movie4 = new Movie_old("Harry Potter e il Calice di Fuoco", null, null);
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		return movies;
				};
	
}




