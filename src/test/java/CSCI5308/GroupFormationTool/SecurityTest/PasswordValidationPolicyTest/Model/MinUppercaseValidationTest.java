package CSCI5308.GroupFormationTool.SecurityTest.PasswordValidationPolicyTest.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model.MinUppercaseValidation;
import CSCI5308.GroupFormationTool.SecurityTest.PasswordValidationPolicyTest.PasswordValidationConfigurationMock;

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
	void getMinUppercaseTest() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		MinUppercaseValidation validator = new MinUppercaseValidation();
		assertTrue(validator.isValidPassword("RaouF", config));
		assertEquals(2, validator.getMinUppercase());
	}
	
	@Test
	void getValidationMessageTest() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		MinUppercaseValidation validator = new MinUppercaseValidation();
		
		// 4 uppercase letters 4 > 2
		assertEquals(validator.getValidationFailureMessage("rAOUF", config),
				String.format(MinUppercaseValidation.VALID_PASSWORD_MESSAGE, validator.getMinUppercase()));
		// 1 uppercase letter 1 < 2
		assertEquals(validator.getValidationFailureMessage("raOuf", config),
				String.format(MinUppercaseValidation.INVALID_PASSWORD_MESSAGE, validator.getMinUppercase()));
	}
}
