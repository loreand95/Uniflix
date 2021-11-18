package it.univaq.disim.sose.rest.dto;

public class AuthResponse{
	
	private String userId;
	private boolean auth;
	
	public AuthResponse() {}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public boolean isAuth() {
		return auth;
	}
	
	public void setAuth(boolean auth) {
		this.auth = auth;
	}	
}