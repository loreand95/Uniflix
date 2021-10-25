package it.uniflix.movieservice.repository;

import java.util.List;

import it.uniflix.movieservice.model.Genre;

public interface GenreRepo {
	List<Genre> getAll();
}
