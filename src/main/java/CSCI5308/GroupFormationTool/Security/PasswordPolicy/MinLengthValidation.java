package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public class MinLengthValidation implements IPasswordValidation {

	private int minLength;
	
	public MinLengthValidation() {
		this.minLength = 8;
	}
	
	public MinLengthValidation(int minLength) {
		this.setMinLength(minLength);
	}
	
	public int getMinLength() {
		return this.minLength;
	}
	
	public void setMinLength(int minLength) {
		if ( minLength <= 0 )
			this.minLength = 8;
		else
			this.minLength = minLength;
	}
	
	@Override
	public boolean isValidPassword(String password) {
		// TODO Auto-generated method stub
		if (null == password)
			return false;
		else if (password.isEmpty())
			return false;
		if (password.length() >= this.minLength)
			return true;
		else 
			return false;
	}
}
