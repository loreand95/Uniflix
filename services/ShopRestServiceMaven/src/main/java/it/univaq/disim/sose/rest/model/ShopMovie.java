package it.univaq.disim.sose.rest.model;

import java.time.LocalDateTime;

public class ShopMovie {
	
private String movieID;
private String userID;
private ShopType type;
private ShopStatus status;
private LocalDateTime start;
private LocalDateTime end;


public ShopMovie(String movieID,String userID, ShopType type, ShopStatus status, LocalDateTime start, LocalDateTime end) {
	super();
	this.movieID = movieID;
	this.setUserID(userID);
	this.type = type;
	this.status = status;
	this.start = start;
	this.end = end;
}


public ShopMovie(String movieID,String userID, ShopType type, ShopStatus status, LocalDateTime start) {
	super();
	this.movieID = movieID;
	this.setUserID(userID);
	this.type = type;
	this.status = status;
	this.start = start;
}


public String getMovieID() {
	return movieID;
}
public void setMovieID(String movieID) {
	this.movieID = movieID;
}
public ShopType getType() {
	return type;
}
public void setType(ShopType type) {
	this.type = type;
}
public ShopStatus getStatus() {
	return status;
}
public void setStatus(ShopStatus status) {
	this.status = status;
}
public LocalDateTime getStart() {
	return start;
}
public void setStart(LocalDateTime start) {
	this.start = start;
}
public LocalDateTime getEnd() {
	return end;
}
public void setEnd(LocalDateTime end) {
	this.end = end;
}


public String getUserID() {
	return userID;
}


public void setUserID(String userID) {
	this.userID = userID;
}

}
