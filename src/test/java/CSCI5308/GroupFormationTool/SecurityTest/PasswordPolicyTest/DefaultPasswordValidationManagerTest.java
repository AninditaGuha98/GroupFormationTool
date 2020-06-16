package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.DefaultPasswordValidationManager;
import CSCI5308.GroupFormationTool.Security.PasswordPolicy.IPasswordValidationManager;

class DefaultPasswordValidationManagerTest {

	@Test
	void isPasswordValidTest() {
		IPasswordValidationManager passwordPolicyManager = new DefaultPasswordValidationManager();
		assertTrue(passwordPolicyManager.isValidPassword("12345678"));
		assertFalse(passwordPolicyManager.isValidPassword("1234567"));
		assertTrue(passwordPolicyManager.isValidPassword("abcdefghijkl"));
		assertFalse(passwordPolicyManager.isValidPassword("abcdefghijklm"));
		assertFalse(passwordPolicyManager.isValidPassword(""));
		assertFalse(passwordPolicyManager.isValidPassword(null));
	}

}
