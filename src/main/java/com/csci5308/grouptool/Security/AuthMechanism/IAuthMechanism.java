package com.csci5308.grouptool.Security.AuthMechanism;

import java.util.List;

public interface IAuthMechanism {
	
	public boolean isAvailableUser(String userEmail);
	public boolean isValidUser(String userEmail, String password);
	public List<String> getUserRoles(String userEmail);
	
}
