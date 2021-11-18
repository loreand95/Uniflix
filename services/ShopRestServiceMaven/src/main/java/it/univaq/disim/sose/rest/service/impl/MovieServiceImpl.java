package it.univaq.disim.sose.rest.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import it.univaq.disim.sose.rest.utils.EndPointApi;
import it.univaq.disim.sose.rest.model.Movie;
import it.univaq.disim.sose.rest.model.MovieBO;
import it.univaq.disim.sose.rest.service.MovieService;

public class MovieServiceImpl implements MovieService {


	// TODO test: questo metodo probabilmente va eliminato 
	public  void getAll2() {
		WebClient client = WebClient.create( EndPointApi.MOVIE_SERVICE);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		String value = response.readEntity(String.class);	
		System.out.println(value);
		JSONArray moviesJson = new JSONArray(value);
		ObjectMapper mapper = new ObjectMapper();
		List<Movie> movies = new ArrayList<>();

		for(Object o: moviesJson) {
			try {
				Movie movie = mapper.readValue(o.toString(), Movie.class);

				movies.add(movie);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(movies);		
	}



	public MovieServiceImpl() {
		super();
	}

	public List<MovieBO> getAll(){	
		WebClient client = WebClient.create( EndPointApi.MOVIE_SERVICE);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		String value = response.readEntity(String.class);
		System.out.println(value);
		JSONArray moviesJson = new JSONArray(value);
		List <MovieBO> moviesPojo = new ArrayList<MovieBO>();
		ObjectMapper mapper = new ObjectMapper();
		String json = moviesJson.toString();
		try {
			// 2. convert JSON array to List of objects
			moviesPojo = Arrays.asList(mapper.readValue(json, MovieBO[].class));
			System.out.println("\nJSON array to List of objects");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return moviesPojo;
	}



	public MovieBO getMovieById(String movieId) {
		WebClient client = WebClient.create( EndPointApi.MOVIE_SERVICE+"/"+movieId);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		String value = response.readEntity(String.class);
		MovieBO movie = new MovieBO();
		try {
			ObjectMapper mapper = new ObjectMapper();
			movie = mapper.readValue(value,MovieBO.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("getMovieById Response:"+value );
		return movie;
	};
}




