package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

public interface IPasswordValidation {
	public boolean isValidPassword(String password);
	public String getPasswordValidationMessage(String password);
}
