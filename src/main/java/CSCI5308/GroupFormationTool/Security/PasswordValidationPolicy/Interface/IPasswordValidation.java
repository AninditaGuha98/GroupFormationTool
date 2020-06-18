package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface;

public interface IPasswordValidation {
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config);
	public String getValidationFailureMessage(String password, IPasswordValidationConfiguration config);
}
