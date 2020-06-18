package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidation;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;

public class MaxLengthValidation implements IPasswordValidation {

	private static final String MAX_LENGTH = "max_length";
	public static final String VALID_PASSWORD_MESSAGE = "Password follows maximum length of %d.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have muximum length of %d.";
	
	private int maxLength;
	
	public MaxLengthValidation() {
	}
	
	public int getMaxLength() {
		return this.maxLength;
	}
	
	private void setMaxLength(String maxLength) {
		int intMaxLength;
		try {
			intMaxLength = Integer.parseInt(maxLength);
		}
		catch (Exception e) {
			e.printStackTrace();
			intMaxLength = 0;
		}
		
		if (intMaxLength <= 0) {
			this.maxLength = 0;
		}
		else {
			this.maxLength = intMaxLength;
		}
	}
	
	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		String configValue;
		
		try {
			configValue = config.getConfig(MAX_LENGTH);
		}
		catch (Exception e) {
			// log the Exception
			configValue = null;
		}
		
		setMaxLength(configValue);
		
		if (null == password) {
			return false;
		}
		
		if (this.maxLength == 0) {
			return true;
		}
		
		if (password.length() > this.maxLength) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public String getPasswordValidationMessage(String password, IPasswordValidationConfiguration config) {
		if (isValidPassword(password, config)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.maxLength);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.maxLength);
		}
	}
}
