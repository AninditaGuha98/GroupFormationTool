package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.hamcrest.collection.ArrayAsIterableMatcher;
import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.DefaultPasswordValidationManager;
import CSCI5308.GroupFormationTool.Security.PasswordPolicy.IPasswordValidationManager;

class DefaultPasswordValidationManagerTest {

	@Test
	void isPasswordValidTest() {
		IPasswordValidationManager passwordPolicyManager = new DefaultPasswordValidationManager();
		// No lowercase & uppercase & special chars
		assertFalse(passwordPolicyManager.isValidPassword("12345678")); 
		// Less than 8 chars & No lowercase & uppercase & special chars 
		assertFalse(passwordPolicyManager.isValidPassword("1234567"));
		// No uppercase & special chars
		assertFalse(passwordPolicyManager.isValidPassword("abcdefghijkl"));
		// More than 12 chars & No uppercase & special chars
		assertFalse(passwordPolicyManager.isValidPassword("abcdefghijklm")); 
		// Less than 2 lowercase & no special chars
		assertFalse(passwordPolicyManager.isValidPassword("aBCDEFGHIJKL"));
		// Less than 2 uppercase & no special chars
		assertFalse(passwordPolicyManager.isValidPassword("Abcdefghijkl"));
		// Less than 2 special chars
		assertFalse(passwordPolicyManager.isValidPassword("abCDE12345!"));
		// has & as forbidden chars
		assertFalse(passwordPolicyManager.isValidPassword("&abCDE12345!"));
		// has \ and " as forbidden chars
		assertFalse(passwordPolicyManager.isValidPassword("\"abCD1}234\\"));
		// has ' as forbidden chars
		assertFalse(passwordPolicyManager.isValidPassword("abCD%EFG\'HI"));
		// Accepted
		assertTrue(passwordPolicyManager.isValidPassword("abCD%EFGHI`"));
		
		assertFalse(passwordPolicyManager.isValidPassword(""));
		assertFalse(passwordPolicyManager.isValidPassword(null));
	}
	
	@Test
	void getPasswordValidationFailures() {
		IPasswordValidationManager passwordPolicyManager = new DefaultPasswordValidationManager();

		List<String> messages = passwordPolicyManager.getPasswordValidationFailures("aC%123\'");
		for (String str : messages)
			System.out.println(str);
	}

}
