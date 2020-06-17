package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinLengthValidation;

class MinLengthValidationTest {

	@Test 
	void minLengthValidationDefaultConstructor() {
		MinLengthValidation validator = new MinLengthValidation();
		assertTrue(validator.getMinLength() == 0);
	}
	
	@Test 
	void minLengthValidationConstructor() {
		MinLengthValidation validator = new MinLengthValidation("10");
		assertTrue(validator.getMinLength() == 10);
		
		validator = new MinLengthValidation("-1");
		assertTrue(validator.getMinLength() == 0);
		
		validator = new MinLengthValidation("0");
		assertTrue(validator.getMinLength() == 0);
		
		validator = new MinLengthValidation(null);
		assertTrue(validator.getMinLength() == 0);
		
		validator = new MinLengthValidation("4");
		assertTrue(validator.getMinLength() == 4);
	}
	
	
	@Test 
	void getMinLengthTest() {
		MinLengthValidation validator = new MinLengthValidation("5");
		assertTrue(validator.getMinLength() == 5);
	}
	
	@Test
	void setMinLengthTest() {
		MinLengthValidation validator = new MinLengthValidation();
		
		validator.setMinLength(10);
		assertTrue(validator.getMinLength() == 10);
		
		validator.setMinLength(-1);
		assertTrue(validator.getMinLength() == 0);
		
		validator.setMinLength(0);
		assertTrue(validator.getMinLength() == 0);
		
		validator.setMinLength(4);
		assertTrue(validator.getMinLength() == 4);
	}
	
	@Test
	void isValidPasswordTest() {
		
		// Default Constructor
		MinLengthValidation validator = new MinLengthValidation();
		assertTrue(validator.isValidPassword("1234567890"));
		assertTrue(validator.isValidPassword("12345678"));
		assertTrue(validator.isValidPassword("1234567"));
		assertTrue(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword(null));
		
		// Negative minLength
		validator = new MinLengthValidation("-1");
		assertTrue(validator.isValidPassword("1234567890"));
		assertTrue(validator.isValidPassword("12345678"));
		assertTrue(validator.isValidPassword("1234567"));
		assertTrue(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword(null));
		
		// > 0 minLength
		validator = new MinLengthValidation("8");
		assertTrue(validator.isValidPassword("1234567890"));
		assertTrue(validator.isValidPassword("12345678"));
		assertFalse(validator.isValidPassword("1234567"));
		assertFalse(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword(null));
	}
	
	@Test void getPasswordValidationMessageTest() {
		// Default Constructor
		MinLengthValidation validator = new MinLengthValidation("8");
		assertEquals(validator.getPasswordValidationMessage("1234567"), 
				String.format(MinLengthValidation.INVALID_PASSWORD_MESSAGE, validator.getMinLength()));
		assertEquals(validator.getPasswordValidationMessage("12345678"), 
				String.format(MinLengthValidation.VALID_PASSWORD_MESSAGE, validator.getMinLength()));
	}

}
