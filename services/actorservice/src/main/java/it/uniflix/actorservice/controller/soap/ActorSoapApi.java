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
import it.uniflix.actorservice.model.SendCastWithReturnResponse;

@WebService
public interface ActorSoapApi {
	
	@WebMethod
	ActorDetail getActor(int actorId);
	
	@WebMethod
	@ResponseWrapper(localName = "sendCastWithReturnResponse", 
		className = "it.uniflix.actorservice.model.SendCastWithReturnResponse")
	List<ActorCast> getMovieCast(int movieId);

	
	@WebMethod
	@ResponseWrapper(localName = "sendCastWithReturnResponse", 
		className = "it.uniflix.actorservice.model.SendCastWithReturnResponse")
	Future<?> getMovieCastAsync(int movieId, AsyncHandler<SendCastWithReturnResponse> asyncHandler);
}
