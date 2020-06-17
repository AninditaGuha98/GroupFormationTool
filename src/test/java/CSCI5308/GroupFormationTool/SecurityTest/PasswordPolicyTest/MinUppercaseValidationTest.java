package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinUppercaseValidation;

class MinUppercaseValidationTest {

	@Test
	void isValidPasswordTest() {
		IPasswordValidationConfiguration config = new PasswordValidationConfigurationMock();
		MinUppercaseValidation validator = new MinUppercaseValidation();
		
		// 2 uppercase letters 2 == 2
		assertTrue(validator.isValidPassword("RaouF", config));
		assertTrue(validator.isValidPassword("RAouf", config));
		assertTrue(validator.isValidPassword("rAOuf", config));
		assertTrue(validator.isValidPassword("rAouF", config));
		assertTrue(validator.isValidPassword("rAouF1@", config));
		// 1 lowercase letters 1 < 2
		assertFalse(validator.isValidPassword("raouF", config));
		assertFalse(validator.isValidPassword("raoufF1@", config));
		assertFalse(validator.isValidPassword("A1234", config));
		assertFalse(validator.isValidPassword("I!@#$%", config));
		// Null password
		assertFalse(validator.isValidPassword(null, config));
	}
	
	@Test
	void getValidationMessageTest() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		MinUppercaseValidation validator = new MinUppercaseValidation();
		
		// 4 uppercase letters 4 > 2
		assertEquals(validator.getPasswordValidationMessage("rAOUF", config),
				String.format(MinUppercaseValidation.VALID_PASSWORD_MESSAGE, validator.getMinUppercase()));
		// 1 uppercase letter 1 < 2
		assertEquals(validator.getPasswordValidationMessage("raOuf", config),
				String.format(MinUppercaseValidation.INVALID_PASSWORD_MESSAGE, validator.getMinUppercase()));
	}
}
