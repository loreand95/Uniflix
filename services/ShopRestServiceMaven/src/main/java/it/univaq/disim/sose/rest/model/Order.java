package it.univaq.disim.sose.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
@XmlRootElement(name="Order")
public class Order {

	private String id;
	
	private long movieId;
	
	private String purchaseDate;
	
	private double price;
	
	
	public Order() {}

	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public long getMovieId() {
		return movieId;
	}


	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}


	public String getPurchaseDate() {
		return purchaseDate;
	}


	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
}
