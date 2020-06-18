package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface;

public interface IPasswordValidation {
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config);

	public String getPasswordValidationMessage(String password, IPasswordValidationConfiguration config);
}
