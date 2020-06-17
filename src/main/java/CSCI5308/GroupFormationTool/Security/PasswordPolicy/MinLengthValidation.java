package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public class MinLengthValidation implements IPasswordValidation {

	public static final String VALID_PASSWORD_MESSAGE = "Password follows minimum length of %d.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have minimum length of %d.";
			
	private int minLength;
	
	/*
	 * Default constructor sets minLength = 0.
	 * It means minimum length validation is passed.
	 */	
	public MinLengthValidation() {
		this.minLength = 0;
	}
	
	
	/*
	 * For negative minimum length sets minLength = 0
	 * It means minimum length validation is passed.
	 */
	public MinLengthValidation(String minLength) {
		try {
			int intMinLength = Integer.parseInt(minLength);
			this.setMinLength(intMinLength);
		}
		catch (Exception e) {
			e.printStackTrace();
			this.setMinLength(0);
		}
	}
	
	public int getMinLength() {
		return this.minLength;
	}
	
	public void setMinLength(int minLength) {
		if ( minLength <= 0 )
			this.minLength = 0;
		else
			this.minLength = minLength;
	}
	
	@Override
	public boolean isValidPassword(String password) {
		if (null == password) {
			return false;
		}
		
		if (this.minLength == 0) {
			return true;
		}
		
		if (password.length() >= this.minLength) {
			return true;
		}
		else { 
			return false;
		}
	}
	
	@Override
	public String getPasswordValidationMessage(String password) {
		if (isValidPassword(password)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.minLength);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.minLength);
		}
	}
}
