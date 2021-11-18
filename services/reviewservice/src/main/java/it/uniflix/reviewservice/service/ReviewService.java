package it.uniflix.reviewservice.service;

import java.util.List;
import it.uniflix.reviewservice.model.Review;


public interface ReviewService {

	List <Review> getAllByMovie(long movieId);

}
