package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.lang.Class;

import CSCI5308.GroupFormationTool.SystemConfig;

public class DefaultPasswordValidationManager implements IPasswordValidationManager {

	private static final String MIN_LENGTH ="CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinLengthValidation";
	private static final String MAX_LENGTH = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MaxLengthValidation";
	private static final String MIN_LOWERCASE = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinLowercaseValidation";
	private static final String MIN_UPPERCASE = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinUppercaseValidation";
	private static final String MIN_NON_ALPHANUM = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinNonAlphaNumValidation";
	private static final String FORBIDDEN_CHARSET = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.ForbiddenCharSetValidation";
	private static final String HISTORY_CONSTRAINT = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.HistoryConstraintValidation";

	private static List<String> passwordValidationsNameList = new ArrayList<>(
			List.of(MIN_LENGTH, MAX_LENGTH, MIN_LOWERCASE, MIN_UPPERCASE, MIN_NON_ALPHANUM, FORBIDDEN_CHARSET));
	 
	private IPasswordValidationConfiguration configuration;
	private List<IPasswordValidation> passwordValidationList;
	private IPasswordHistoryPersistence passwordHistory;

	
	public DefaultPasswordValidationManager() {
		configuration = SystemConfig.instance().getPasswordValidationConfiguration();
		passwordValidationList = new ArrayList<IPasswordValidation>();
		passwordHistory = new PasswordHistoryDB();
		
		try {
			for (String validationName: passwordValidationsNameList) {
				
				Class<?> c = Class.forName(validationName);
				Constructor<?> constructor = c.getConstructor();
				IPasswordValidation passwordValidation = (IPasswordValidation) constructor.newInstance();
				passwordValidationList.add(passwordValidation);
			}
		}
		catch (Exception e) {
			// Log the exception
			e.printStackTrace();
		}
		
		try {
			Class<?> c = Class.forName(HISTORY_CONSTRAINT);
			Constructor<?> constructor = c.getConstructor(IPasswordHistoryPersistence.class);
			IPasswordValidation passwordValidation = 
					(IPasswordValidation) constructor.newInstance(passwordHistory);
			passwordValidationList.add(passwordValidation);
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean isValidPassword(String password) {
		for (IPasswordValidation passwordValidation: passwordValidationList) {
			if (!passwordValidation.isValidPassword(password, configuration))
				return false;
		}
		return true;
	}
	
	@Override
	public List<String> getPasswordValidationFailures(String password) {
		List<String> failureMessages = new ArrayList<String>();
		
		for (IPasswordValidation passwordValidation: passwordValidationList) {
			if (!passwordValidation.isValidPassword(password, configuration))
				failureMessages.add(passwordValidation.getPasswordValidationMessage(password, configuration));
		}
		
		return failureMessages;
	}
}
