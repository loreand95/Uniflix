package it.uniflix.actorservice.model;

import java.util.List;

public class GetMovieCastResponse {

	private List<ActorCast> cast;

	public List<ActorCast> getCast() {
		return cast;
	}

	public void setCast(List<ActorCast> cast) {
		this.cast = cast;
	}
	
	
}
