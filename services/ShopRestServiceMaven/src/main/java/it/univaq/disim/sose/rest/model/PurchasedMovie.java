package it.univaq.disim.sose.rest.model;

import java.util.List;

public class PurchasedMovie extends Movie_old{

	
	private String purchaseDate;
	private double price;
	
	public PurchasedMovie(String title, String description, List<String> actors, String purchaseDate, double price) {
		super(title, description, actors);
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
