package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

import java.util.regex.Pattern;

public class MinNonAlphaNumValidation implements IPasswordValidation {

	public static final String VALID_PASSWORD_MESSAGE = "Password has minimum %d special characters.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have minimum %d special characters.";
	
	private final static String NON_ALPHA_NUM_PATTERN="[^a-zA-Z0-9]";
	private int minNonAlphaNum;
	
	/*
	 * Default constructor sets minNonAlphaNum = 0
	 * It means no password validation is done.
	 */
	public MinNonAlphaNumValidation() {
		this.minNonAlphaNum = 0;
	}
	
	public MinNonAlphaNumValidation(String minNonAlphaNum) {
		try {
			int intMinNonAlphaNum = Integer.parseInt(minNonAlphaNum);
			this.setMinNonAlphaNum(intMinNonAlphaNum);
		}
		catch (Exception e) {
			e.printStackTrace();
			this.setMinNonAlphaNum(0);
		}
	}
	
	public int getMinNonAlphaNum() {
		return this.minNonAlphaNum;
	}
	
	public void setMinNonAlphaNum(int minNonAlphaNum) {
		if (minNonAlphaNum <= 0)
			this.minNonAlphaNum = 0;
		else
			this.minNonAlphaNum = minNonAlphaNum;
	}
	
	@Override
	public boolean isValidPassword (String password) {
		int nonAlphaNumChars = 0;
		
		if (null == password)
			return false;
		if (this.minNonAlphaNum == 0)
			return true;
		
		Pattern nonAlphaNumPattern = Pattern.compile(NON_ALPHA_NUM_PATTERN);
	    for (int i=0; i < password.length(); i++) {
	        if (nonAlphaNumPattern.matcher(password.substring(i, i+1)).matches()) {
	        	nonAlphaNumChars++;
	        }
	    }
	    
	    if (nonAlphaNumChars < this.minNonAlphaNum)
	    	return false;
	    else
	    	return true;
	}
	
	@Override
	public String getPasswordValidationMessage(String password) {
		if (isValidPassword(password)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.minNonAlphaNum);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.minNonAlphaNum);
		}
	}
	
	
}
