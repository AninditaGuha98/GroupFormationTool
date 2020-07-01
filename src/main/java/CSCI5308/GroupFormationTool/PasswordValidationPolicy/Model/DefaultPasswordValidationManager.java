package CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordHistoryPersistence;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordValidation;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordValidationManager;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Repository.PasswordHistoryDB;

// Temporary solution until we refactor with an abstract factory
public class DefaultPasswordValidationManager implements IPasswordValidationManager {

	private static final String MIN_LENGTH =
			"CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model.MinLengthValidation";
	private static final String MAX_LENGTH = 
			"CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model.MaxLengthValidation";
	private static final String MIN_LOWERCASE = 
			"CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model.MinLowercaseValidation";
	private static final String MIN_UPPERCASE = 
			"CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model.MinUppercaseValidation";
	private static final String MIN_NON_ALPHANUM = 
			"CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model.MinNonAlphaNumValidation";
	private static final String FORBIDDEN_CHARSET = 
			"CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model.ForbiddenCharSetValidation";
	private static final String HISTORY_CONSTRAINT = 
			"CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model.HistoryConstraintValidation";

	private static List<String> moduleNameList = Arrays.asList(
			MIN_LENGTH, MAX_LENGTH, MIN_LOWERCASE, MIN_UPPERCASE, MIN_NON_ALPHANUM, FORBIDDEN_CHARSET);
	 
	private List<IPasswordValidation> moduleList;
	private IPasswordHistoryPersistence passwordHistory;

	public DefaultPasswordValidationManager() {
		moduleList = new ArrayList<IPasswordValidation>();
		passwordHistory = new PasswordHistoryDB();

		try {
			for (String validationName : moduleNameList) {
				Class<?> c = Class.forName(validationName);
				Constructor<?> constructor = c.getConstructor();
				IPasswordValidation passwordValidation = (IPasswordValidation) constructor.newInstance();
				moduleList.add(passwordValidation);
			}
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();
		}

		try {
			Class<?> c = Class.forName(HISTORY_CONSTRAINT);
			Constructor<?> constructor = c.getConstructor(IPasswordHistoryPersistence.class);
			IPasswordValidation passwordValidation = 
					(IPasswordValidation) constructor.newInstance(passwordHistory);
			moduleList.add(passwordValidation);
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();
		}
	}

	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration configuration) {
		for (IPasswordValidation validationModule: moduleList) {
			if (!validationModule.isValidPassword(password, configuration))
				return false;
		}
		return true;
	}

	@Override
	public List<String> getPasswordValidationFailures(
			String password, IPasswordValidationConfiguration configuration) {
		List<String> failureMessages = new ArrayList<String>();

		for (IPasswordValidation validationModule : moduleList) {
			if (!validationModule.isValidPassword(password, configuration))
				failureMessages.add(validationModule.getValidationFailureMessage(password, configuration));
		}

		return failureMessages;
	}
}
