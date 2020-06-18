package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface;

import java.util.List;

public interface IPasswordValidationManager {
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config);
	public List<String> getPasswordValidationFailures(String password, IPasswordValidationConfiguration config);
}
