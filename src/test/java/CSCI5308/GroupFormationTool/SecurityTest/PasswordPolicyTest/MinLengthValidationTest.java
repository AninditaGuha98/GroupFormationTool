package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinLengthValidation;

class MinLengthValidationTest {

	@Test 
	void minLengthValidationDefaultConstructor() {
		MinLengthValidation validator = new MinLengthValidation();
		assertTrue(validator.getMinLength() == 8);
	}
	
	@Test 
	void minLengthValidationConstructor() {
		MinLengthValidation validator = new MinLengthValidation(10);
		assertTrue(validator.getMinLength() == 10);
		
		validator = new MinLengthValidation(-1);
		assertTrue(validator.getMinLength() == 8);
		
		validator = new MinLengthValidation(0);
		assertTrue(validator.getMinLength() == 8);
		
		validator = new MinLengthValidation(4);
		assertTrue(validator.getMinLength() == 4);
	}
	
	
	@Test 
	void getMinLengthTest() {
		MinLengthValidation validator = new MinLengthValidation(5);
		assertTrue(validator.getMinLength() == 5);
	}
	
	@Test
	void setMinLengthTest() {
		MinLengthValidation validator = new MinLengthValidation();
		
		validator.setMinLength(10);
		assertTrue(validator.getMinLength() == 10);
		
		validator.setMinLength(-1);
		assertTrue(validator.getMinLength() == 8);
		
		validator.setMinLength(0);
		assertTrue(validator.getMinLength() == 8);
		
		validator.setMinLength(4);
		assertTrue(validator.getMinLength() == 4);
	}
	
	@Test
	void isValidPasswordTest() {
		MinLengthValidation validator = new MinLengthValidation();
		
		assertTrue(validator.isValidPassword("1234567890"));
		assertTrue(validator.isValidPassword("12345678"));
		assertFalse(validator.isValidPassword("1234567"));
		assertFalse(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword(null));
	}

}
