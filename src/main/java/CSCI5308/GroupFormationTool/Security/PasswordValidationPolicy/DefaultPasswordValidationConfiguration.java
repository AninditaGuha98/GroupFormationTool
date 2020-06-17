package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class DefaultPasswordValidationConfiguration implements IPasswordValidationConfiguration {

	private static final String configFile = "passwordValidation.properties";
	
	@Override
	public Map<String, String> getConfigMap(Set<String> configKeys) throws Exception {
		Map<String, String> configMap = new HashMap<>();
		
		if (null == configKeys) {
			throw new Exception("Null Configuration Keys");
		}
		
		try (InputStream input = getClass().getClassLoader().getResourceAsStream(configFile)) {
			Properties p = new Properties();  
			p.load(input);
			for (String key : configKeys) {
				String value = p.getProperty(key);
				configMap.put(key, value);
			}
		}
		catch (IOException e) {
			// Log the IOException
			for (String key : configKeys) {
				configMap.put(key, null);
			}
		}
		return configMap;
	}
}
