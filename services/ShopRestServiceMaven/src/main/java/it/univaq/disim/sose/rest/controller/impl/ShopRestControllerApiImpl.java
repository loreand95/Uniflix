package it.univaq.disim.sose.rest.controller.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import it.univaq.disim.sose.rest.controller.ShopRestControllerApi;
import it.univaq.disim.sose.rest.model.Movie_old;
import it.univaq.disim.sose.rest.model.PurchasedMovie;
import it.univaq.disim.sose.rest.service.PaymentService;
import it.univaq.disim.sose.rest.service.BusinessService;
import it.univaq.disim.sose.rest.service.UserService;
import it.univaq.disim.sose.rest.service.impl.MovieServiceImpl;
import it.univaq.disim.sose.rest.service.impl.PaymentServiceImpl;
import it.univaq.disim.sose.rest.service.impl.BusinessServiceImpl;
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
		BusinessService shopService = new BusinessServiceImpl();
		String userId = (String) httpServletRequest.getAttribute("userId");
		System.out.println("USERID--------"+userId);
		movies = shopService.shopMovieTicketing(authTokenHeader, movieService, userId);
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
