package it.uniflix.actorservice.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ActorCast")
public class ActorCast {
	private long actorId;
	private String name;
	private String character;
	private String profilePath;
	
	public ActorCast() {}

	public long getActorId() {
		return actorId;
	}

	public void setActorId(long actorId) {
		this.actorId = actorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}

	@Override
	public String toString() {
		return "ActorCast [actorId=" + actorId + ", name=" + name + ", character=" + character + ", profilePath="
				+ profilePath + "]";
	};
	
	
}
