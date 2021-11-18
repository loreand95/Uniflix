package it.univaq.disim.sose.rest.model;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@XmlRootElement(name="Movies")
@JsonIgnoreProperties(ignoreUnknown = true)


public class MovieList  extends ArrayList<Movie> {

	public MovieList() {}

}
