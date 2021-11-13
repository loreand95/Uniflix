package it.uniflix.reviewservice.model;

import java.util.List;


public class GetReviews {

	public GetReviews() {
	}

	private List <Review> reviews;

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	
}
