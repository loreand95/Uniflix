package it.univaq.disim.sose.rest.service.impl;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import it.univaq.disim.sose.rest.model.Order;
import it.univaq.disim.sose.rest.model.Payment;
import it.univaq.disim.sose.rest.model.MovieBO;
import it.univaq.disim.sose.rest.service.PaymentService;
import it.univaq.disim.sose.rest.utils.EndPointApi;

public class PaymentServiceImpl implements PaymentService {


	public String buyMovie(String token,String UserId){	
		WebClient client = WebClient.create( EndPointApi.PAY_SERVICE_BUY);
		client.header("Authorization", token);
		client.header("Content-Type", "application/json");
		client.accept(MediaType.APPLICATION_JSON);
		Payment payment = new Payment();
		payment.setAmount(10);
		payment.setUserId(UserId);
		Gson gson = new Gson();
		//System.out.println("-------------- JSON "+gson.toJson(payment, Payment.class));
		Response response = client.accept(MediaType.APPLICATION_JSON).post(gson.toJson(payment, Payment.class));		
		String value = response.readEntity(String.class);
		//System.out.println("-------------- TOKEN "+token);
		//System.out.println("-------------- response PAY_SERVICE_BUY"+value);
		return value;
	}

}
