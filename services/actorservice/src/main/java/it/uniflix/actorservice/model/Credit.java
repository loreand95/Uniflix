package it.uniflix.actorservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ActorCast")
public class Credit {

	private long movieId;
	private List<ActorCast> cast;
	
	public Credit() {}
	
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public List<ActorCast> getCast() {
		return cast;
	}
	public void setCast(List<ActorCast> cast) {
		this.cast = cast;
	}

	@Override
	public String toString() {
		return "Credit [movieId=" + movieId + ", cast=" + cast + "]";
	}
	
	
	
}
