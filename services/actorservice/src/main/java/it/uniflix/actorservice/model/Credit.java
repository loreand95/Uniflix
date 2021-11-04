package it.uniflix.actorservice.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name="ActorCast")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Credit {

	private long movieId;
	private List<ActorCast> cast;
	
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
	
	
}
