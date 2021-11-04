package it.uniflix.actorservice.controller.soap.impl;

import java.util.List;

import it.uniflix.actorservice.model.ActorCast;
import it.uniflix.actorservice.model.ActorDetail;
import it.uniflix.actorservice.service.ActorService;
import it.uniflix.actorservice.service.impl.ActorServiceImpl;
import it.uniflix.actorservice.controller.soap.ActorSoapApi;

public class ActorSoapApiImpl implements ActorSoapApi {
	
	@Override
	public ActorDetail getActor(long actorId) {
		ActorService actorService = new ActorServiceImpl();
		return actorService.getActor(actorId);
	}
	
	@Override
	public List<ActorCast> getMovieCast(long movieId) {
		ActorService actorService = new ActorServiceImpl();
		return actorService.getMovieCast(movieId);
	}


}
