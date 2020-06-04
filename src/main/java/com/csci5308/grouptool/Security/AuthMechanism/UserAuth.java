package com.csci5308.grouptool.Security.AuthMechanism;

import java.util.List;

public class UserAuth {
	
	private String providedEmail = null;
	private String providedPassword = null;
	private boolean isUserValid = false;
	private boolean isUserAvailable = false;
	private List<String> roles = null;
	
	public UserAuth() {
		
	}
	
	public UserAuth(String providedEmail, String providedPassword) {
		this(providedEmail, providedPassword, null);
	}
	
	public UserAuth(String providedEmail, String providedPassword, IAuthMechanism mechanism) {
		// Update the isUserAvailable
		// Update the isUserValid
		this.providedEmail = providedEmail;
		this.providedPassword = providedPassword;
		if (mechanism != null) {
			this.isUserAvailable = mechanism.isAvailableUser(providedEmail);
			this.isUserValid = mechanism.isValidUser(providedEmail, providedPassword);
			this.roles = mechanism.getUserRoles(providedEmail);
		}
	}
	
	public String getProvidedEmail() {
		return providedEmail;
	}
	
	public void setProvidedEmail(String providedEmail) {
		this.providedEmail = providedEmail;
	}

	public String getProvidedPassword() {
		return providedPassword;
	}

	public void setProvidedPassword(String providedPassword) {
		this.providedPassword = providedPassword;
	}

	public boolean isUserAvailable() {
		return this.isUserAvailable;
	}
	
	public boolean isUserValid() {
		return this.isUserValid;
	}

	public List<String> getRoles() {
		return this.roles;
	}
	
}
