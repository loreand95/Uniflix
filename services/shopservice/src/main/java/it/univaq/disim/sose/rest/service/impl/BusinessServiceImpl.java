package it.univaq.disim.sose.rest.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import it.univaq.disim.sose.rest.model.Order;
import it.univaq.disim.sose.rest.model.MovieBO;
import it.univaq.disim.sose.rest.repository.UserRepository;
import it.univaq.disim.sose.rest.repository.impl.UserRepositoryMongo;
import it.univaq.disim.sose.rest.service.BusinessService;
import it.univaq.disim.sose.rest.service.MovieService;

public class BusinessServiceImpl implements BusinessService {

	private MovieService movieService = new MovieServiceImpl();
	private UserRepository userRepo = new UserRepositoryMongo();
	private UserServiceImpl userService = new UserServiceImpl();
	
	
	public List<MovieBO> shopMovieTicketing(String authTokenHeader,
			String userId) {
		List<MovieBO> movies;
		if(userId != null) {
			List <MovieBO> library = new ArrayList<>();
			UserServiceImpl userService = new UserServiceImpl();
			library = userService.getUserLibrary(authTokenHeader);
			movies = movieService.getAll();			
			for(int i=0; i< library.size(); i++) {
				for(int j=0; j< movies.size(); j++) {
					if(library.get(i).getMovieId() == movies.get(j).getMovieId()) {
						movies.get(j).setPurchaseDate(library.get(i).getPurchaseDate());
						//System.out.println("COMPRATO --------"+library.get(i).getTitle());
					}
				}
			}
		}
		else {
			movies = movieService.getAll();
			//System.out.println("ELSE SENZA USER --------"+userId);
		}
		for(int z=0; z< movies.size(); z++) {
			setPrice(movies.get(z));
		}
		return movies;
	}

	public boolean buyMovie(String MovieId, String userId,String authTokenHeader) {
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME; 
		LocalDateTime now = LocalDateTime.now();
		MovieBO movie = movieService.getMovieById(MovieId,userId,authTokenHeader);
		List <MovieBO> library = new ArrayList<>();
		library = userService.getUserLibrary(authTokenHeader);			
		for(int i=0; i< library.size(); i++) {
			if(library.get(i).getMovieId() == movie.getMovieId()) {
				movie.setPurchaseDate(library.get(i).getPurchaseDate());
				//System.out.println("POSSIEDI GIA QUESTO FILM-------"+library.get(i).getTitle());
				return false;
			}
		}
		Order order = new Order ();
		order.setMovieId(Long.valueOf(MovieId).longValue());
		order.setPrice(setPrice(movie));
		order.setPurchaseDate(dtf.format(now));
		order.setId(UUID.randomUUID().toString());
		userService.addToLibrary(MovieId, userId, order);
		return true;
	}



	private Double setPrice (MovieBO movie) {
		Double price = 3.99;
		movie.setPrice(price);
		//System.out.println("------ PREZZO MOVIE: "+ movie.getPrice());
		return price;
	}

}
