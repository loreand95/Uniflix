package it.univaq.disim.sose.rest.controller.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import it.univaq.disim.sose.rest.controller.ShopRestControllerApi;
import it.univaq.disim.sose.rest.model.Movie_old;
import it.univaq.disim.sose.rest.model.Order;
import it.univaq.disim.sose.rest.model.PurchasedMovie;
import it.univaq.disim.sose.rest.repository.UserRepository;
import it.univaq.disim.sose.rest.repository.impl.UserRepositoryMongo;
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
	public PurchasedMovie getMovieById(String movieId) {
		String authTokenHeader = httpServletRequest.getHeader("Authorization");
		System.out.println("TOKEN--------"+authTokenHeader);
		PurchasedMovie movies = new PurchasedMovie();
		MovieServiceImpl movieService = new MovieServiceImpl();
		movieService.getMovieById(movieId);
		String userId = (String) httpServletRequest.getAttribute("userId");
		System.out.println("USERID--------"+userId);
		System.out.println("MovieID--------"+movieId);
		return movies;
	}


	@Override
	public String buyMovie(String MovieId) {
		String authTokenHeader = httpServletRequest.getHeader("Authorization");
		System.out.println("TOKEN--------"+authTokenHeader);
		String userId = (String) httpServletRequest.getAttribute("userId");
		PaymentServiceImpl paymentService = new PaymentServiceImpl();
		String result = paymentService.buyMovie(authTokenHeader,userId);
		if(true) {
			buyMovie(MovieId, userId);
		}
		return result;
	}

	private void buyMovie(String MovieId, String userId) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();
		Order order = new Order ();
		order.setMovieId(Long.valueOf(MovieId).longValue());
		order.setPrice(3.99);
		order.setPurchaseDate(dtf.format(now).toString());
		order.setId(UUID.randomUUID().toString());
		UserRepository userRepo = new UserRepositoryMongo(); 
		userRepo.addToLibrary(userId, Long.valueOf(MovieId).longValue(), order);
	}
	

}
