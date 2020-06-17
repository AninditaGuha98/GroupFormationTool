package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Class;

import CSCI5308.GroupFormationTool.SystemConfig;

public class DefaultPasswordValidationManager implements IPasswordValidationManager {

//	private static final String MIN_LENGTH = "min_length";
//	private static final String MAX_LENGTH = "max_length";
//	private static final String MIN_LOWERCASE = "min_lowercase";
//	private static final String MIN_UPPERCASE = "min_uppercase";
//	private static final String MIN_NON_ALPHANUM = "min_non_alphanum";
//	private static final String FORBIDDEN_CHARSET = "forbidden_charset";
//	private static final String HISTORY_CONSTRAINT = "history_constraint";
//	private static final Map<String, String> passwordValidationMapper = new HashMap<>();
	private static final String MIN_LENGTH ="CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinLengthValidation";
	private static final String MAX_LENGTH = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MaxLengthValidation";
	private static final String MIN_LOWERCASE = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinLowercaseValidation";
	private static final String MIN_UPPERCASE = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinUppercaseValidation";
	private static final String MIN_NON_ALPHANUM = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.MinNonAlphaNumValidation";
	private static final String FORBIDDEN_CHARSET = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.ForbiddenCharSetValidation";
//	private static final String HISTORY_CONSTRAINT = "HistoryConstraintValidation";

	private List<IPasswordValidation> passwordValidationList;
	private List<String> passwordValidationsNameList;
	
	public DefaultPasswordValidationManager() {
		passwordValidationList = new ArrayList<IPasswordValidation>();
		passwordValidationsNameList = new ArrayList<String>();
		initializePasswordValidationsNameList();
		
		try {
			for (String validationName: passwordValidationsNameList) {
				
				Class<?> c = Class.forName(validationName);
				Constructor<?> construct = c.getConstructor();
				IPasswordValidation passwordValidation = (IPasswordValidation) construct.newInstance();
//				IPasswordValidation passwordValidation = (IPasswordValidation) c.newInstance();
				passwordValidationList.add(passwordValidation);
			}
		}
		catch (Exception e) {
			// Log the exception
			e.printStackTrace();
			passwordValidationList = new ArrayList<IPasswordValidation>();
		}
	}
	
	private void initializePasswordValidationsNameList() {
		passwordValidationsNameList.add(MIN_LENGTH);
		passwordValidationsNameList.add(MAX_LENGTH);
		passwordValidationsNameList.add(MIN_LOWERCASE);
		passwordValidationsNameList.add(MIN_UPPERCASE);
		passwordValidationsNameList.add(MIN_NON_ALPHANUM);
		passwordValidationsNameList.add(FORBIDDEN_CHARSET);
//		passwordValidationsNameList.add(HISTORY_CONSTRAINT);
	}

	@Override
	public boolean isValidPassword(String password) {
		IPasswordValidationConfiguration configuration = 
				SystemConfig.instance().getPasswordValidationConfiguration();
		
		for (IPasswordValidation passwordValidation: passwordValidationList) {
			if (!passwordValidation.isValidPassword(password, configuration))
				return false;
		}
		return true;
	}
	
	@Override
	public List<String> getPasswordValidationFailures(String password) {
		IPasswordValidationConfiguration configuration = 
				SystemConfig.instance().getPasswordValidationConfiguration();
		List<String> failureMessages = new ArrayList<String>();
		
		for (IPasswordValidation passwordValidation: passwordValidationList) {
			if (!passwordValidation.isValidPassword(password, configuration))
				failureMessages.add(passwordValidation.getPasswordValidationMessage(password, configuration));
		}
		
		return failureMessages;
	}
}
