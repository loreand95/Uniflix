package it.uniflix.movieservice.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;

import it.uniflix.movieservice.model.Genre;
import it.uniflix.movieservice.repository.GenreRepo;
import it.uniflix.movieservice.service.MongoConnection;

public class GenreRepoImpl implements GenreRepo {
	
	private MongoCollection<Genre> genresColl;
	
	public GenreRepoImpl() {
		genresColl = MongoConnection.getInstance().getDatabase().getCollection("Genres", Genre.class);
	}

	public List<Genre> getAll() {
		List<Genre> genres = genresColl.find().into(new ArrayList<Genre>());
		
		if (genres == null) {
		    return null;
		} else {
		    return genres;
		}
	}
	

}
