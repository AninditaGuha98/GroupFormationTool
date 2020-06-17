package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

import java.util.Map;
import java.util.Set;

public interface IPasswordValidationConfiguration {
	public Map<String, String> getConfigMap(Set<String> configKeys) throws Exception;
}
