package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinLowercaseValidation;
import CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinUppercaseValidation;

class MinUppercaseValidationTest {

	@Test 
	void minUppercaseValidationDefaultConstructor() {
		MinUppercaseValidation validator = new MinUppercaseValidation();
		assertTrue(validator.getMinUppercase() == 0);
	}
	
	@Test 
	void minUppercaseValidationConstructor() {
		MinUppercaseValidation validator = new MinUppercaseValidation("4");
		assertTrue(validator.getMinUppercase() == 4);
		
		validator = new MinUppercaseValidation("-1");
		assertTrue(validator.getMinUppercase() == 0);
		
		validator = new MinUppercaseValidation("0");
		assertTrue(validator.getMinUppercase() == 0);
		
		validator = new MinUppercaseValidation("10");
		assertTrue(validator.getMinUppercase() == 10);
	}
	
	
	@Test 
	void getMinUppercaseTest() {
		MinUppercaseValidation validator = new MinUppercaseValidation("1");
		assertTrue(validator.getMinUppercase() == 1);
	}
	
	@Test
	void setMinUppercaseTest() {
		MinUppercaseValidation validator = new MinUppercaseValidation();
		
		validator.setMinUppercase(10);
		assertTrue(validator.getMinUppercase() == 10);
		
		validator.setMinUppercase(-1);
		assertTrue(validator.getMinUppercase() == 0);
		
		validator.setMinUppercase(0);
		assertTrue(validator.getMinUppercase() == 0);
	}
	
	@Test
	void isValidPasswordTest() {
		
		// Default constructor leads to no validation checking.
		MinUppercaseValidation validator = new MinUppercaseValidation();
		assertTrue(validator.isValidPassword("RAOUF"));
		assertTrue(validator.isValidPassword("RAOUF1234"));
		assertTrue(validator.isValidPassword("RAOUF12#$"));
		assertTrue(validator.isValidPassword("raouf"));
		assertTrue(validator.isValidPassword("1234"));
		assertTrue(validator.isValidPassword("!@#$%"));
		assertTrue(validator.isValidPassword(""));
		// Null password
		assertFalse(validator.isValidPassword(null));
		
		// a validator with 4 minimum uppercase letters
		validator = new MinUppercaseValidation("4");
		// 5 uppercase letters 5>4
		assertTrue(validator.isValidPassword("RAOUF"));
		assertTrue(validator.isValidPassword("RAOUF1@"));
		// 4 uppercase letters 4=4
		assertTrue(validator.isValidPassword("rAOUF"));
		assertTrue(validator.isValidPassword("RAoUF"));
		assertTrue(validator.isValidPassword("RAOUf"));
		assertTrue(validator.isValidPassword("RAOUf1@"));
		// 3 uppercase letters 3<4
		assertFalse(validator.isValidPassword("rAOUf"));
		assertFalse(validator.isValidPassword("raOUF"));
		assertFalse(validator.isValidPassword("RaoUF"));
		assertFalse(validator.isValidPassword("RaUoF"));
		assertFalse(validator.isValidPassword("RaOUf1@"));
		// 0 lowercase letters 0<4
		assertFalse(validator.isValidPassword("raouf"));
		assertFalse(validator.isValidPassword("raouf1@"));
		assertFalse(validator.isValidPassword("1234"));
		assertFalse(validator.isValidPassword("!@#$%"));
		assertFalse(validator.isValidPassword(""));
		// Null password
		assertFalse(validator.isValidPassword(null));
		
		// Negative minimum uppercase leads to no validation checking.
		validator = new MinUppercaseValidation("-1");
		assertTrue(validator.isValidPassword("RA"));
		assertTrue(validator.isValidPassword("RA1234"));
		assertTrue(validator.isValidPassword("RA12#$"));
		assertTrue(validator.isValidPassword("ra"));
		assertTrue(validator.isValidPassword("1234"));
		assertTrue(validator.isValidPassword("!@#$%"));
		assertTrue(validator.isValidPassword(""));
		// Null password
		assertFalse(validator.isValidPassword(null));
	}
	
	@Test
	void getValidationMessageTest() {
		
		// a validator with default 4 minimum uppercase letters
		MinUppercaseValidation validator = new MinUppercaseValidation("4");
		// 4 uppercase letters 4=4
		assertEquals(validator.getPasswordValidationMessage("rAOUF"),
				String.format(MinUppercaseValidation.VALID_PASSWORD_MESSAGE, validator.getMinUppercase()));
		// 3 uppercase letters 3<4
		assertEquals(validator.getPasswordValidationMessage("RaOuf"),
				String.format(MinUppercaseValidation.INVALID_PASSWORD_MESSAGE, validator.getMinUppercase()));
	}
}
