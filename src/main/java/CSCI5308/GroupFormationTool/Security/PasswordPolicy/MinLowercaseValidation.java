package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public class MinLowercaseValidation implements IPasswordValidation {

	private int minLowercase;
	
	/*
	 * Default constructor sets minLowercase = 0.
	 * It means Lowercase Validation is passed.
	 */
	public MinLowercaseValidation() {
		this.minLowercase = 0;
	}
	
	/*
	 * For negative minLowercase sets minLowercase = 0
	 * It means Lowercase Validation is passed.
	 */
	public MinLowercaseValidation(int minLowercase) {
		this.setMinLowercase(minLowercase);
	}
	
	public int getMinLowercase() {
		return this.minLowercase;
	}
	
	public void setMinLowercase(int minLowercase) {
		if (minLowercase <= 0)
			this.minLowercase = 0;
		else
			this.minLowercase = minLowercase;
	}
	
	@Override
	public boolean isValidPassword(String password) {
		int lowerCase = 0;
		
		if (null == password)
			return false;
		
		if (this.minLowercase == 0)
			return true;

		for (int i = 0; i < password.length(); i++) {
		    // Check for lowercase letters.
		    if (Character.isLowerCase(password.charAt(i))) 
		    	lowerCase++;
		}
		if (lowerCase < this.minLowercase)
			return false;
		else
			return true;
				
			
	}

}
