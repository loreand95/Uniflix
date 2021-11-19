package it.univaq.disim.sose.rest.controller.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.univaq.disim.sose.rest.dto.AuthResponse;
import it.univaq.disim.sose.rest.service.AuthService;
import it.univaq.disim.sose.rest.service.impl.AuthServiceImpl;


public class SecurityFilter implements Filter{  

	public void init(FilterConfig arg0) throws ServletException {}  

	public void doFilter(ServletRequest req, ServletResponse resp,  
			FilterChain chain) throws IOException, ServletException {  

		HttpServletRequest httpRequest = (HttpServletRequest) req;

		String authTokenHeader = httpRequest.getHeader("Authorization");

		if (authTokenHeader != null && authTokenHeader.startsWith("Bearer ")) {

			AuthService authService = new AuthServiceImpl();
			
			AuthResponse authResponse = authService.getAuth(authTokenHeader);
			
			req.setAttribute("userId", authResponse.getUserId());
			
		}else {
			
			if(httpRequest.getRequestURI().contains("/buy")) {
				//System.out.println("----------------------- FILTER ERRORE SC_UNAUTHORIZED IF");
			((HttpServletResponse) resp).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
			return;
			}
		}

		chain.doFilter(req, resp);	//Next
	}  
	public void destroy() {}  
}  