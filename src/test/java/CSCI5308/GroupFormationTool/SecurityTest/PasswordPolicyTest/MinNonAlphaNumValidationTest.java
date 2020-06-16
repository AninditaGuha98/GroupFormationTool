package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinNonAlphaNumValidation;

class MinNonAlphaNumValidationTest {

	@Test
	void minNonAlphaNumValidationDefaultConstructorTest() {
		MinNonAlphaNumValidation validator = new MinNonAlphaNumValidation();
		assertTrue(validator.getMinNonAlphaNum() == 0);
	}
	
	@Test
	void minNonAlaphNumValidationConstructorTest() {
		MinNonAlphaNumValidation validator = new MinNonAlphaNumValidation("2");
		assertTrue(validator.getMinNonAlphaNum() == 2);
		
		validator = new MinNonAlphaNumValidation("-1");
		assertTrue(validator.getMinNonAlphaNum() == 0);
		
		validator = new MinNonAlphaNumValidation("0");
		assertTrue(validator.getMinNonAlphaNum() == 0);
	}
	
	@Test
	void getMinNonAlaphNumTest() {
		MinNonAlphaNumValidation validator = new MinNonAlphaNumValidation("4");
		assertTrue(validator.getMinNonAlphaNum() == 4);
	}
	
	@Test
	void setMinNonAlphaNumTest() {
		MinNonAlphaNumValidation validator = new MinNonAlphaNumValidation();
		
		validator.setMinNonAlphaNum(5);
		assertTrue(validator.getMinNonAlphaNum() == 5);
		
		validator.setMinNonAlphaNum(-1);
		assertTrue(validator.getMinNonAlphaNum() == 0);
		
		validator.setMinNonAlphaNum(0);
		assertTrue(validator.getMinNonAlphaNum() == 0);
	}
	
	@Test
	void isValidPasswordTest() {

		MinNonAlphaNumValidation validator = new MinNonAlphaNumValidation();
		// minNonAlphaNum = 0
		assertTrue(validator.isValidPassword("messi"));
		assertTrue(validator.isValidPassword("messi!"));
		assertTrue(validator.isValidPassword("#messi!"));
		assertTrue(validator.isValidPassword("#me@ssi!"));
		assertTrue(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword(null));
		
		validator = new MinNonAlphaNumValidation("1");
		// 2 NonAlphaNum chars - 2>1
		assertTrue(validator.isValidPassword("#Messi!"));
		assertTrue(validator.isValidPassword("%me@SSi"));
		assertTrue(validator.isValidPassword("me.ssi)"));
		assertTrue(validator.isValidPassword("'?messI"));
		assertTrue(validator.isValidPassword("me+}ssi"));
		assertTrue(validator.isValidPassword("messi&$"));
		// 1 NonAlphaNum chars - 1==1
		assertTrue(validator.isValidPassword("^messi"));
		assertTrue(validator.isValidPassword("me`ssi"));
		assertTrue(validator.isValidPassword("messi~"));
		assertTrue(validator.isValidPassword("Me.ssi123"));
		// 0 NonAlphaNum chars - 0 < 1
		assertFalse(validator.isValidPassword("MESsI"));
		assertFalse(validator.isValidPassword("12345"));
		assertFalse(validator.isValidPassword(""));
		assertFalse(validator.isValidPassword(null));
	}
}
