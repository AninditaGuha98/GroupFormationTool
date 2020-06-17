package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

public class MaxLengthValidation implements IPasswordValidation {

	public static final String VALID_PASSWORD_MESSAGE = "Password follows maximum length of %d.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have muximum length of %d.";
	
	private int maxLength;
	
	/*
	 * Default constructor sets minLength = 0.
	 * It means maximum length validation is passed.
	 */
	public MaxLengthValidation() {
		this.maxLength = 0;
	}
	
	/*
	 * For negative maximum length sets maxLength = 0
	 * It means maximum length validation is passed.
	 */
	public MaxLengthValidation(String maxLength) {
		try {
			int intMaxLength = Integer.parseInt(maxLength);
			this.setMaxLength(intMaxLength);
		}
		catch (Exception e) {
			e.printStackTrace();
			this.setMaxLength(0);
		}
	}
	
	public int getMaxLength() {
		return this.maxLength;
	}
	
	public void setMaxLength(int maxLength) {
		if (maxLength <= 0)
			this.maxLength = 0;
		else
			this.maxLength = maxLength;
	}
	
	@Override
	public boolean isValidPassword(String password) {
		if (null == password)
			return false;
		
		if (this.maxLength == 0)
			return true;
		
		if (password.length() > this.maxLength)
			return false;
		else
			return true;
	}
	
	@Override
	public String getPasswordValidationMessage(String password) {
		if (isValidPassword(password)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.maxLength);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.maxLength);
		}
	}
}
