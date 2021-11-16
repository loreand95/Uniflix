package it.uniflix.payservice.service;

import it.uniflix.payservice.dto.AuthResponse;


public interface AuthService {

	public AuthResponse getAuth(String authToken);
	
}
