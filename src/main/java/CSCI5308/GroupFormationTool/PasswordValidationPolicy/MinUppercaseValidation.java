package CSCI5308.GroupFormationTool.PasswordValidationPolicy;

public class MinUppercaseValidation implements IPasswordValidation {

	private static final String MIN_UPPERCASE_CONFIG = "min_uppercase";
	public static final String VALID_PASSWORD_MESSAGE = "Password follows minimum %d uppercase letters.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have minimum %d uppercase letters.";

	private int minUppercase;

	public MinUppercaseValidation() {
	}

	public int getMinUppercase() {
		return this.minUppercase;
	}

	private void setMinUppercase(String minUppercase) {
		int intMinUppercase;
		try {
			intMinUppercase = Integer.parseInt(minUppercase);
		} catch (Exception e) {
			e.printStackTrace();
			intMinUppercase = 0;
		}

		if (intMinUppercase <= 0) {
			this.minUppercase = 0;
		} else {
			this.minUppercase = intMinUppercase;
		}
	}

	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		int upperCase = 0;
		String configValue;

		try {
			configValue = config.getConfig(MIN_UPPERCASE_CONFIG);
		} catch (Exception e) {
			e.printStackTrace();
			configValue = null;
		}

		setMinUppercase(configValue);

		if (null == password) {
			return false;
		}

		if (this.minUppercase == 0) {
			return true;
		}

		for (int i = 0; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i))) {
				upperCase++;
			}
		}
		if (upperCase < this.minUppercase) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String getValidationFailureMessage(String password, IPasswordValidationConfiguration config) {
		if (isValidPassword(password, config)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.minUppercase);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.minUppercase);
		}
	}

}
