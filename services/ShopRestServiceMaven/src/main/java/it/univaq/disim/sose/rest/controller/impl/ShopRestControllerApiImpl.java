

package it.univaq.disim.sose.rest.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.json.JSONArray;

import it.univaq.disim.sose.rest.controller.ShopRestControllerApi;
import it.univaq.disim.sose.rest.model.Movie;
import it.univaq.disim.sose.rest.model.Movie_old;
import it.univaq.disim.sose.rest.model.PurchasedMovie;
import it.univaq.disim.sose.rest.service.impl.MovieServiceImpl;
import it.univaq.disim.sose.rest.service.impl.UserServiceImpl;

public class ShopRestControllerApiImpl implements ShopRestControllerApi{
	
	@Context
	HttpServletRequest httpServletRequest;
	
	@Override
	public List<PurchasedMovie> getAllMovies() {
		
		String authTokenHeader = httpServletRequest.getHeader("Authorization");
		
		List <PurchasedMovie> movies = new ArrayList<>();
		MovieServiceImpl movieService = new MovieServiceImpl();
		String userId = (String) httpServletRequest.getAttribute("userId");
		String auth = httpServletRequest.getAuthType();
		System.out.println("USERID--------"+userId);
		System.out.println("AUTH--------"+auth);
		if(userId != null) {
			List <PurchasedMovie> library = new ArrayList<>();
			UserServiceImpl userService = new UserServiceImpl();
			library = userService.getUserLibrary(authTokenHeader);
			System.out.println("LIBRARY --------"+userId);
			movies = movieService.getAll();			
			}
		else {
			System.out.println("ELSE --------"+userId);
		}
		return movies;
	}

	@Override
	public Movie_old getMovie(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
