package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.Class;

import CSCI5308.GroupFormationTool.SystemConfig;

public class DefaultPasswordValidationManager implements IPasswordValidationManager {

	private static final String MIN_LENGTH = "min_length";
	private static final String MAX_LENGTH = "max_length";
	private static final String MIN_LOWERCASE = "min_lowercase";
	private static final String MIN_UPPERCASE = "min_uppercase";
	private static final String MIN_NON_ALPHANUM = "min_non_alphanum";
	private static final String FORBIDDEN_CHARSET = "forbidden_charset";
//	private static final String HISTORY_CONSTRAINT = "history_constraint";
	private static final Map<String, String> passwordValidationMapper = new HashMap<>();
	
	private List<IPasswordValidation> passwordValidationList;
	
	public DefaultPasswordValidationManager() {
		Map<String, String> configMap = new HashMap<>();
		IPasswordValidationConfiguration config = SystemConfig.instance().getPasswordValidationConfiguration();

		initializePasswordValidationMapper();
		passwordValidationList = new ArrayList<IPasswordValidation>();
		try {
			configMap = config.getConfigMap(passwordValidationMapper.keySet());
			for (String validationTest: passwordValidationMapper.keySet()) {
				String className = passwordValidationMapper.get(validationTest);
				String configValue = configMap.get(validationTest);
				
				Class<?> c = Class.forName(className);
				Constructor<?> construct = c.getConstructor(String.class);
				IPasswordValidation passwordValidation = (IPasswordValidation) construct.newInstance(configValue);
				passwordValidationList.add(passwordValidation);
			}
		}
		catch (Exception e) {
			// Log the exception
			e.printStackTrace();
			passwordValidationList = new ArrayList<IPasswordValidation>();
		}
	}
	
	private void initializePasswordValidationMapper() {
		passwordValidationMapper.put(MIN_LENGTH, "CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinLengthValidation");
		passwordValidationMapper.put(MAX_LENGTH, "CSCI5308.GroupFormationTool.Security.PasswordPolicy.MaxLengthValidation");
		passwordValidationMapper.put(MIN_LOWERCASE, "CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinLowercaseValidation");
		passwordValidationMapper.put(MIN_UPPERCASE, "CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinUppercaseValidation");
		passwordValidationMapper.put(MIN_NON_ALPHANUM, "CSCI5308.GroupFormationTool.Security.PasswordPolicy.MinNonAlphaNumValidation");
		passwordValidationMapper.put(FORBIDDEN_CHARSET, "CSCI5308.GroupFormationTool.Security.PasswordPolicy.ForbiddenCharSetValidation");
//		passwordValidationMapper.put(HISTORY_CONSTRAINT, "HistoryConstraintValidation");
	}

	@Override
	public boolean isValidPassword(String password) {
		for (IPasswordValidation validation: passwordValidationList) {
			if (!validation.isValidPassword(password))
				return false;
		}
		return true;
	}
	
	@Override
	public List<String> getPasswordValidationFailures(String password) {
		List<String> failureMessages = new ArrayList<String>();
		for (IPasswordValidation validation: passwordValidationList) {
			if (!validation.isValidPassword(password))
				failureMessages.add(validation.getPasswordValidationMessage(password));
		}
		return failureMessages;
	}
	
	
}
