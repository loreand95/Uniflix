package it.uniflix.reviewservice.controller.soap;

import java.util.List;
import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;
import it.uniflix.reviewservice.model.GetReviews;
import it.uniflix.reviewservice.model.Review;

@WebService
public interface ReviewSoapApi {

	
	@WebMethod
	@ResponseWrapper(localName = "getReviewsResponse", 
		className = "it.uniflix.reviewservice.model.Review")
	List<Review> getReviews(long movieId);
	/*
	@WebMethod
	@ResponseWrapper(localName = "getReviewsResponse", 
		className = "it.uniflix.reviewservice.model.GetReviews")
	Response<GetReviews> getReviewsAsync(long movieId);
*/
	@WebMethod
	@ResponseWrapper(localName = "getReviewsResponse", 
		className = "it.uniflix.reviewservice.model.GetReviews")
	Future<?> getReviewsAsync(long movieId, AsyncHandler<GetReviews> asyncHandler);
	
	
	
}
