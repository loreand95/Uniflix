package it.uniflix.movieservice.client;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import it.uniflix.actorservice.controller.soap.GetMovieCastResponse;

public class ActorAsyncHandler implements AsyncHandler<GetMovieCastResponse> {
	private GetMovieCastResponse getMovieCastResponse;

	@Override
	public void handleResponse(Response<GetMovieCastResponse> response) {
		try {
			getMovieCastResponse = response.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public GetMovieCastResponse getResponse() {
		return getMovieCastResponse;
	}
}