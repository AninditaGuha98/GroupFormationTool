package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

public interface IPasswordValidation {
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config);
	public String getPasswordValidationMessage(String password, IPasswordValidationConfiguration config);
}
