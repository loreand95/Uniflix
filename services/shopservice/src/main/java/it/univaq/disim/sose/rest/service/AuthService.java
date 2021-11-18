package it.univaq.disim.sose.rest.service;

import it.univaq.disim.sose.rest.dto.AuthResponse;

public interface AuthService {

	public AuthResponse getAuth(String authToken);
	
}
