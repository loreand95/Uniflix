package it.uniflix.reviewservice.controller.soap.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;
import it.uniflix.reviewservice.controller.soap.ReviewSoapApi;
import it.uniflix.reviewservice.model.GetReviews;
import it.uniflix.reviewservice.model.Review;
import it.uniflix.reviewservice.service.ReviewService;
import it.uniflix.reviewservice.service.impl.ReviewServiceImpl;

public class ReviewSoapApiImpl implements ReviewSoapApi{

	@Override
	//@UseAsyncMethod
	public List<Review> getReviews(long movieId) {	
		System.out.println("Controller SOAP getReviews");
		ReviewService reviewService = new ReviewServiceImpl();
		List <Review> reviews = new ArrayList<Review> ();
		reviews=reviewService.getAllByMovie(movieId);
		return reviews;
	}
	/*
	@Override
	public Response<GetReviews> getReviewsAsync(long movieId) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	@Override
	public Future<?> getReviewsAsync(long movieId, AsyncHandler<GetReviews> asyncHandler) {
		System.out.println("Controller SOAP getReviews Async");
		final ServerAsyncResponse<GetReviews> asyncResponse = new ServerAsyncResponse<GetReviews>();
		new Thread() {
			public void run() {
				GetReviews response = new GetReviews();
				
				
				ReviewService reviewService = new ReviewServiceImpl();
				List <Review> reviews = new ArrayList<Review> ();
				reviews=reviewService.getAllByMovie(movieId);
				
				response.setReviews(reviews);

				asyncResponse.set(response);
				asyncHandler.handleResponse(asyncResponse);
			}
		}.start();
		return asyncResponse;
	}

}
