package it.uniflix.userservice.model;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@XmlRootElement(name="AuthUser")
@JsonInclude(Include.NON_NULL)
public class AuthUser {

	private boolean isAuth;

	private String userId;

	public boolean isAuth() {
		return isAuth;
	}

	public AuthUser() {}
	
	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
