package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public class MaxLengthValidation implements IPasswordValidation {

	private int maxLength;
	
	public MaxLengthValidation() {
		this.maxLength = 12;
	}
	
	public MaxLengthValidation(int maxLength) {
		this.setMaxLength(maxLength);
	}
	
	public int getMaxLength() {
		return this.maxLength;
	}
	
	public void setMaxLength(int maxLength) {
		if (maxLength <= 0)
			this.maxLength = 12;
		else
			this.maxLength = maxLength;
	}
	
	@Override
	public boolean isValidPassword(String password) {
		if (null == password)
			return false;
		else if (password.isEmpty())
			return false;
		
		if (password.length() > this.maxLength)
			return false;
		else
			return true;
	}
}
