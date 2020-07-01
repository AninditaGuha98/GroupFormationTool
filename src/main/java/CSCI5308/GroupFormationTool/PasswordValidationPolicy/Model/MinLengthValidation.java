package CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model;

import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordValidation;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;

public class MinLengthValidation implements IPasswordValidation {

	private static final String MIN_LENGTH_CONFIG = "min_length";
	public static final String VALID_PASSWORD_MESSAGE = "Password follows minimum length of %d.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have minimum length of %d.";

	private int minLength;

	public MinLengthValidation() {
	}

	public int getMinLength() {
		return this.minLength;
	}

	private void setMinLength(String minLength) {
		int intMinLength;
		try {
			intMinLength = Integer.parseInt(minLength);
		} catch (Exception e) {
			e.printStackTrace();
			intMinLength = 0;
		}

		if (intMinLength <= 0) {
			this.minLength = 0;
		}
		else {
			this.minLength = intMinLength;
		}
	}

	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		String configValue;

		if (null == password) {
			return false;
		}

		try {
			configValue = config.getConfig(MIN_LENGTH_CONFIG);
		} catch (Exception e) {
			e.printStackTrace();
			configValue = null;
		}
		setMinLength(configValue);

		if (this.minLength == 0) {
			return true;
		}

		if (password.length() >= this.minLength) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getValidationFailureMessage(String password, IPasswordValidationConfiguration config) {
		if (isValidPassword(password, config)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.minLength);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.minLength);
		}
	}
}
