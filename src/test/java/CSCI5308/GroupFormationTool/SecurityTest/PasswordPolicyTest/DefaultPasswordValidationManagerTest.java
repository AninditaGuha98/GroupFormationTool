package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.DefaultPasswordValidationManager;
import CSCI5308.GroupFormationTool.Security.PasswordPolicy.IPasswordValidationManager;

class DefaultPasswordValidationManagerTest {

	@Test
	void isPasswordValidTest() {
		IPasswordValidationManager passwordPolicyManager = new DefaultPasswordValidationManager();
		// No lowercase
		assertFalse(passwordPolicyManager.isValidPassword("12345678")); 
		// Less than 8 chars & No lowercase
		assertFalse(passwordPolicyManager.isValidPassword("1234567")); 
		assertTrue(passwordPolicyManager.isValidPassword("abcdefghijkl"));
		// More than 12 chars
		assertFalse(passwordPolicyManager.isValidPassword("abcdefghijklm")); 
		assertTrue(passwordPolicyManager.isValidPassword("abCDEFGHIJKL"));
		// Less than 2 lowercase
		assertFalse(passwordPolicyManager.isValidPassword("aBCDEFGHIJKL"));
		assertFalse(passwordPolicyManager.isValidPassword(""));
		assertFalse(passwordPolicyManager.isValidPassword(null));
	}

}
