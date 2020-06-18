package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidation;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;

public class ForbiddenCharSetValidation implements IPasswordValidation {

	private static final String FORBIDDEN_CHARSET_CONFIG = "forbidden_charset";
	public static final String VALID_PASSWORD_MESSAGE = "Password does not have forbidden characters (%s).";
	public static final String INVALID_PASSWORD_MESSAGE = "Password has forbidden characters \"%s\".";

	private String forbiddenCharSet;

	public ForbiddenCharSetValidation() {
	}

	public String getForbiddenCharSet() {
		return this.forbiddenCharSet;
	}

	private void setForbiddernCharSet(String forbiddernCharSet) {
		if (null == forbiddernCharSet) {
			this.forbiddenCharSet = "";
		} else {
			this.forbiddenCharSet = forbiddernCharSet;
		}
	}

	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		String configValue;

		try {
			configValue = config.getConfig(FORBIDDEN_CHARSET_CONFIG);
		} catch (Exception e) {
			e.printStackTrace();
			configValue = null;
		}
		setForbiddernCharSet(configValue);

		if (null == password) {
			return false;
		}
		if (this.forbiddenCharSet.isEmpty()) {
			return true;
		}

		for (int i = 0; i < this.forbiddenCharSet.length(); i++) {
			if (password.contains(String.valueOf(this.forbiddenCharSet.charAt(i))))
				return false;
		}
		return true;
	}

	@Override
	public String getValidationFailureMessage(String password, IPasswordValidationConfiguration config) {
		if (isValidPassword(password, config)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.forbiddenCharSet);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.forbiddenCharSet);
		}
	}
}
