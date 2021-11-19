package it.univaq.disim.sose.rest.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;
import org.json.JSONArray;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.univaq.disim.sose.rest.model.MovieBO;
import it.univaq.disim.sose.rest.model.Order;
import it.univaq.disim.sose.rest.repository.UserRepository;
import it.univaq.disim.sose.rest.repository.impl.UserRepositoryMongo;
import it.univaq.disim.sose.rest.service.UserService;
import it.univaq.disim.sose.rest.utils.EndPointApi;

public class UserServiceImpl implements UserService{

	private UserRepository userRepo = new UserRepositoryMongo();

	public List<MovieBO> getUserLibrary(String token){	
		//WebClient client = WebClient.create( EndPointApi.USER_SERVICE_GET_LIBRARY);


		WebClient client = WebClient.create( EndPointApi.USER_SERVICE_GET_LIBRARY);
		client.accept(MediaType.APPLICATION_JSON);
		client.header("Authorization", token);
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		String value = response.readEntity(String.class);
		//System.out.println("getUserLibrary-----------response"+value);
		JSONArray moviesJson = new JSONArray(value);
		List <MovieBO> moviesPojo = new ArrayList<MovieBO>();
		ObjectMapper mapper = new ObjectMapper();
		String json = moviesJson.toString();
		try {
			// 2. convert JSON array to List of objects
			moviesPojo = Arrays.asList(mapper.readValue(json, MovieBO[].class));
			//System.out.println("\nJSON array to List of objects");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return moviesPojo;
	}

		public void addToLibrary(String MovieId, String userId, Order order) {
		userRepo.addToLibrary(userId, Long.valueOf(MovieId).longValue(), order);
	}


}
