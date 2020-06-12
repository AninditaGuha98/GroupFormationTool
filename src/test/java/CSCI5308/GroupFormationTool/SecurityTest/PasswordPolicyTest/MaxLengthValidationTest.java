package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.MaxLengthValidation;
import CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinLengthValidation;

class MaxLengthValidationTest {

	@Test 
	void maxLengthValidationDefaultConstructor() {
		MaxLengthValidation validator = new MaxLengthValidation();
		assertTrue(validator.getMaxLength() == 12);
	}
	
	@Test 
	void maxLengthValidationConstructor() {
		MaxLengthValidation validator = new MaxLengthValidation(20);
		assertTrue(validator.getMaxLength() == 20);
		
		validator = new MaxLengthValidation(-1);
		assertTrue(validator.getMaxLength() == 12);
		
		validator = new MaxLengthValidation(0);
		assertTrue(validator.getMaxLength() == 12);
		
		validator = new MaxLengthValidation(4);
		assertTrue(validator.getMaxLength() == 4);
	}
	
	
	@Test 
	void getMaxLengthTest() {
		MaxLengthValidation validator = new MaxLengthValidation(8);
		assertTrue(validator.getMaxLength() == 8);
	}
	
	@Test
	void setMaxLengthTest() {
		MaxLengthValidation validator = new MaxLengthValidation();
		
		validator.setMaxLength(20);
		assertTrue(validator.getMaxLength() == 20);
		
		validator.setMaxLength(-1);
		assertTrue(validator.getMaxLength() == 12);
		
		validator.setMaxLength(0);
		assertTrue(validator.getMaxLength() == 12);
		
		validator.setMaxLength(8);
		assertTrue(validator.getMaxLength() == 8);
	}
	
	@Test
	void isValidPasswordTest() {
		MaxLengthValidation validator = new MaxLengthValidation();
		
		assertTrue(validator.isValidPassword("abcdefghijkl"));
		assertTrue(validator.isValidPassword("abcdefghij"));
		assertFalse(validator.isValidPassword("abcdefghijklmn"));
		assertFalse(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword(null));
	}

}
