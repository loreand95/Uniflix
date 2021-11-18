package it.uniflix.userservice.controller.rest.impl;

import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import it.uniflix.userservice.controller.rest.UserController;
import it.uniflix.userservice.dto.AvailableFieldsReq;
import it.uniflix.userservice.model.AuthUser;
import it.uniflix.userservice.model.Movie;
import it.uniflix.userservice.model.User;
import it.uniflix.userservice.service.UserService;
import it.uniflix.userservice.service.impl.UserServiceImpl;



public class UserControllerImpl implements UserController{

	@Context
	HttpServletRequest httpServletRequest;

	private UserService userService;

	public UserControllerImpl() {
		userService = new UserServiceImpl();
	}

	@Override
	public Response signUp(User user) {

		user = userService.signUp(user);
		
		if(user == null) {
			return Response.status(500).build();
		}

		return Response.ok(user).build();
	}

	@Override
	public Response signIn(User user) {

		user = userService.signIn(user);

		if(user == null) {
			return Response.status(404,"User Not Found!").build();
		}

		return Response.ok(user, MediaType.APPLICATION_JSON).build();
	}

	@Override	
	public Response library() {

		String userId = (String) httpServletRequest.getAttribute("userId");
		
		if(userId != null) {
			Set<Movie> listMovie = userService.getLibrary(userId);

			return Response.ok(listMovie, MediaType.APPLICATION_JSON).build();
		}else {
			return Response.status(401).build();
		}
	}

	@Override
	public Response isAuth() {
		
		String userId = (String) httpServletRequest.getAttribute("userId");
		
		AuthUser authUser = new AuthUser();
		
		if(userId!=null) {
			authUser.setAuth(true);
			authUser.setUserId(userId);
		}else {
			authUser.setAuth(false);
		}
		
		return Response.ok(authUser, MediaType.APPLICATION_JSON).build();
	}

	@Override
	public Response available(AvailableFieldsReq fields) {
		// TODO Auto-generated method stub
		
		
		
		return Response.ok(userService.available(fields), MediaType.APPLICATION_JSON).build();
	}
}