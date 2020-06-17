package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

import java.util.regex.Pattern;

public class MinNonAlphaNumValidation implements IPasswordValidation {

	private static final String MIN_NON_ALPHANUM = "min_non_alphanum";
	public static final String VALID_PASSWORD_MESSAGE = "Password has minimum %d special characters.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have minimum %d special characters.";
	
	private final static String NON_ALPHA_NUM_PATTERN="[^a-zA-Z0-9]";
	private int minNonAlphaNum;
	
	public MinNonAlphaNumValidation() {
	}
	
	
	public int getMinNonAlphaNum() {
		return this.minNonAlphaNum;
	}
	
	public void setMinNonAlphaNum(String minNonAlphaNum) {
		int intMinNonAlphaNum;
		try {
			intMinNonAlphaNum = Integer.parseInt(minNonAlphaNum);
		}
		catch (Exception e) {
			e.printStackTrace();
			intMinNonAlphaNum = 0;
		}
		
		if (intMinNonAlphaNum <= 0)
			this.minNonAlphaNum = 0;
		else
			this.minNonAlphaNum = intMinNonAlphaNum;
	}
	
	@Override
	public boolean isValidPassword (String password, IPasswordValidationConfiguration config) {
		int nonAlphaNumChars = 0;
		String configValue;
		
		try {
			configValue = config.getConfig(MIN_NON_ALPHANUM);
		}
		catch (Exception e) {
			// log the Exception
			configValue = null;
		}
		
		setMinNonAlphaNum(configValue);
		
		if (null == password) {
			return false;
		}
		
		if (this.minNonAlphaNum == 0) {
			return true;
		}
		
		Pattern nonAlphaNumPattern = Pattern.compile(NON_ALPHA_NUM_PATTERN);
	    for (int i=0; i < password.length(); i++) {
	        if (nonAlphaNumPattern.matcher(password.substring(i, i+1)).matches()) {
	        	nonAlphaNumChars++;
	        }
	    }
	    
	    if (nonAlphaNumChars < this.minNonAlphaNum) {
	    	return false;
	    }
	    else {
	    	return true;
	    }
	}
	
	@Override
	public String getPasswordValidationMessage(String password, IPasswordValidationConfiguration config) {
		if (isValidPassword(password, config)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.minNonAlphaNum);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.minNonAlphaNum);
		}
	}
	
}