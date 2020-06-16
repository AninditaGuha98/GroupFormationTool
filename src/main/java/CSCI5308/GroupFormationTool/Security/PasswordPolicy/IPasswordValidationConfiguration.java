package CSCI5308.GroupFormationTool.Security.PasswordPolicy;

import java.util.Map;
import java.util.Set;

public interface IPasswordValidationConfiguration {
	public Map<String, String> getConfigMap(Set<String> configKeys) throws Exception;
}
