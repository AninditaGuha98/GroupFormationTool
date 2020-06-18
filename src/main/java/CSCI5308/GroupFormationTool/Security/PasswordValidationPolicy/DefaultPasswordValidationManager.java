package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordHistoryPersistence;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidation;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidationManager;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Repository.PasswordHistoryDB;

// Temporary solution until we refactor with an abstract factory
public class DefaultPasswordValidationManager implements IPasswordValidationManager {

	private static final String MIN_LENGTH ="CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model.MinLengthValidation";
	private static final String MAX_LENGTH = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model.MaxLengthValidation";
	private static final String MIN_LOWERCASE = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model.MinLowercaseValidation";
	private static final String MIN_UPPERCASE = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model.MinUppercaseValidation";
	private static final String MIN_NON_ALPHANUM = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model.MinNonAlphaNumValidation";
	private static final String FORBIDDEN_CHARSET = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model.ForbiddenCharSetValidation";
	private static final String HISTORY_CONSTRAINT = "CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model.HistoryConstraintValidation";

	private static List<String> passwordValidationsNameList = Arrays.asList(
			MIN_LENGTH, MAX_LENGTH, MIN_LOWERCASE, MIN_UPPERCASE, MIN_NON_ALPHANUM, FORBIDDEN_CHARSET);
	 
	private List<IPasswordValidation> passwordValidationList;
	private IPasswordHistoryPersistence passwordHistory;

	public DefaultPasswordValidationManager() {
		passwordValidationList = new ArrayList<IPasswordValidation>();
		passwordHistory = new PasswordHistoryDB();

		try {
			for (String validationName : passwordValidationsNameList) {

				Class<?> c = Class.forName(validationName);
				Constructor<?> constructor = c.getConstructor();
				IPasswordValidation passwordValidation = (IPasswordValidation) constructor.newInstance();
				passwordValidationList.add(passwordValidation);
			}
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();
		}

		try {
			Class<?> c = Class.forName(HISTORY_CONSTRAINT);
			Constructor<?> constructor = c.getConstructor(IPasswordHistoryPersistence.class);
			IPasswordValidation passwordValidation = (IPasswordValidation) constructor.newInstance(passwordHistory);
			passwordValidationList.add(passwordValidation);
		} catch (Exception e) {
			// Log the exception
			e.printStackTrace();
		}
	}

	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration configuration) {
		for (IPasswordValidation passwordValidation: passwordValidationList) {
			if (!passwordValidation.isValidPassword(password, configuration))
				return false;
		}
		return true;
	}

	@Override
	public List<String> getPasswordValidationFailures(
			String password, IPasswordValidationConfiguration configuration) {
		List<String> failureMessages = new ArrayList<String>();

		for (IPasswordValidation passwordValidation : passwordValidationList) {
			if (!passwordValidation.isValidPassword(password, configuration))
				failureMessages.add(passwordValidation.getPasswordValidationMessage(password, configuration));
		}

		return failureMessages;
	}
}
