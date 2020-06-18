package CSCI5308.GroupFormationTool.SecurityTest.PasswordValidationPolicyTest.Model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordHistoryPersistence;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidation;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model.HistoryConstraintValidation;

class HistoryConstraintValidationTest {

//	@Test
//	void isValidPasswordTest() {
//		IPasswordValidationConfiguration config = new PasswordValidationConfigurationMock();
//		
//		IPasswordHistoryPersistence persistence = new PasswordHistoryPersistenceMock(true);
//		IPasswordValidation validator = new HistoryConstraintValidation(persistence);
//		assertTrue(validator.isValidPassword("1234", config));
//		
//		persistence = new PasswordHistoryPersistenceMock(false);
//		validator = new HistoryConstraintValidation(persistence);
//		assertFalse(validator.isValidPassword("1234", config));
//	}
//	
//	@Test
//	void getPasswordValidationMessage() {
//		IPasswordValidationConfiguration config = new PasswordValidationConfigurationMock();
//		
//		IPasswordHistoryPersistence persistence = new PasswordHistoryPersistenceMock(true);
//		HistoryConstraintValidation validator = new HistoryConstraintValidation(persistence);
//		assertEquals(validator.getPasswordValidationMessage("1234", config),
//				String.format(HistoryConstraintValidation.VALID_PASSWORD_MESSAGE, validator.getHistoryConstraint()));
//		
//		persistence = new PasswordHistoryPersistenceMock(false);
//		validator = new HistoryConstraintValidation(persistence);
//		assertEquals(validator.getPasswordValidationMessage("1234", config),
//				String.format(HistoryConstraintValidation.INVALID_PASSWORD_MESSAGE, validator.getHistoryConstraint()));
//	}

}
