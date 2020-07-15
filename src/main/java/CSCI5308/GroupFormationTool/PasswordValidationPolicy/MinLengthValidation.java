package CSCI5308.GroupFormationTool.PasswordValidationPolicy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinLengthValidation implements IPasswordValidation {

	private static final Logger logger = LoggerFactory.getLogger(MinLengthValidation.class);
	private static final String MIN_LENGTH_LOG = "MinLengthPolicy";

	private static final String MIN_LENGTH_CONFIG = "min_length";
	public static final String VALID_PASSWORD_MESSAGE = "Password follows minimum length of %d.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have minimum length of %d.";

	private int minLength;

	public MinLengthValidation() {
		logger.info("password={}, action={}, status={}", MIN_LENGTH_LOG, "Create", "Success");
	}

	public int getMinLength() {
		return this.minLength;
	}

	private void setMinLength(String minLength) {
		int intMinLength;
		try {
			intMinLength = Integer.parseInt(minLength);
		} catch (NumberFormatException e) {
			logger.warn("password={}, action={}, message={}", MIN_LENGTH_LOG, "Set Min Length", e.getMessage());
			intMinLength = 0;
		}

		if (intMinLength <= 0) {
			this.minLength = 0;
		} else {
			this.minLength = intMinLength;
		}
		logger.info("password={}, action={}, value={}", MIN_LENGTH_LOG, "Set Min Length", getMinLength());
	}

	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		String configValue;

		if (null == password) {
			logger.info("password={}, action={}, status={}, message={}", MIN_LENGTH_LOG, "Check Validity", "Fail",
					"Null Password");
			return false;
		}

		try {
			configValue = config.getConfig(MIN_LENGTH_CONFIG);
		} catch (IllegalArgumentException e) {
			logger.warn("password={}, action={}, message={}", MIN_LENGTH_LOG, "Get Configuration", e.getMessage());
			configValue = null;
		}
		setMinLength(configValue);

		if (this.minLength == 0) {
			logger.info("password={}, action={}, status={}", MIN_LENGTH_LOG, "Check Validity", "Success");
			return true;
		}

		if (password.length() >= this.minLength) {
			logger.info("password={}, action={}, status={}", MIN_LENGTH_LOG, "Check Validity", "Success");
			return true;
		} else {
			logger.info("password={}, action={}, status={}", MIN_LENGTH_LOG, "Check Validity", "Fail");
			return false;
		}
	}

	@Override
	public String getValidationFailureMessage(String password, IPasswordValidationConfiguration config) {
		String message = null;
		if (isValidPassword(password, config)) {
			message = String.format(VALID_PASSWORD_MESSAGE, this.minLength);
		} else {
			message = String.format(INVALID_PASSWORD_MESSAGE, this.minLength);
		}
		logger.info("password={}, action={}, message={}", MIN_LENGTH_LOG, "Get Validation Message", message);
		return message;
	}
}
