package it.uniflix.payservice.service.impl;

import java.io.IOException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.uniflix.payservice.dto.AuthResponse;
import it.uniflix.payservice.service.AuthService;

public class AuthServiceImpl implements AuthService{

	private static final String ENDPOINT = "http://localhost:8080/userservice/rest/isauth";

	@Override
	public AuthResponse getAuth(String authToken) {

		Client client = ClientBuilder.newClient();

		String response = client
				.target(ENDPOINT)
				.request()
				.accept("application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", authToken)
				.post(null,String.class);

		AuthResponse authResponse = null;
		try {
			authResponse = new ObjectMapper().readValue(response, AuthResponse.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return authResponse;
	}
}
