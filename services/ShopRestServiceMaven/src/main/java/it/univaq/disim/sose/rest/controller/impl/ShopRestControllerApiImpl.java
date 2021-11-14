package it.univaq.disim.sose.rest.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import it.univaq.disim.sose.rest.controller.ShopRestControllerApi;
import it.univaq.disim.sose.rest.model.Movie_old;
import it.univaq.disim.sose.rest.model.PurchasedMovie;
import it.univaq.disim.sose.rest.service.PaymentService;
import it.univaq.disim.sose.rest.service.UserService;
import it.univaq.disim.sose.rest.service.impl.MovieServiceImpl;
import it.univaq.disim.sose.rest.service.impl.PaymentServiceImpl;
import it.univaq.disim.sose.rest.service.impl.UserServiceImpl;

public class ShopRestControllerApiImpl implements ShopRestControllerApi{

	@Context
	HttpServletRequest httpServletRequest;

	@Override
	public List<PurchasedMovie> getAllMovies() {

		String authTokenHeader = httpServletRequest.getHeader("Authorization");
		System.out.println("TOKEN--------"+authTokenHeader);
		List <PurchasedMovie> movies = new ArrayList<>();
		MovieServiceImpl movieService = new MovieServiceImpl();
		String userId = (String) httpServletRequest.getAttribute("userId");
		System.out.println("USERID--------"+userId);
		if(userId != null) {
			List <PurchasedMovie> library = new ArrayList<>();
			UserServiceImpl userService = new UserServiceImpl();
			library = userService.getUserLibrary(authTokenHeader);
			movies = movieService.getAll();			
			for(int i=0; i< library.size(); i++) {
				for(int j=0; j< movies.size(); j++) {
					if(library.get(i).getMovieId() == movies.get(j).getMovieId()) {
						movies.get(j).setPurchaseDate(library.get(i).getPurchaseDate());
						System.out.println("COMPRATO --------"+library.get(i).getTitle());
					}
				}
			}
		}
		else {
			movies = movieService.getAll();
			System.out.println("ELSE SENZA USER --------"+userId);
		}
		for(int z=0; z< movies.size(); z++) {
			if((z % 2) == 0) movies.get(z).setPrice(3.99);
			else movies.get(z).setPrice(7.99);
			System.out.println("------ PREZZO MOVIE: "+ movies.get(z).getPrice());
		}
		return movies;
	}

	@Override
	public String buyMovie(String id) {
		String authTokenHeader = httpServletRequest.getHeader("Authorization");
		System.out.println("TOKEN--------"+authTokenHeader);
		String userId = (String) httpServletRequest.getAttribute("userId");
		PaymentServiceImpl paymentService = new PaymentServiceImpl();
		String result = paymentService.buyMovie(authTokenHeader,userId);
		return result;
	}
	
	@Override
	public Movie_old getMovie(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
