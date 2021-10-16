package it.uniflix.userservice.controller.rest.filter;


import java.io.IOException;
import java.security.Key;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import it.uniflix.userservice.utils.JWTHelpers;


public class SecurityFilter implements Filter{  

	public void init(FilterConfig arg0) throws ServletException {}  

	public void doFilter(ServletRequest req, ServletResponse resp,  
			FilterChain chain) throws IOException, ServletException {  

		HttpServletRequest httpRequest = (HttpServletRequest) req;

		String authTokenHeader = httpRequest.getHeader("Authorization");

		if (authTokenHeader != null && authTokenHeader.startsWith("Bearer ")) {
			String token = authTokenHeader.substring("Bearer".length()).trim();

			Key key = JWTHelpers.getInstance().getJwtKey();
			
			try{
				Jws<Claims> jwsc = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
				req.setAttribute("userId", jwsc.getBody().getId());
			}catch(Exception ex) {
				
				ex.printStackTrace();
				
				((HttpServletResponse) resp).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
				return;
			}
		}else {
			((HttpServletResponse) resp).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
			return;
		}

		chain.doFilter(req, resp);	//Next
	}  
	public void destroy() {}  
}  