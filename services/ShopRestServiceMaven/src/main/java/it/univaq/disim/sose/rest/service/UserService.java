package it.univaq.disim.sose.rest.service;

import java.util.List;

import it.univaq.disim.sose.rest.model.PurchasedMovie;

public interface UserService {
	
	public List<PurchasedMovie> getUserLibrary(String token);
}
