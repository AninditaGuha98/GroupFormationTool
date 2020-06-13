package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.ForbiddenCharSetValidation;

class ForbiddenCharSetValidationTest {

	private static final String ALLOWED_CHARSET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^*";
	private static final String FORBIDDEN_CHARSET = "&()\"\\'~.,/{}[]";
	private static final int NUM_OF_TESTS = 10;
	private static final int LENGTH_OF_ALLOWED_STRING = 12;
	private static final int LENGTH_OF_FORBIDDEN_STRING = 4;
	

	@Test
	void forbiddenCharSetValidationDefaultConstructor() {
		ForbiddenCharSetValidation validator = new ForbiddenCharSetValidation();
		assertTrue(validator.getForbiddenCharSet().isEmpty());
	}
	
	@Test
	void forbiddenCharSetValidationConstructor() {
		ForbiddenCharSetValidation validator;
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			String notAllowedString = this.generateNotAllowedString(LENGTH_OF_FORBIDDEN_STRING);
			validator = new ForbiddenCharSetValidation(notAllowedString);
			assertTrue(validator.getForbiddenCharSet().equals(notAllowedString));
		}
	}
	
	private String generateAllowedString(int length) {
		StringBuilder builder = new StringBuilder();
		Random upperLowerSelector = new Random();
		while (length-- != 0) {
			int character = (int)(Math.random()*ALLOWED_CHARSET.length());
			if (upperLowerSelector.nextInt(2) == 0)
				builder.append(ALLOWED_CHARSET.toUpperCase().charAt(character));
			else
				builder.append(ALLOWED_CHARSET.toLowerCase().charAt(character));
		}
		return builder.toString();
	}
	
	private String generateNotAllowedString(int length) {
		StringBuilder builder = new StringBuilder();
		while (length-- != 0) {
			int character = (int)(Math.random()* FORBIDDEN_CHARSET.length());
				builder.append(FORBIDDEN_CHARSET.charAt(character));
		}
		return builder.toString();
	}

}
