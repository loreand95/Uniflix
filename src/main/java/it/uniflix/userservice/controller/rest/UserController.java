package it.uniflix.userservice.controller.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import it.uniflix.userservice.model.User;

@Path("/userservice")
public interface UserController {
	
	@POST
	@Path("/signin")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)
	Response signIn(User user);
	
	@POST
	@Path("/signup")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes(MediaType.APPLICATION_JSON)
	Response signUp(User user);
	
	@GET
	@Path("/library")
	@Produces({MediaType.APPLICATION_JSON})
	Response library();
}
