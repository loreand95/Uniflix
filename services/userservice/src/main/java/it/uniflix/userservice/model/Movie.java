package it.uniflix.userservice.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name="Movie")
@JsonInclude(Include.NON_NULL)
public class Movie {
	
	private long movieId;
	
	private String title;
	
	private double duration;
	
	private double price;
	
	private String purchaseDate;
	
	
	public Movie() {}


		
	public long getMovieId() {
		return movieId;
	}


	public void setMovieId(long id) {
		this.movieId = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getDuration() {
		return duration;
	}


	public void setDuration(double duration) {
		this.duration = duration;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}
