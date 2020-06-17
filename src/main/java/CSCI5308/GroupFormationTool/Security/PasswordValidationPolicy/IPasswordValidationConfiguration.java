package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

import java.util.Map;
import java.util.Set;

public interface IPasswordValidationConfiguration {
	public String getConfig(String configKey) throws Exception;
}
