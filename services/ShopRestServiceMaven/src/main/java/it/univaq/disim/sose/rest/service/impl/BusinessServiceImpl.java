package it.univaq.disim.sose.rest.service.impl;

import java.util.ArrayList;
import java.util.List;

import it.univaq.disim.sose.rest.model.PurchasedMovie;
import it.univaq.disim.sose.rest.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {

	
	public List<PurchasedMovie> shopMovieTicketing(String authTokenHeader, MovieServiceImpl movieService,
			String userId) {
		List<PurchasedMovie> movies;
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
	
}
