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
			String notAllowedString = this.generateForbiddenString(LENGTH_OF_FORBIDDEN_STRING);
			validator = new ForbiddenCharSetValidation(notAllowedString);
			assertTrue(validator.getForbiddenCharSet().equals(notAllowedString));
		}
	}
	
	@Test
	void getForbiddenCharSetTest() {
		ForbiddenCharSetValidation validator;
		Random random = new Random();
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int randomLength = random.nextInt(LENGTH_OF_FORBIDDEN_STRING + 1);
			String forbiddenString = this.generateForbiddenString(randomLength);
			validator = new ForbiddenCharSetValidation(forbiddenString);
			assertTrue(validator.getForbiddenCharSet().equals(forbiddenString));
		}
	}
	
	@Test
	void setForbiddenCharSetTest() {
		ForbiddenCharSetValidation validator = new ForbiddenCharSetValidation();
		Random random = new Random();
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int randomLength = random.nextInt(LENGTH_OF_FORBIDDEN_STRING + 1);
			String forbiddenString = this.generateForbiddenString(randomLength);
			validator.setForbiddernCharSet(forbiddenString);
			assertTrue(validator.getForbiddenCharSet().equals(forbiddenString));
		}
		validator.setForbiddernCharSet(null);
		assertTrue(validator.getForbiddenCharSet().equals(""));
	}
	
	@Test
	void isValidPasswordTest() {
		ForbiddenCharSetValidation validator = new ForbiddenCharSetValidation();
		Random random = new Random();
		
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int randomAllowedLength = random.nextInt(LENGTH_OF_ALLOWED_STRING + 1);
			int randomForbiddernLenght = random.nextInt(LENGTH_OF_FORBIDDEN_STRING + 1);
			
			String allowedString = this.generateAllowedString(randomAllowedLength);
			String forbiddenString = this.generateForbiddenString(randomForbiddernLenght);
			
			validator.setForbiddernCharSet(forbiddenString);
			if (forbiddenString.isEmpty()) {
				assertTrue(validator.isValidPassword(allowedString));
				assertTrue(validator.isValidPassword(forbiddenString+allowedString));
				assertTrue(validator.isValidPassword(allowedString+forbiddenString));
				assertTrue(validator.isValidPassword(forbiddenString+allowedString+
						forbiddenString));
			} else {
				assertTrue(validator.isValidPassword(allowedString));
				assertFalse(validator.isValidPassword(forbiddenString+allowedString));
				assertFalse(validator.isValidPassword(allowedString+forbiddenString));
				assertFalse(validator.isValidPassword(forbiddenString+allowedString+
						forbiddenString));
			}
			assertFalse(validator.isValidPassword(null));
			assertTrue(validator.isValidPassword(""));
		}
	}
	
	@Test
	void getValidationMessageTest() {
		ForbiddenCharSetValidation validator = new ForbiddenCharSetValidation();
		Random random = new Random();
		
		for (int i = 0; i < NUM_OF_TESTS; i++) {
			int randomAllowedLength = random.nextInt(LENGTH_OF_ALLOWED_STRING + 1);
			int randomForbiddernLenght = random.nextInt(LENGTH_OF_FORBIDDEN_STRING + 1);
			
			String allowedString = this.generateAllowedString(randomAllowedLength);
			String forbiddenString = this.generateForbiddenString(randomForbiddernLenght);
			
			validator.setForbiddernCharSet(forbiddenString);
			if (!forbiddenString.isEmpty()) {
				assertEquals(validator.getPasswordValidationMessage(allowedString),
						String.format(ForbiddenCharSetValidation.VALID_PASSWORD_MESSAGE, 
								validator.getForbiddenCharSet()));
				assertEquals(validator.getPasswordValidationMessage(forbiddenString+allowedString),
						String.format(ForbiddenCharSetValidation.VALID_PASSWORD_MESSAGE, 
								validator.getForbiddenCharSet()));
			}
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
	
	private String generateForbiddenString(int length) {
		StringBuilder builder = new StringBuilder();
		while (length-- != 0) {
			int character = (int)(Math.random()* FORBIDDEN_CHARSET.length());
				builder.append(FORBIDDEN_CHARSET.charAt(character));
		}
		return builder.toString();
	}

}
