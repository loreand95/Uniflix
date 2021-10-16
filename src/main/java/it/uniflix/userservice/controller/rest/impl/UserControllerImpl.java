package it.uniflix.userservice.controller.rest.impl;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import it.uniflix.userservice.controller.rest.UserController;
import it.uniflix.userservice.model.User;
import it.uniflix.userservice.service.UserService;
import it.uniflix.userservice.service.impl.UserServiceImpl;



public class UserControllerImpl implements UserController{

    @Context
    HttpServletRequest httpServletRequest;
    
	public User test() {
		
		//UserService userService = new UserServiceImpl();
		
		
		
		Enumeration<String> v = httpServletRequest.getAttributeNames();
		
		System.out.println("ok");
		
		return null;
	}
	
	public Response signUp(User user) {
		
		UserService userService = new UserServiceImpl();
		user = userService.signUp(user);
		
		return Response.ok(null, MediaType.APPLICATION_JSON).build();
	}

	public Response signIn(User user) {
		
		
		UserService userService = new UserServiceImpl();
		user = userService.signIn(user);

		if(user == null) return Response.status(404,"User Not Found!").build();
		
		return Response.ok(user, MediaType.APPLICATION_JSON).build();
	}
	

	public Response getLibrary() {
		
		//UserService userService = new UserServiceImpl();
		
		Enumeration<String> v = httpServletRequest.getAttributeNames();
		
		System.out.println("ok");
		
		return null;
	}

}