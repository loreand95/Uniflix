package it.uniflix.userservice.model;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@XmlRootElement(name="Order")
public class Order {

	private int id;
	
	private String movieId;
	
	private String purchaseDate;
	
	private double price;
	
	
	public Order() {}

	

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMovieId() {
		return movieId;
	}


	public void setMovieId(String movieId) {
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
