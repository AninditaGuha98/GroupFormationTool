package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.DefaultPasswordValidationManager;
import CSCI5308.GroupFormationTool.Security.PasswordPolicy.IPasswordValidationManager;

class DefaultPasswordValidationManagerTest {

	@Test
	void isPasswordValidTest() {
		IPasswordValidationManager passwordPolicyManager = new DefaultPasswordValidationManager();
		// No lowercase and uppercase
		assertFalse(passwordPolicyManager.isValidPassword("12345678")); 
		// Less than 8 chars & No lowercase and uppercase
		assertFalse(passwordPolicyManager.isValidPassword("1234567"));
		// No uppercase
		assertFalse(passwordPolicyManager.isValidPassword("abcdefghijkl"));
		// More than 12 chars and No uppercase
		assertFalse(passwordPolicyManager.isValidPassword("abcdefghijklm")); 
		// Less than 2 lowercase
		assertFalse(passwordPolicyManager.isValidPassword("aBCDEFGHIJKL"));
		// Less than 2 uppercase
		assertFalse(passwordPolicyManager.isValidPassword("Abcdefghijkl"));
		// Accepted
		assertTrue(passwordPolicyManager.isValidPassword("abCDE12345"));
		assertTrue(passwordPolicyManager.isValidPassword("abCD1234"));
		assertTrue(passwordPolicyManager.isValidPassword("abCDEFGHIJKL"));
		
		assertFalse(passwordPolicyManager.isValidPassword(""));
		assertFalse(passwordPolicyManager.isValidPassword(null));
	}

}
