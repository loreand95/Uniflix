package it.uniflix.actorservice.controller.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import it.uniflix.actorservice.model.ActorCast;
import it.uniflix.actorservice.model.ActorDetail;

@WebService
public interface ActorSoapApi {
	
	@WebMethod
	ActorDetail getActor(long actorId);
	
	@WebMethod
	List<ActorCast> getMovieCast(long movieId);
}
