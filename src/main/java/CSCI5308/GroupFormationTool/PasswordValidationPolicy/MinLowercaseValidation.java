package CSCI5308.GroupFormationTool.PasswordValidationPolicy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinLowercaseValidation implements IPasswordValidation {

	private static final Logger logger = LoggerFactory.getLogger(MinLowercaseValidation.class);
	private static final String MIN_LOWERCASE_LOG = "MinLowercasePolicy";

	private static final String MIN_LOWERCASE_CONFIG = "min_lowercase";
	public static final String VALID_PASSWORD_MESSAGE = "Password follows minimum %d lowercase letters.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have minimum %d lowercase letters.";

	private int minLowercase;

	public MinLowercaseValidation() {
		logger.info("password={}, action={}, status={}", MIN_LOWERCASE_LOG, "Create", "Success");
	}

	public int getMinLowercase() {
		return this.minLowercase;
	}

	private void setMinLowercase(String minLowercase) {
		int intMinLowercase;
		try {
			intMinLowercase = Integer.parseInt(minLowercase);
		} catch (NumberFormatException e) {
			logger.warn("password={}, action={}, message={}", MIN_LOWERCASE_LOG, "Set Min Lowercase", e.getMessage());
			intMinLowercase = 0;
		}

		if (intMinLowercase <= 0) {
			this.minLowercase = 0;
		} else {
			this.minLowercase = intMinLowercase;
		}
		logger.info("password={}, action={}, value={}", MIN_LOWERCASE_LOG, "Set Min Lowercase", getMinLowercase());
	}

	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		int lowerCase = 0;
		String configValue;

		try {
			configValue = config.getConfig(MIN_LOWERCASE_CONFIG);
		} catch (IllegalArgumentException e) {
			logger.warn("password={}, action={}, message={}", MIN_LOWERCASE_LOG, "Get Configuration", e.getMessage());
			configValue = null;
		}

		setMinLowercase(configValue);

		if (null == password) {
			logger.info("password={}, action={}, status={}, message={}", MIN_LOWERCASE_LOG, "Check Validity", "Fail",
					"Null Password");
			return false;
		}

		if (this.minLowercase == 0) {
			logger.info("password={}, action={}, status={}", MIN_LOWERCASE_LOG, "Check Validity", "Success");
			return true;
		}

		for (int i = 0; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				lowerCase++;
			}
		}
		if (lowerCase < this.minLowercase) {
			logger.info("password={}, action={}, status={}", MIN_LOWERCASE_LOG, "Check Validity", "Fail");
			return false;
		} else {
			logger.info("password={}, action={}, status={}", MIN_LOWERCASE_LOG, "Check Validity", "Success");
			return true;
		}
	}

	@Override
	public String getValidationFailureMessage(String password, IPasswordValidationConfiguration config) {
		String message = null;
		if (isValidPassword(password, config)) {
			message = String.format(VALID_PASSWORD_MESSAGE, this.minLowercase);
		} else {
			message = String.format(INVALID_PASSWORD_MESSAGE, this.minLowercase);
		}
		logger.info("password={}, action={}, message={}", MIN_LOWERCASE_LOG, "Get Validation Message", message);
		return message;
	}
}
