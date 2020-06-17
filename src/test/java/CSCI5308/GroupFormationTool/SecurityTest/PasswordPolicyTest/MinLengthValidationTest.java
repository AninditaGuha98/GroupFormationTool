package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.IPasswordValidation;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinLengthValidation;

class MinLengthValidationTest {

	@Test
	void isValidPasswordTest() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		IPasswordValidation validator = new MinLengthValidation();

		// > 0 minLength
		assertTrue(validator.isValidPassword("1234567890", config));
		assertTrue(validator.isValidPassword("12345678", config));
		assertFalse(validator.isValidPassword("1234567", config));
		assertFalse(validator.isValidPassword("", config));
		assertFalse(validator.isValidPassword(null, config));
	}
	
	@Test void getPasswordValidationMessageTest() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		MinLengthValidation validator = new MinLengthValidation();
		
		assertEquals(validator.getPasswordValidationMessage("1234567", config), 
				String.format(MinLengthValidation.INVALID_PASSWORD_MESSAGE, validator.getMinLength()));
		assertEquals(validator.getPasswordValidationMessage("12345678", config), 
				String.format(MinLengthValidation.VALID_PASSWORD_MESSAGE, validator.getMinLength()));
	}

}
