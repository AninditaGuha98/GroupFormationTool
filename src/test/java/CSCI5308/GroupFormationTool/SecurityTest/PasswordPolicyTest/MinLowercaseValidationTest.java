package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinLengthValidation;
import CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinLowercaseValidation;

class MinLowercaseValidationTest {

	@Test 
	void minLowercaseValidationDefaultConstructor() {
		MinLowercaseValidation validator = new MinLowercaseValidation();
		assertTrue(validator.getMinLowercase() == 0);
	}
	
	@Test 
	void minLowercaseValidationConstructor() {
		MinLowercaseValidation validator = new MinLowercaseValidation(5);
		assertTrue(validator.getMinLowercase() == 5);
		
		validator = new MinLowercaseValidation(-1);
		assertTrue(validator.getMinLowercase() == 0);
		
		validator = new MinLowercaseValidation(0);
		assertTrue(validator.getMinLowercase() == 0);
		
		validator = new MinLowercaseValidation(10);
		assertTrue(validator.getMinLowercase() == 10);
	}
	
	
	@Test 
	void getMinLowercaseTest() {
		MinLowercaseValidation validator = new MinLowercaseValidation(1);
		assertTrue(validator.getMinLowercase() == 1);
	}
	
	@Test
	void setMinLowercaseTest() {
		MinLowercaseValidation validator = new MinLowercaseValidation();
		
		validator.setMinLowercase(10);
		assertTrue(validator.getMinLowercase() == 10);
		
		validator.setMinLowercase(-1);
		assertTrue(validator.getMinLowercase() == 0);
		
		validator.setMinLowercase(0);
		assertTrue(validator.getMinLowercase() == 0);
	}
	
	@Test
	void isValidPasswordTest() {
		
		// Default constructor leads to no validation checking.
		MinLowercaseValidation validator = new MinLowercaseValidation();
		assertTrue(validator.isValidPassword("raouf"));
		assertTrue(validator.isValidPassword("raouf1234"));
		assertTrue(validator.isValidPassword("raouf12#$"));
		assertTrue(validator.isValidPassword("RAOUF"));
		assertTrue(validator.isValidPassword("1234"));
		assertTrue(validator.isValidPassword("!@#$%"));
		// Null password
		assertFalse(validator.isValidPassword(null));
		
		// a validator with default 4 minimum lowercase letters
		validator = new MinLowercaseValidation(4);
		// 5 lowercase letters 5>4
		assertTrue(validator.isValidPassword("raouf"));
		assertTrue(validator.isValidPassword("raouf1@"));
		// 4 lowercase letters 4=4
		assertTrue(validator.isValidPassword("Raouf"));
		assertTrue(validator.isValidPassword("raOuf"));
		assertTrue(validator.isValidPassword("raouF"));
		assertTrue(validator.isValidPassword("raouF1@"));
		// 3 lowercase letters 3<4
		assertFalse(validator.isValidPassword("RaouF"));
		assertFalse(validator.isValidPassword("RAouf"));
		assertFalse(validator.isValidPassword("rAOuf"));
		assertFalse(validator.isValidPassword("rAouF"));
		assertFalse(validator.isValidPassword("rAouF1@"));
		// 0 lowercase letters 0<4
		assertFalse(validator.isValidPassword("RAOUF"));
		assertFalse(validator.isValidPassword("RAOUF1@"));
		assertFalse(validator.isValidPassword("1234"));
		assertFalse(validator.isValidPassword("!@#$%"));
		// Null password
		assertFalse(validator.isValidPassword(null));
		
		// Negative minimum lowercase leads to no validation checking.
		validator = new MinLowercaseValidation(-1);
		assertTrue(validator.isValidPassword("ra"));
		assertTrue(validator.isValidPassword("ra1234"));
		assertTrue(validator.isValidPassword("ra12#$"));
		assertTrue(validator.isValidPassword("RA"));
		assertTrue(validator.isValidPassword("1234"));
		assertTrue(validator.isValidPassword("!@#$%"));
		// Null password
		assertFalse(validator.isValidPassword(null));
	}
}
