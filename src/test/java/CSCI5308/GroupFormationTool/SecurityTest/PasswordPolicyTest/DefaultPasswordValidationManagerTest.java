package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.DefaultPasswordValidationManager;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.IPasswordValidationManager;

class DefaultPasswordValidationManagerTest {

	private final String INVALID_OUTPUT_DEFCONFIG = 
			"Password must have minimum length of 8." +
			"Password must have minimum 2 lowercase letters." + 
			"Password must have minimum 2 uppercase letters." +
			"Password has forbidden characters \"\\&\"'\".";
	
	private final String VALID_OUTPUT_DEFCONFIG = ""; 
	
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
		List<String> outputList;
		String output = "";
		outputList = passwordPolicyManager.getPasswordValidationFailures("MEssi!@#4");
		for( String str: outputList) {
			output+=str;
		}
		assertEquals(VALID_OUTPUT_DEFCONFIG, output);
		
		output = "";
		outputList = passwordPolicyManager.getPasswordValidationFailures("aC%123\\");
		for( String str: outputList) {
			output+=str;
		}
		assertEquals(INVALID_OUTPUT_DEFCONFIG, output);
	}

}
