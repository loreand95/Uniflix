package it.uniflix.reviewservice.controller.soap;

import java.util.List;
import java.util.concurrent.Future;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;
import it.uniflix.reviewservice.model.GetReviewsResponse;
import it.uniflix.reviewservice.model.Review;

@WebService
public interface ReviewSoapApi {

	
	@WebMethod
	/*@ResponseWrapper(localName = "getReviewsResponse", 
		className = "it.uniflix.reviewservice.model.Reviews")*/
	List<Review> getReviews(long movieId);
	
	@WebMethod
	@ResponseWrapper(localName = "getReviewsResponse", 
		className = "it.uniflix.reviewservice.model.GetReviewsResponse")
	Response<GetReviewsResponse> getReviewsAsync(long movieId);

	@WebMethod
	@ResponseWrapper(localName = "getReviewsResponse", 
		className = "it.uniflix.reviewservice.model.GetReviewsResponse")
	Future<?> getReviewsAsync(long movieId, AsyncHandler<GetReviewsResponse> asyncHandler);
	
}
