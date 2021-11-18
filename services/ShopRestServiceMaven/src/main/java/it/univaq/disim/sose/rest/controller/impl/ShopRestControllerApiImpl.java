package it.univaq.disim.sose.rest.controller.impl;


import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import it.univaq.disim.sose.rest.controller.ShopRestControllerApi;
import it.univaq.disim.sose.rest.model.MovieBO;
import it.univaq.disim.sose.rest.service.BusinessService;
import it.univaq.disim.sose.rest.service.impl.MovieServiceImpl;
import it.univaq.disim.sose.rest.service.impl.PaymentServiceImpl;
import it.univaq.disim.sose.rest.service.impl.BusinessServiceImpl;

public class ShopRestControllerApiImpl implements ShopRestControllerApi{

	@Context
	HttpServletRequest httpServletRequest;

	private BusinessService shopService = new BusinessServiceImpl();
	private MovieServiceImpl movieService = new MovieServiceImpl();
	private PaymentServiceImpl paymentService = new PaymentServiceImpl();
	private BusinessService businessService = new BusinessServiceImpl();

	@Override
	public List<MovieBO> getAllMovies() {

		String authTokenHeader = httpServletRequest.getHeader("Authorization");
		System.out.println("TOKEN--------"+authTokenHeader);
		List <MovieBO> movies = new ArrayList<>();
		String userId = (String) httpServletRequest.getAttribute("userId");
		System.out.println("USERID--------"+userId);
		movies = shopService.shopMovieTicketing(authTokenHeader, userId);
		return movies;
	}

	@Override
	public MovieBO getMovieById(String movieId) {
		String authTokenHeader = httpServletRequest.getHeader("Authorization");
		MovieBO movie = new MovieBO();
		String userId = (String) httpServletRequest.getAttribute("userId");
		movie=movieService.getMovieById(movieId,userId,authTokenHeader);
		System.out.println(" getMovieById : MovieID--------"+movieId);
		return movie;
	}


	@Override
	public String buyMovie(String MovieId) {
		String authTokenHeader = httpServletRequest.getHeader("Authorization");
		System.out.println("TOKEN--------"+authTokenHeader);
		String userId = (String) httpServletRequest.getAttribute("userId");
		String result = paymentService.buyMovie(authTokenHeader,userId);
		if(true) {
			businessService.buyMovie(MovieId, userId,authTokenHeader);
		};
		return result;
	}
}
