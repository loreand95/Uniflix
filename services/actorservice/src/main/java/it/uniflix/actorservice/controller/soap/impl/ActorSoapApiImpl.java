package it.uniflix.actorservice.controller.soap.impl;

import java.util.List;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;

import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;

import it.uniflix.actorservice.model.ActorCast;
import it.uniflix.actorservice.model.ActorDetail;
import it.uniflix.actorservice.model.SendCastWithReturnResponse;
import it.uniflix.actorservice.service.ActorService;
import it.uniflix.actorservice.service.impl.ActorServiceImpl;
import it.uniflix.actorservice.controller.soap.ActorSoapApi;

public class ActorSoapApiImpl implements ActorSoapApi {
	
	@Override
	public ActorDetail getActor(int actorId) {
		ActorService actorService = new ActorServiceImpl();
		return actorService.getActor(actorId);
	}
	
	
	
	@Override
	public Future<?> getMovieCastAsync(int movieId,
			AsyncHandler<SendCastWithReturnResponse> asyncHandler) {
		final ServerAsyncResponse<SendCastWithReturnResponse> asyncResponse = new ServerAsyncResponse<SendCastWithReturnResponse>();
		
		new Thread() {
			public void run() {
				SendCastWithReturnResponse response = new SendCastWithReturnResponse();
				
				
				ActorService actorService = new ActorServiceImpl();
				List<ActorCast> cast = actorService.getMovieCast(movieId);
				
				response.setCast(cast);

				asyncResponse.set(response);
				asyncHandler.handleResponse(asyncResponse);
			}
		}.start();
		return asyncResponse;
	}

	@Override
	@UseAsyncMethod
	public List<ActorCast> getMovieCast(int movieId) {
		// TODO Auto-generated method stub
		return null;
	}

}
