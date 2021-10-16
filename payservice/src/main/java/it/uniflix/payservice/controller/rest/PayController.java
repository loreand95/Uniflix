package it.uniflix.payservice.controller.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.uniflix.payservice.model.Payment;

@Path("/payments")
public interface PayController {

	@POST
	@Path("/pay")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Response pay(Payment payment);
}
