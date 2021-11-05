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

import it.univaq.disim.sose.rest.model.PurchasedMovie;
import it.univaq.disim.sose.rest.service.UserService;
import it.univaq.disim.sose.rest.utils.EndPointApi;

public class UserServiceImpl implements UserService{

	
	
	public List<PurchasedMovie> getUserLibrary(String token){	
		//WebClient client = WebClient.create( EndPointApi.USER_SERVICE_GET_LIBRARY);
		
		
		WebClient client = WebClient.create( EndPointApi.USER_SERVICE_GET_LIBRARY);
		client.accept(MediaType.APPLICATION_JSON);
		client.header("Authorization", token);
		
		Response response = client.accept(MediaType.APPLICATION_JSON).get();
		
		String value = response.readEntity(String.class);
		System.out.println("getUserLibrary-----------response"+value);
		
		/*
		JSONArray moviesJson = new JSONArray(value);
		List <PurchasedMovie> moviesPojo = new ArrayList<PurchasedMovie>();
        ObjectMapper mapper = new ObjectMapper();
        String json = moviesJson.toString();
        try {
            // 2. convert JSON array to List of objects
            moviesPojo = Arrays.asList(mapper.readValue(json, PurchasedMovie[].class));
            System.out.println("\nJSON array to List of objects");
            moviesPojo.stream().forEach(x -> System.out.println(x));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
		//return moviesPojo;
		return null;
				};
				
				
}
