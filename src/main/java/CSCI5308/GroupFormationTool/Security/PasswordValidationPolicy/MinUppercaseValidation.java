package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

public class MinUppercaseValidation implements IPasswordValidation {

	private static final String MIN_UPPERCASE = "min_uppercase";
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
		}
		catch (Exception e) {
			e.printStackTrace();
			intMinUppercase = 0;
		}
		
		if (intMinUppercase <= 0) {
			this.minUppercase = 0;
		}
		else {
			this.minUppercase = intMinUppercase;
		}
	}
	
	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		int upperCase = 0;
		String configValue;
		
		try {
			configValue = config.getConfig(MIN_UPPERCASE);
		}
		catch (Exception e) {
			// log the Exception
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
		    // Check for uppercase letters.
		    if (Character.isUpperCase(password.charAt(i))) 
		    	upperCase++;
		}
		if (upperCase < this.minUppercase) {
			return false;
		}
		else {
			return true;
		}
	}
	
	@Override
	public String getPasswordValidationMessage(String password, IPasswordValidationConfiguration config) {
		if (isValidPassword(password, config)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.minUppercase);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.minUppercase);
		}
	}

}
