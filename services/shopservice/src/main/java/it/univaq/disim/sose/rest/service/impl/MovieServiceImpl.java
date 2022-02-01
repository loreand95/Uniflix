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
import it.univaq.disim.sose.rest.model.MovieBO;
import it.univaq.disim.sose.rest.service.MovieService;

public class MovieServiceImpl implements MovieService {
	private UserServiceImpl userService = new UserServiceImpl();

	public MovieServiceImpl() {
		super();
	}

	public List<MovieBO> getAll(){	
		WebClient client = WebClient.create( EndPointApi.MOVIE_SERVICE);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		String value = response.readEntity(String.class);
		JSONArray moviesJson = new JSONArray(value);
		List <MovieBO> moviesPojo = new ArrayList<MovieBO>();
		ObjectMapper mapper = new ObjectMapper();
		String json = moviesJson.toString();
		try {
			// 2. convert JSON array to List of objects
			moviesPojo = Arrays.asList(mapper.readValue(json, MovieBO[].class));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return moviesPojo;
	}



	public MovieBO getMovieById(String movieId,String userId, String authTokenHeader) {
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
		
		//ESTIMATE PRICE TODO
		movie.setPrice(3.99);		
		if(userId != null) {
			List <MovieBO> library = new ArrayList<>();
			library = userService.getUserLibrary(authTokenHeader);			
			for(int i=0; i< library.size(); i++) {
					if(library.get(i).getMovieId() == movie.getMovieId()) {
						movie.setPurchaseDate(library.get(i).getPurchaseDate());
						movie.setPrice(0);
					}
				}
			}
		return movie;
	};
}




