package it.uniflix.userservice.controller.rest;


import java.io.IOException;
import java.security.Key;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;


public class SecurityFilter implements Filter{  

	public void init(FilterConfig arg0) throws ServletException {}  

	public void doFilter(ServletRequest req, ServletResponse resp,  
			FilterChain chain) throws IOException, ServletException {  

		HttpServletRequest httpRequest = (HttpServletRequest) req;
		Enumeration<String> headerNames = httpRequest.getHeaderNames();

		String authTokenHeader = httpRequest.getHeader("Authorization");

		if (authTokenHeader != null && authTokenHeader.startsWith("Bearer ")) {
			String token = authTokenHeader.substring("Bearer".length()).trim();

			Key key = JWTHelpers.getInstance().getJwtKey();
			
			try{
				Jws<Claims> jwsc = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
				String ok =jwsc.getBody().toString();
				
				req.setAttribute("body", ok);
				
			}catch(Exception ex) {
				
				//ex.printStackTrace();
				
				((HttpServletResponse) resp).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
				return;
			}
		}

		chain.doFilter(req, resp);//next
	}  
	public void destroy() {}  
}  