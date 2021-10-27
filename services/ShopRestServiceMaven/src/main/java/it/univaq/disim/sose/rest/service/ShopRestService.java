package it.univaq.disim.sose.rest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import it.univaq.disim.sose.rest.model.Movie;


@Path("/shoprestservice")
public interface ShopRestService {
@GET
@Path("movies")
@Produces({MediaType.TEXT_PLAIN})
public List<Movie> getAllMovies();
}


