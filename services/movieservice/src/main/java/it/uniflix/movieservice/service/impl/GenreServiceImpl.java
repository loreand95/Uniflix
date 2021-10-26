package it.uniflix.movieservice.service.impl;

import java.util.List;

import it.uniflix.movieservice.model.Genre;
import it.uniflix.movieservice.repository.GenreRepo;
import it.uniflix.movieservice.repository.impl.GenreRepoImpl;
import it.uniflix.movieservice.service.GenreService;

public class GenreServiceImpl implements GenreService {
	
	GenreRepo genreRepo;
	
	public GenreServiceImpl() {
		this.genreRepo = new GenreRepoImpl();
	}

	public List<Genre> getAll() {
		return genreRepo.getAll();
	}

}
