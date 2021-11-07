package it.uniflix.movieservice.controller.rest.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

import it.uniflix.actorservice.controller.soap.ActorSoapApi;
import it.uniflix.actorservice.controller.soap.GetMovieCast;
import it.uniflix.actorservice.controller.soap.GetMovieCastResponse;
import it.uniflix.actorservice.controller.soap.impl.ActorSoapApiImplService;
import it.uniflix.movieservice.client.ActorAsyncHandler;
import it.uniflix.movieservice.controller.rest.MovieRestApi;
import it.uniflix.movieservice.model.Movie;
import it.uniflix.movieservice.service.MovieService;
import it.uniflix.movieservice.service.impl.MovieServiceImpl;

public class MovieRestApiImpl implements MovieRestApi {

	public List<Movie> getMovies() {
		MovieService movieService = new MovieServiceImpl();
		return movieService.getPopularMovies();
	}

	public Movie getMovie(long id) {
		MovieService movieService = new MovieServiceImpl();
		Movie movie = null;
		
		ActorSoapApiImplService actorService = new ActorSoapApiImplService();
		ActorSoapApi port = actorService.getActorSoapApiImplPort();
		
		GetMovieCast request = new GetMovieCast();
		request.setArg0(id);
		
		// async invokation with callback
		ActorAsyncHandler actorAsyncHandler = new ActorAsyncHandler();
		System.out.println("Invoking getMovieCastAsync(request, actorAsyncHandler) ...");
		
		Future<?> response = port.getMovieCastAsync(request, actorAsyncHandler);
		
		while(!response.isDone()) {
			if (movie == null) {
				System.out.println("Meanwhile we retrieve movie data..." );
				movie = movieService.getMovieById(id);
			}
		}
		
		GetMovieCastResponse reply = actorAsyncHandler.getResponse();
		
		System.out.println("Combining cast with movie data..." );
		movie.setCast(reply.getCast());
		
		return movie;
	}

}
