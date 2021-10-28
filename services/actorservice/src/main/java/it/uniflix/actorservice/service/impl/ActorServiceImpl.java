package it.uniflix.actorservice.service.impl;

import java.util.List;

import it.uniflix.actorervice.repository.ActorRepo;
import it.uniflix.actorservice.model.ActorCast;
import it.uniflix.actorservice.model.ActorDetail;
import it.uniflix.actorservice.repository.impl.ActorRepoImpl;
import it.uniflix.actorservice.service.ActorService;


public class ActorServiceImpl implements ActorService{
	
	private ActorRepo actorRepo;
	
	public ActorServiceImpl() {
		actorRepo = new ActorRepoImpl();
	}

	@Override
	public List<ActorCast> getMovieCast(long movieId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActorDetail getActor(long actorId) {
		// TODO Auto-generated method stub
		return null;
	}


}
