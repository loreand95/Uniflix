package it.univaq.disim.sose.rest.service;

import java.util.List;

import it.univaq.disim.sose.rest.model.Movie_old;
import it.univaq.disim.sose.rest.model.PurchasedMovie;

public interface MovieService {
	
	public List<PurchasedMovie> getAll();
	public void getAll2();
}
