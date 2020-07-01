package CSCI5308.GroupFormationTool.PasswordValidationPolicyTest.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model.MinNonAlphaNumValidation;
import CSCI5308.GroupFormationTool.PasswordValidationPolicyTest.Model.PasswordValidationConfigurationMock;

class MinNonAlphaNumValidationTest {

	@Test
	void isValidPasswordTest() {
		IPasswordValidationConfiguration config = new PasswordValidationConfigurationMock();
		MinNonAlphaNumValidation validator = new MinNonAlphaNumValidation();
		
		assertTrue(validator.isValidPassword("#Messi!", config));
		assertTrue(validator.isValidPassword("%me@SSi", config));
		assertTrue(validator.isValidPassword("me.ssi)", config));
		assertTrue(validator.isValidPassword("'?messI", config));
		assertTrue(validator.isValidPassword("me+}ssi", config));
		assertTrue(validator.isValidPassword("messi&$", config));

		assertFalse(validator.isValidPassword("^messi", config));
		assertFalse(validator.isValidPassword("me`ssi", config));
		assertFalse(validator.isValidPassword("messi~", config));
		assertFalse(validator.isValidPassword("Me.ssi123", config));

		assertFalse(validator.isValidPassword("MESsI", config));
		assertFalse(validator.isValidPassword("12345", config));
		assertFalse(validator.isValidPassword("", config));
		
		assertFalse(validator.isValidPassword(null, config));
	}
	
	@Test 
	void getMinNonAlphaNumTest() {
		IPasswordValidationConfiguration config = new  PasswordValidationConfigurationMock();
		MinNonAlphaNumValidation validator = new MinNonAlphaNumValidation();
		assertTrue(validator.isValidPassword("#Messi!", config));
		assertEquals(2, validator.getMinNonAlphaNum());
	}
	
	@Test
	void getValidationMessageTest() {
		IPasswordValidationConfiguration config = new PasswordValidationConfigurationMock();
		MinNonAlphaNumValidation validator = new MinNonAlphaNumValidation();
		
		assertEquals(validator.getValidationFailureMessage("#RAOUf@", config),
				String.format(MinNonAlphaNumValidation.VALID_PASSWORD_MESSAGE, validator.getMinNonAlphaNum()));
		assertEquals(validator.getValidationFailureMessage("RaOu`f", config),
				String.format(MinNonAlphaNumValidation.INVALID_PASSWORD_MESSAGE, validator.getMinNonAlphaNum()));
	}
}