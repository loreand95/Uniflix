package it.uniflix.actorservice.repository.impl;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;


import com.mongodb.client.MongoCollection;
import static com.mongodb.client.model.Filters.eq;

import it.uniflix.actorservice.model.ActorDetail;
import it.uniflix.actorservice.model.Credit;
import it.uniflix.actorservice.service.MongoConnection;
import it.uniflix.actorervice.repository.ActorRepo;
import it.uniflix.actorservice.model.ActorCast;



public class ActorRepoImpl implements ActorRepo {
	
	private MongoCollection<Credit> castColl;
	private MongoCollection<ActorDetail> actorColl;
	
	public ActorRepoImpl() {
		castColl = MongoConnection.getDatabase().getCollection("Credits", Credit.class);
		actorColl = MongoConnection.getDatabase().getCollection("Actor", ActorDetail.class);
	}

	public List<ActorCast> getMovieCast(long movieId) {
		Credit credit = castColl.find(eq("movieId", movieId)).first();
		
		return credit.getCast();
	}

	@Override
	public ActorDetail getActor(long actorId) {
		ActorDetail actor = actorColl.find(eq("actorId", actorId)).first();
		
		return actor;
	}

}
