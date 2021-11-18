package it.uniflix.reviewservice.repository;

import java.util.List;

import it.uniflix.reviewservice.model.Review;

public interface ReviewsRepo {

	public List<Review> getAllReviewsByMovie(long movieId);
}
