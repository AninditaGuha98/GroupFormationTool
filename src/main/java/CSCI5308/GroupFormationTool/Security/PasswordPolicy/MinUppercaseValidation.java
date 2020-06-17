package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public class MinUppercaseValidation implements IPasswordValidation {

	public static final String VALID_PASSWORD_MESSAGE = "Password follows minimum uppercase letters of %d.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must have minimum uppercase letters of %d.";
	
	private int minUppercase;
	
	/*
	 * Default constructor sets minUppercase = 0.
	 * It means Uppercase Validation is passed.
	 */
	public MinUppercaseValidation() {
		this.minUppercase = 0;
	}
	
	/*
	 * For negative minUppercase sets minUppercase = 0
	 * It means Uppercase Validation is passed.
	 */
	public MinUppercaseValidation(String minUppercase) {
		try {
			int intMinUppercase = Integer.parseInt(minUppercase);
			this.setMinUppercase(intMinUppercase);
		}
		catch (Exception e) {
			e.printStackTrace();
			this.setMinUppercase(0);
		}
	}
	
	public int getMinUppercase() {
		return this.minUppercase;
	}
	
	public void setMinUppercase(int minUppercase) {
		if (minUppercase <= 0)
			this.minUppercase = 0;
		else
			this.minUppercase = minUppercase;
	}
	
	@Override
	public boolean isValidPassword(String password) {
		int upperCase = 0;
		
		if (null == password)
			return false;
		
		if (this.minUppercase == 0)
			return true;

		for (int i = 0; i < password.length(); i++) {
		    // Check for uppercase letters.
		    if (Character.isUpperCase(password.charAt(i))) 
		    	upperCase++;
		}
		if (upperCase < this.minUppercase)
			return false;
		else
			return true;
	}
	
	@Override
	public String getPasswordValidationMessage(String password) {
		if (isValidPassword(password)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.minUppercase);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.minUppercase);
		}
	}

}
