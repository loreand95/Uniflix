package it.uniflix.userservice.model;

import javax.xml.bind.annotation.XmlRootElement;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@XmlRootElement(name="User")
public class User {
	
	private String id;
	
	private String email;
	
	private String password;
	
	private String token;
	
	private String fullname;



	public User() {}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
