package it.uniflix.movieservice.controller.rest.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

import it.uniflix.actorservice.controller.soap.ActorSoapApi;
import it.uniflix.actorservice.controller.soap.GetMovieCast;
import it.uniflix.actorservice.controller.soap.GetMovieCastResponse;
import it.uniflix.actorservice.controller.soap.impl.ActorSoapApiImplService;
import it.uniflix.movieservice.client.ActorAsyncHandler;
import it.uniflix.movieservice.client.ReviewAsyncHandler;
import it.uniflix.movieservice.controller.rest.MovieRestApi;
import it.uniflix.movieservice.model.Movie;
import it.uniflix.movieservice.service.MovieService;
import it.uniflix.movieservice.service.impl.MovieServiceImpl;
import it.uniflix.reviewservice.controller.soap.GetReviews;
import it.uniflix.reviewservice.controller.soap.GetReviewsResponse;
import it.uniflix.reviewservice.controller.soap.ReviewSoapApi;
import it.uniflix.reviewservice.controller.soap.impl.ReviewSoapApiImplService;

public class MovieRestApiImpl implements MovieRestApi {

	public List<Movie> getMovies() {
		MovieService movieService = new MovieServiceImpl();
		return movieService.getPopularMovies();
	}

	public Movie getMovie(long id) {
		MovieService movieService = new MovieServiceImpl();
		
		// check if movie is present in the db
		if (!movieService.isMoviePresent(id)) return null;
		
		Movie movie = null;
		
		ActorSoapApiImplService actorService = new ActorSoapApiImplService();
		ActorSoapApi port = actorService.getActorSoapApiImplPort();
		
		ReviewSoapApiImplService reviewService = new ReviewSoapApiImplService();
		ReviewSoapApi port2 = reviewService.getReviewSoapApiImplPort();
		
		GetReviews request2 = new GetReviews();
		request2.setArg0(id);
		
		GetMovieCast request = new GetMovieCast();
		request.setArg0(id);
		
		// async invokation with callback
		ActorAsyncHandler actorAsyncHandler = new ActorAsyncHandler();
		
		ReviewAsyncHandler reviewAsyncHandler = new ReviewAsyncHandler();
		
		System.out.println("Invoking getMovieCastAsync(request, actorAsyncHandler) ...");
		Future<?> response = port.getMovieCastAsync(request, actorAsyncHandler);
		GetReviewsResponse reply2 = null;
		
		
		while(!response.isDone()) {
			
			System.out.println("In the mean time we invoke getMovieCastAsync(request, actorAsyncHandler) ...");
			Future<?> response2 = port2.getReviewsAsync(request2, reviewAsyncHandler);
			
			while(!response2.isDone()) {
				if (movie == null) {
					System.out.println("..and we retrieve movie data..." );
					movie = movieService.getMovieById(id);
				}
			}
			
			reply2 = reviewAsyncHandler.getResponse();
		}
		
		GetMovieCastResponse reply = actorAsyncHandler.getResponse();
		
		System.out.println("Combining movie data with cast and reviews lists..." );
		movie.setCast(reply.getCast());
		movie.setReviews(reply2.getReviews());
		
		return movie;
	}

}
