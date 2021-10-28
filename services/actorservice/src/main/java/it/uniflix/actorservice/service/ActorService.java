package it.uniflix.actorservice.service;

import java.util.List;

import it.uniflix.actorservice.model.ActorCast;
import it.uniflix.actorservice.model.ActorDetail;

public interface ActorService {
	List<ActorCast> getMovieCast(long movieId);
	
	ActorDetail getActor(long actorId);

}
