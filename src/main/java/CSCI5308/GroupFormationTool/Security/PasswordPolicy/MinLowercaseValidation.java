package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public class MinLowercaseValidation implements IPasswordValidation {

	private int minLowercase;
	
	/*
	 * Default constructor sets minLowercase = 0.
	 * It means Lowercase Validation is passed.
	 */
	public MinLowercaseValidation() {
	}
	
	/*
	 * For negative minLowercase sets minLowercase = 0
	 * It means Lowercase Validation is passed.
	 */
	public MinLowercaseValidation(int minLowercase) {
	}
	
	public int getMinLowercase() {
		return -1;
	}
	
	public void setMinLowercase(int minLowercase) {
	}
	
	@Override
	public boolean isValidPassword(String password) {
		return false;
	}

}
