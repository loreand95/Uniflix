package it.uniflix.actorservice.controller.soap;

import java.util.List;
import java.util.concurrent.Future;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;
import javax.xml.ws.ResponseWrapper;

import it.uniflix.actorservice.model.ActorCast;
import it.uniflix.actorservice.model.ActorDetail;
import it.uniflix.actorservice.model.GetActorResponse;
import it.uniflix.actorservice.model.GetMovieCastResponse;

@WebService
public interface ActorSoapApi {
	
	@WebMethod
	@ResponseWrapper(localName = "getActorResponse", 
    className = "it.uniflix.actorservice.model.GetActorResponse")
	ActorDetail getActor(long actorId);
	
	@WebMethod
	@ResponseWrapper(localName = "getActorResponse", 
    className = "it.uniflix.actorservice.model.GetActorResponse")
	Response<GetActorResponse> getActorAsync(long actorId);
	
	@WebMethod
	@ResponseWrapper(localName = "getActorResponse", 
    className = "it.uniflix.actorservice.model.GetActorResponse")
	Future<?> getActorAsync(long actorId, AsyncHandler<GetActorResponse> asyncHandler);
	
	
	@WebMethod
	@ResponseWrapper(localName = "getMovieCastResponse", 
		className = "it.uniflix.actorservice.model.GetMovieCastResponse")
	List<ActorCast> getMovieCast(long movieId);
	
	@WebMethod
	@ResponseWrapper(localName = "getMovieCastResponse", 
		className = "it.uniflix.actorservice.model.GetMovieCastResponse")
	Response<GetMovieCastResponse> getMovieCastAsync(long movieId);

	@WebMethod
	@ResponseWrapper(localName = "getMovieCastResponse", 
		className = "it.uniflix.actorservice.model.GetMovieCastResponse")
	Future<?> getMovieCastAsync(long movieId, AsyncHandler<GetMovieCastResponse> asyncHandler);
}
