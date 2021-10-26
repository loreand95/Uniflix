package it.univaq.disim.sose.rest.domain;

import java.util.List;

public class User {
private String userId;
private List<ShopMovie> ownedMovies;
private List<ShopMovie> rentedMovies;

public User(String userId, List<ShopMovie> ownedMovies, List<ShopMovie> rentedMovies) {
	super();
	this.userId = userId;
	this.ownedMovies = ownedMovies;
	this.rentedMovies = rentedMovies;
}

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public List<ShopMovie> getOwnedMovies() {
	return ownedMovies;
}
public void setOwnedMovies(List<ShopMovie> ownedMovies) {
	this.ownedMovies = ownedMovies;
}
public List<ShopMovie> getRentedMovies() {
	return rentedMovies;
}
public void setRentedMovies(List<ShopMovie> rentedMovies) {
	this.rentedMovies = rentedMovies;
}

}
