package it.uniflix.actorservice.controller.soap.impl;

import java.util.List;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import org.apache.cxf.annotations.UseAsyncMethod;
import org.apache.cxf.jaxws.ServerAsyncResponse;

import it.uniflix.actorservice.model.ActorCast;
import it.uniflix.actorservice.model.ActorDetail;
import it.uniflix.actorservice.model.GetActorResponse;
import it.uniflix.actorservice.model.GetMovieCastResponse;
import it.uniflix.actorservice.service.ActorService;
import it.uniflix.actorservice.service.impl.ActorServiceImpl;
import it.uniflix.actorservice.controller.soap.ActorSoapApi;

public class ActorSoapApiImpl implements ActorSoapApi {
	
	@Override
	@UseAsyncMethod
	public ActorDetail getActor(long actorId) {
		System.out.println("ActorSoapApiImpl - getActor(" + actorId + ")");
		ActorService actorService = new ActorServiceImpl();
		ActorDetail actor = actorService.getActor(actorId);
		System.out.println(actor);
		
		return actor;
	}
	
	@Override
	public Response<GetActorResponse> getActorAsync(long actorId) {
		System.out.println("ActorSoapApiImpl - getActorAsync(" + actorId + ")");
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Future<?> getActorAsync(long actorId, AsyncHandler<GetActorResponse> asyncHandler) {
		System.out.println("ActorSoapApiImpl - getActorAsync(" + actorId + ", " + asyncHandler + ")");
		final ServerAsyncResponse<GetActorResponse> asyncResponse = new ServerAsyncResponse<GetActorResponse>();
		
		new Thread() {
			public void run() {
				GetActorResponse response = new GetActorResponse();
				
				
				ActorService actorService = new ActorServiceImpl();
				ActorDetail actor = actorService.getActor(actorId);
				
				response.setActorDetail(actor);

				asyncResponse.set(response);
				asyncHandler.handleResponse(asyncResponse);
			}
		}.start();
		return asyncResponse;
	}
	

	@Override
	@UseAsyncMethod
	public List<ActorCast> getMovieCast(long movieId) {
		System.out.println("ActorSoapApiImpl - getMovieCast(" + movieId + ")");
		ActorService actorService = new ActorServiceImpl();
		List<ActorCast> cast = actorService.getMovieCast(movieId);
		return cast;
	}
	
	@Override
	public Response<GetMovieCastResponse> getMovieCastAsync(long movieId) {
		System.out.println("ActorSoapApiImpl - getMovieCastAsync(" + movieId + ")");
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Future<?> getMovieCastAsync(long movieId,
			AsyncHandler<GetMovieCastResponse> asyncHandler) {
		System.out.println("ActorSoapApiImpl - getMovieCastAsync(" + movieId + ", " + asyncHandler + ")");
		final ServerAsyncResponse<GetMovieCastResponse> asyncResponse = new ServerAsyncResponse<GetMovieCastResponse>();
		
		new Thread() {
			public void run() {
				GetMovieCastResponse response = new GetMovieCastResponse();
				
				
				ActorService actorService = new ActorServiceImpl();
				List<ActorCast> cast = actorService.getMovieCast(movieId);
				
				response.setCast(cast);

				asyncResponse.set(response);
				asyncHandler.handleResponse(asyncResponse);
			}
		}.start();
		return asyncResponse;
	}

}
