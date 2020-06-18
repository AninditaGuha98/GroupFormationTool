package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

public class ForbiddenCharSetValidation implements IPasswordValidation {

	private static final String FORBIDDEN_CHARSET = "forbidden_charset";
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
		}
		else {
			this.forbiddenCharSet = forbiddernCharSet;
		}
	}
	
	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		String configValue;
		
		try {
			configValue = config.getConfig(FORBIDDEN_CHARSET);
		}
		catch (Exception e) {
			// log the Exception
			configValue = null;
		}
		
		setForbiddernCharSet(configValue);

		if (null == password) {
			return false;
		}
		if (this.forbiddenCharSet.isEmpty()) {
			return true;
		}
		
		for (int i=0; i < this.forbiddenCharSet.length(); i++) {
			if (password.contains(String.valueOf(this.forbiddenCharSet.charAt(i))))
				return false;
		}
		return true;
	}
	
	@Override
	public String getPasswordValidationMessage(String password, IPasswordValidationConfiguration config) {
		if (isValidPassword(password, config)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.forbiddenCharSet);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.forbiddenCharSet);
		}
	}
}
