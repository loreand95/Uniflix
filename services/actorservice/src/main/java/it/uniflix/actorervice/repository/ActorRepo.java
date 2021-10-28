package it.uniflix.actorervice.repository;

import java.util.List;

import it.uniflix.actorservice.model.ActorCast;
import it.uniflix.actorservice.model.ActorDetail;

public interface ActorRepo {
	List<ActorCast> getMovieCast(long movieId);
	
	ActorDetail getActor(long actorId);

}
