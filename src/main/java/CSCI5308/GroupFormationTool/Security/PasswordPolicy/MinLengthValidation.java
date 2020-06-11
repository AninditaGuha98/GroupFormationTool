package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public class MinLengthValidation implements IPasswordValidation {

	private int minLength;
	
	public MinLengthValidation() {
	}
	
	public MinLengthValidation(int minLength) {
	}
	
	public int getMinLength( ) {
		return -1;
	}
	
	public void setMinLength(int minLength) {
	}
	
	@Override
	public boolean isValidPassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
