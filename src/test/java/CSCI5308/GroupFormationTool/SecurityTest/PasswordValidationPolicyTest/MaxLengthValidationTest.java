package CSCI5308.GroupFormationTool.SecurityTest.PasswordValidationPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MaxLengthValidation;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinLengthValidation;

class MaxLengthValidationTest {

	@Test
	void isValidPasswordTest() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		MaxLengthValidation validator = new MaxLengthValidation();
		
		assertTrue(validator.isValidPassword("abcdefghijkl", config));
		assertTrue(validator.isValidPassword("abcdefghijk", config));
		assertFalse(validator.isValidPassword("abcdefghijklm", config));
		assertTrue(validator.isValidPassword("", config));
		assertFalse(validator.isValidPassword(null, config));
	}
	
	@Test 
	void getMaxLengthTest() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		MaxLengthValidation validator = new MaxLengthValidation();
		assertTrue(validator.isValidPassword("abcdefghijkl", config));
		assertEquals(12, validator.getMaxLength());
	}
	
	@Test
	void getPasswordValidationMessage() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		MaxLengthValidation validator = new MaxLengthValidation();
		
		assertEquals(validator.getPasswordValidationMessage("abcdefghijkl", config),
				String.format(MaxLengthValidation.VALID_PASSWORD_MESSAGE, validator.getMaxLength()));
		assertEquals(validator.getPasswordValidationMessage("abcdefghijklmn", config),
				String.format(MaxLengthValidation.INVALID_PASSWORD_MESSAGE, validator.getMaxLength()));
	}

}
