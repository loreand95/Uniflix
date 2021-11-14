package it.uniflix.reviewservice.controller.soap.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;
import it.uniflix.reviewservice.controller.soap.ReviewSoapApi;
import it.uniflix.reviewservice.model.GetReviewsResponse;
import it.uniflix.reviewservice.model.Review;
import it.uniflix.reviewservice.service.ReviewService;
import it.uniflix.reviewservice.service.impl.ReviewServiceImpl;

public class ReviewSoapApiImpl implements ReviewSoapApi{

	@Override
	//@UseAsyncMethod
	public List<Review> getReviews(long movieId) {	
		System.out.println("Controller SOAP getReviews movieId:"+ movieId);
		ReviewService reviewService = new ReviewServiceImpl();
		List <Review> reviews=reviewService.getAllByMovie(movieId);
		System.out.println("Controller SOAP getReviews:"+ reviews);
		return reviews;
	}
	
	@Override
	public Response<GetReviewsResponse> getReviewsAsync(long movieId) {
		System.out.println("Controller SOAP getReviews Async NOT IMPLEMENTED YET"+ movieId);
		return null;
	}
	
	@Override
	public Future<?> getReviewsAsync(long movieId, AsyncHandler<GetReviewsResponse> asyncHandler) {
		System.out.println("Controller SOAP getReviews Async movieId:"+ movieId);
		final ServerAsyncResponse<GetReviewsResponse> asyncResponse = new ServerAsyncResponse<GetReviewsResponse>();
		new Thread() {
			public void run() {
				GetReviewsResponse response = new GetReviewsResponse();
				
				
				ReviewService reviewService = new ReviewServiceImpl();
				List <Review> reviews = new ArrayList<Review> ();
				reviews=reviewService.getAllByMovie(movieId);
				System.out.println("Controller SOAP getReviews:"+ reviews);
				response.setReviews(reviews);
				asyncResponse.set(response);
				asyncHandler.handleResponse(asyncResponse);
			}
		}.start();
		System.out.println("Controller SOAP getReviews Async response" + asyncResponse);
		return asyncResponse;
	}

}
