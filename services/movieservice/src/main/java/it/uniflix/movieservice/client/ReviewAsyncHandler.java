package it.uniflix.movieservice.client;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import it.uniflix.actorservice.controller.soap.GetMovieCastResponse;
import it.uniflix.reviewservice.controller.soap.GetReviewsResponse;

public class ReviewAsyncHandler implements AsyncHandler<GetReviewsResponse> {
	private GetReviewsResponse getReviewsResponse;

	@Override
	public void handleResponse(Response<GetReviewsResponse> response) {
		try {
			getReviewsResponse = response.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GetReviewsResponse getResponse() {
		return getReviewsResponse;
	}
}