package CSCI5308.GroupFormationTool.SecurityTest.PasswordValidationPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.DefaultPasswordValidationManager;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidationManager;

class DefaultPasswordValidationManagerTest {

	private final String INVALID_OUTPUT_DEFCONFIG = 
			"Password must have minimum length of 8." +
			"Password must have minimum 2 lowercase letters." + 
			"Password must have minimum 2 uppercase letters." +
			"Password has forbidden characters \"\\&\"'\".";
	
	private final String VALID_OUTPUT_DEFCONFIG = ""; 
	
	@Test
	void isPasswordValidTest() {
		IPasswordValidationConfiguration config = new PasswordValidationConfigurationMock();
		IPasswordValidationManager passwordPolicyManager = new DefaultPasswordValidationManager();
		
		// No lowercase & uppercase & special chars
		assertFalse(passwordPolicyManager.isValidPassword("12345678", config)); 
		// Less than 8 chars & No lowercase & uppercase & special chars 
		assertFalse(passwordPolicyManager.isValidPassword("1234567", config));
		// No uppercase & special chars
		assertFalse(passwordPolicyManager.isValidPassword("abcdefghijkl", config));
		// More than 12 chars & No uppercase & special chars
		assertFalse(passwordPolicyManager.isValidPassword("abcdefghijklm", config)); 
		// Less than 2 lowercase & no special chars
		assertFalse(passwordPolicyManager.isValidPassword("aBCDEFGHIJKL", config));
		// Less than 2 uppercase & no special chars
		assertFalse(passwordPolicyManager.isValidPassword("Abcdefghijkl", config));
		// Less than 2 special chars
		assertFalse(passwordPolicyManager.isValidPassword("abCDE12345!", config));
		// has & as forbidden chars
		assertFalse(passwordPolicyManager.isValidPassword("&abCDE12345!", config));
		// has \ and " as forbidden chars
		assertFalse(passwordPolicyManager.isValidPassword("\"abCD1}234\\", config));
		// has ' as forbidden chars
		assertFalse(passwordPolicyManager.isValidPassword("abCD%EFG\'HI", config));
		// Accepted
		assertTrue(passwordPolicyManager.isValidPassword("abCD%EFGHI`", config));
		
		assertFalse(passwordPolicyManager.isValidPassword("", config));
		assertFalse(passwordPolicyManager.isValidPassword(null, config));
	}
	
	@Test
	void getPasswordValidationFailures() {
		IPasswordValidationConfiguration config = new PasswordValidationConfigurationMock();
		IPasswordValidationManager passwordPolicyManager = new DefaultPasswordValidationManager();
		List<String> outputList;
		String output = "";
		
		outputList = passwordPolicyManager.getPasswordValidationFailures("MEssi!@#4", config);
		for( String str: outputList) {
			output += str;
		}
		assertEquals(VALID_OUTPUT_DEFCONFIG, output);
		
		output = "";
		outputList = passwordPolicyManager.getPasswordValidationFailures("aC%123\\", config);
		for( String str: outputList) {
			output+=str;
		}
		assertEquals(INVALID_OUTPUT_DEFCONFIG, output);
	}

}
