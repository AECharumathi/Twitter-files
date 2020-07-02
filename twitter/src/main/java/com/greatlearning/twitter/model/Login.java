package com.greatlearning.twitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

public class Login {
	
	@Getter @Setter
	@JsonProperty("user_email")
	private String email;
	
	@Getter @Setter
	@JsonProperty("user_pass")
	private String encryptedPassword;

	@Override
	public String toString() {
		return "Login [email=" + email + ", password=" + encryptedPassword + "]";
	}

	public String getEncryptedPassword() {
		return this.encryptedPassword;
	}

	public String getemail() {
		return this.email;
	}
	
}
