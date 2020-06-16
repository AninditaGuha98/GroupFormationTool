package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public class MaxLengthValidation implements IPasswordValidation {

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
}
