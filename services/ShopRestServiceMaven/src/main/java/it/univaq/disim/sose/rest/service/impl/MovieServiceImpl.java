package it.univaq.disim.sose.rest.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.JSON;

import it.univaq.disim.sose.rest.utils.EndPointApi;
import it.univaq.disim.sose.rest.model.Movie;
import it.univaq.disim.sose.rest.model.MovieList;
import it.univaq.disim.sose.rest.model.Movie_old;


public class MovieServiceImpl {
	
	public static void main(String[] args) {
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

	public List<Movie_old> getAll(){
		
		WebClient client = WebClient.create( EndPointApi.MOVIE_SERVICE);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();

		String value = response.readEntity(String.class);
		
		System.out.println(value);
		
		JSONArray moviesJson = new JSONArray(value);

		

		
		System.out.println("The response is -------------------------- " + moviesJson);
		
		//MovieList value2 =  response.readEntity(MovieList.class);

		//System.out.println("The value2 size -------------------------- " + value2.size());
		List <Movie> moviesPojo = new ArrayList<Movie>();
        ObjectMapper mapper = new ObjectMapper();
        String json = moviesJson.toString();
        try {



            // 2. convert JSON array to List of objects
             moviesPojo = Arrays.asList(mapper.readValue(json, Movie[].class));

            System.out.println("\nJSON array to List of objects");
            moviesPojo.stream().forEach(x -> System.out.println(x));



        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("\nJSON array to List of objects"+moviesPojo);
		
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




