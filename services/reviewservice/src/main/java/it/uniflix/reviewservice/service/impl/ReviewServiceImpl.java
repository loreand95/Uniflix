package it.uniflix.reviewservice.service.impl;

import java.util.List;
import it.uniflix.reviewservice.model.Review;
import it.uniflix.reviewservice.repository.ReviewsRepo;
import it.uniflix.reviewservice.repository.impl.ReviewsRepoImpl;
import it.uniflix.reviewservice.service.ReviewService;

public class ReviewServiceImpl implements ReviewService {
	
	private ReviewsRepo reviewRepo;

	public ReviewServiceImpl () {
		this.reviewRepo = new ReviewsRepoImpl(); 
	}
	
	@Override
	public List<Review> getAllByMovie(long movieId) {
		return this.reviewRepo.getAllReviewsByMovie(movieId);
	}

}
