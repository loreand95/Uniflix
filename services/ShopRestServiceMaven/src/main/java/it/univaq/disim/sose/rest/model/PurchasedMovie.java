package it.univaq.disim.sose.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlRootElement(name="Movies")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchasedMovie extends Movie{

	@JsonIgnore
	private String purchaseDate;
	private double price;
	
	public PurchasedMovie() {}
	
	public PurchasedMovie( String purchaseDate, double price) {
		super();
		this.purchaseDate = purchaseDate;
		this.price = price;
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


	public void setPrice(double d) {
		this.price = d;
	}



	
	
}
