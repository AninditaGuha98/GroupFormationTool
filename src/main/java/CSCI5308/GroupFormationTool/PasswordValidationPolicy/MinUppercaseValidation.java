package CSCI5308.GroupFormationTool.PasswordValidationPolicy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinUppercaseValidation implements IPasswordValidation {

	private static final Logger logger = LoggerFactory.getLogger(MinUppercaseValidation.class);
	private static final String MIN_UPPERCASE_LOG = "MinUppercasePolicy";
	
	private static final String MIN_UPPERCASE_CONFIG = "min_uppercase";
	public static final String VALID_PASSWORD_MESSAGE = "Password follows minimum %d uppercase letters.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have minimum %d uppercase letters.";

	private int minUppercase;

	public MinUppercaseValidation() {
		logger.info("password={}, action={}, status={}",
				MIN_UPPERCASE_LOG, "Create", "Success");
	}

	public int getMinUppercase() {
		return this.minUppercase;
	}

	private void setMinUppercase(String minUppercase) {
		int intMinUppercase;
		try {
			intMinUppercase = Integer.parseInt(minUppercase);
		} catch (NumberFormatException e) {
			logger.warn("password={}, action={}, message={}",
					MIN_UPPERCASE_LOG, "Set Min Uppercase", e.getMessage());
			intMinUppercase = 0;
		}

		if (intMinUppercase <= 0) {
			this.minUppercase = 0;
		} else {
			this.minUppercase = intMinUppercase;
		}
		logger.info("password={}, action={}, value={}",
				MIN_UPPERCASE_LOG, "Set Min Uppercase", getMinUppercase());
	}

	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		int upperCase = 0;
		String configValue;

		try {
			configValue = config.getConfig(MIN_UPPERCASE_CONFIG);
		} catch (IllegalArgumentException e) {
			logger.warn("password={}, action={}, message={}",
					MIN_UPPERCASE_LOG, "Get Configuration", e.getMessage());
			configValue = null;
		}

		setMinUppercase(configValue);

		if (null == password) {
			logger.info("password={}, action={}, status={}, message={}",
					MIN_UPPERCASE_LOG, "Check Validity", "Fail", "Null Password");
			return false;
		}

		if (this.minUppercase == 0) {
			logger.info("password={}, action={}, status={}",
					MIN_UPPERCASE_LOG, "Check Validity", "Success");
			return true;
		}

		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				upperCase++;
			}
		}
		if (upperCase < this.minUppercase) {
			logger.info("password={}, action={}, status={}",
					MIN_UPPERCASE_LOG, "Check Validity", "Fail");
			return false;
		} else {
			logger.info("password={}, action={}, status={}",
					MIN_UPPERCASE_LOG, "Check Validity", "Success");
			return true;
		}
	}

	@Override
	public String getValidationFailureMessage(String password, IPasswordValidationConfiguration config) {
		String message = null;
		if (isValidPassword(password, config)) {
			message = String.format(VALID_PASSWORD_MESSAGE, this.minUppercase);
		} else {
			message = String.format(INVALID_PASSWORD_MESSAGE, this.minUppercase);
		}
		logger.info("password={}, action={}, message={}",
				MIN_UPPERCASE_LOG, "Get Validation Message", message);
		return message;
	}

}
