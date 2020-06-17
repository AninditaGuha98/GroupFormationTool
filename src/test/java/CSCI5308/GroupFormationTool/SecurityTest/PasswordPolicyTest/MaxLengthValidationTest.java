package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MaxLengthValidation;

class MaxLengthValidationTest {

	@Test 
	void maxLengthValidationDefaultConstructor() {
		MaxLengthValidation validator = new MaxLengthValidation();
		assertTrue(validator.getMaxLength() == 0);
	}
	
	@Test 
	void maxLengthValidationConstructor() {
		MaxLengthValidation validator = new MaxLengthValidation("20");
		assertTrue(validator.getMaxLength() == 20);
		
		validator = new MaxLengthValidation("-1");
		assertTrue(validator.getMaxLength() == 0);
		
		validator = new MaxLengthValidation("0");
		assertTrue(validator.getMaxLength() == 0);
		
		validator = new MaxLengthValidation(null);
		assertTrue(validator.getMaxLength() == 0);
	}
	
	
	@Test 
	void getMaxLengthTest() {
		MaxLengthValidation validator = new MaxLengthValidation("8");
		assertTrue(validator.getMaxLength() == 8);
	}
	
	@Test
	void setMaxLengthTest() {
		MaxLengthValidation validator = new MaxLengthValidation();
		
		validator.setMaxLength(20);
		assertTrue(validator.getMaxLength() == 20);
		
		validator.setMaxLength(-1);
		assertTrue(validator.getMaxLength() == 0);
		
		validator.setMaxLength(0);
		assertTrue(validator.getMaxLength() == 0);
	}
	
	@Test
	void isValidPasswordTest() {

		MaxLengthValidation validator = new MaxLengthValidation("12");
		assertTrue(validator.isValidPassword("abcdefghijkl"));
		assertTrue(validator.isValidPassword("abcdefghij"));
		assertFalse(validator.isValidPassword("abcdefghijklmn"));
		assertTrue(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword(null));

		
		// Default constructor
		validator = new MaxLengthValidation();
		assertTrue(validator.isValidPassword("abcdefghijkl"));
		assertTrue(validator.isValidPassword("abcdefghij"));
		assertTrue(validator.isValidPassword("abcdefghijklmn"));
		assertTrue(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword(null));
		
		validator = new MaxLengthValidation("-1");
		assertTrue(validator.isValidPassword("abcdefghijkl"));
		assertTrue(validator.isValidPassword("abcdefghij"));
		assertTrue(validator.isValidPassword("abcdefghijklmn"));
		assertTrue(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword(null));
	}
	
	@Test
	void getPasswordValidationMessage() {
		MaxLengthValidation validator = new MaxLengthValidation("12");
		assertEquals(validator.getPasswordValidationMessage("abcdefghijkl"),
				String.format(MaxLengthValidation.VALID_PASSWORD_MESSAGE, validator.getMaxLength()));
		assertEquals(validator.getPasswordValidationMessage("abcdefghijklmn"),
				String.format(MaxLengthValidation.INVALID_PASSWORD_MESSAGE, validator.getMaxLength()));
	}

}
