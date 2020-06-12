package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public class MinUppercaseValidation implements IPasswordValidation {

	private int minUppercase;
	
	/*
	 * Default constructor sets minUppercase = 0.
	 * It means Uppercase Validation is passed.
	 */
	public MinUppercaseValidation() {
	}
	
	/*
	 * For negative minLowercase sets minUppercase = 0
	 * It means Uppercase Validation is passed.
	 */
	public MinUppercaseValidation(int minLowercase) {
	}
	
	public int getMinUppercase() {
		return -1;
	}
	
	public void setMinUppercase(int minUppercase) {
	}
	
	@Override
	public boolean isValidPassword(String password) {
		return false;
	}

}
