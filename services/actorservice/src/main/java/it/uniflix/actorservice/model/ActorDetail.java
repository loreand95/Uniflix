package it.uniflix.actorservice.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ActorDetail")
public class ActorDetail {
	private long actorId;
	private String name;
	private String character;
	private String profilePath;
	private String biography;
	private String birthday;
	private String birthplace;
	
	public ActorDetail() {}

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

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	@Override
	public String toString() {
		return "ActorDetail [actorId=" + actorId + ", name=" + name + ", character=" + character + ", profilePath="
				+ profilePath + ", biography=" + biography + ", birthday=" + birthday + ", birthplace=" + birthplace
				+ "]";
	}
	
	
}
