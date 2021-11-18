package it.univaq.disim.sose.rest.service;

import java.util.List;

import it.univaq.disim.sose.rest.model.MovieBO;

public interface UserService {

	public List<MovieBO> getUserLibrary(String token);
}
