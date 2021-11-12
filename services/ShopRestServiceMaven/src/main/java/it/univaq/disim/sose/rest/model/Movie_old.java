package it.univaq.disim.sose.rest.model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name="Movies")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Movie_old {
	private String id;
	private String title;
	private String description;
	private String director;
	private List<String> actors;

	
public Movie_old() {
		super();
	}

public Movie_old(String title,String description,List <String> actors){
this.title = title;
this.description = description;
this.actors = actors;
}

public Movie_old(String id, String title, String description, String director, List<String> actors) {
	super();
	this.id = id;
	this.title = title;
	this.description = description;
	this.director = director;
	this.actors = actors;
}


public Movie_old(String title, String description, String director, List<String> actors) {
	super();
	this.title = title;
	this.description = description;
	this.director = director;
	this.actors = actors;
}



public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getDirector() {
	return director;
}
public void setDirector(String director) {
	this.director = director;
}
public List<String> getActors() {
	return actors;
}
public void setActors(List<String> actors) {
	this.actors = actors;
}
}