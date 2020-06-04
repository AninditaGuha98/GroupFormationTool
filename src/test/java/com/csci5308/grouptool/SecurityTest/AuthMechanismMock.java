package com.csci5308.grouptool.SecurityTest;

import java.util.Arrays;
import java.util.List;

import com.csci5308.grouptool.Security.IAuthMechanism;

public class AuthMechanismMock implements IAuthMechanism {

	@Override
	public boolean isAvailableUser(String userEmail) {
		boolean isAvailable = false;
		if (userEmail.equalsIgnoreCase("raouf@example.com"))
			isAvailable = true;
		return isAvailable;
	}

	@Override
	public boolean isValidUser(String userEmail, String password) {
		boolean isValidUser = false;
		if (this.isAvailableUser(userEmail))
				if (password.equals("1234"))
					isValidUser = true;
		return isValidUser;
	}

	@Override
	public List<String> getUserRoles(String userEmail) {
		List<String> rolesList = Arrays.asList( "ADMIN", "INSTRUCTOR", "TA");
		if (this.isAvailableUser(userEmail)) {
			return rolesList;
		}
		return null;
	}

}
