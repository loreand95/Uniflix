package it.uniflix.reviewservice.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;
import it.uniflix.reviewservice.model.Review;
import it.uniflix.reviewservice.repository.MongoConnection;
import it.uniflix.reviewservice.repository.ReviewsRepo;

public class ReviewsRepoImpl implements ReviewsRepo {

	private MongoCollection <Review> reviewsCollection;
	
	public ReviewsRepoImpl () {
		this.reviewsCollection = MongoConnection.getDatabase().getCollection("Reviews",Review.class);
	}
	
	@Override
	public List<Review> getAllReviewsByMovie(long movieId) {
		List <Review> reviews = reviewsCollection.find(eq("movieId",movieId)).into(new ArrayList<Review>());
		System.out.println("getAllReviewsByMovie"+ movieId + "REVIEWS: "+reviews);
		return reviews;
	}

}
