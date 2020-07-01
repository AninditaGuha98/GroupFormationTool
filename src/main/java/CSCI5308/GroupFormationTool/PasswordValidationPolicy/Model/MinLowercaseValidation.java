package CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model;

import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordValidation;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;

public class MinLowercaseValidation implements IPasswordValidation {

	private static final String MIN_LOWERCASE_CONFIG = "min_lowercase";
	public static final String VALID_PASSWORD_MESSAGE = "Password follows minimum %d lowercase letters.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have minimum %d lowercase letters.";

	private int minLowercase;

	public MinLowercaseValidation() {
	}

	public int getMinLowercase() {
		return this.minLowercase;
	}

	private void setMinLowercase(String minLowercase) {
		int intMinLowercase;
		try {
			intMinLowercase = Integer.parseInt(minLowercase);
		} catch (Exception e) {
			e.printStackTrace();
			intMinLowercase = 0;
		}

		if (intMinLowercase <= 0) {
			this.minLowercase = 0;
		}
		else {
			this.minLowercase = intMinLowercase;
		}
	}

	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		int lowerCase = 0;
		String configValue;

		try {
			configValue = config.getConfig(MIN_LOWERCASE_CONFIG);
		} catch (Exception e) {
			e.printStackTrace();
			configValue = null;
		}

		setMinLowercase(configValue);

		if (null == password) {
			return false;
		}

		if (this.minLowercase == 0) {
			return true;
		}

		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				lowerCase++;
			}
		}
		if (lowerCase < this.minLowercase) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public String getValidationFailureMessage(String password, IPasswordValidationConfiguration config) {
		if (isValidPassword(password, config)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.minLowercase);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.minLowercase);
		}
	}

}
