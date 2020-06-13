package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public class ForbiddenCharSetValidation implements IPasswordValidation {

	private String forbiddenCharSet;
	
	/*
	 * Default constructor sets forbiddenCharSet as empty string.
	 * It means validation is passed.
	 */
	public ForbiddenCharSetValidation() {
		this.forbiddenCharSet = "";
	}
	
	public ForbiddenCharSetValidation(String forbideddenCharSet) {
		this.setForbiddernCharSet(forbideddenCharSet);
	}

	public String getForbiddenCharSet() {
		return this.forbiddenCharSet;
	}
	
	public void setForbiddernCharSet(String forbiddernCharSet) {
		if (null == forbiddernCharSet)
			this.forbiddenCharSet = "";
		else
			this.forbiddenCharSet = forbiddernCharSet;
	}
	
	@Override
	public boolean isValidPassword(String password) {
		if (null == password)
			return false;
		
		if (this.forbiddenCharSet.isEmpty())
			return true;
		
		for (int i=0; i < this.forbiddenCharSet.length(); i++) {
			if (password.contains(String.valueOf(this.forbiddenCharSet.charAt(i))))
				return false;
		}
		return true;
	}

}
