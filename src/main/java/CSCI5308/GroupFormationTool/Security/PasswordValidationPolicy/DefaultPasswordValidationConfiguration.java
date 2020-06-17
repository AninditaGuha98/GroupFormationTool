package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class DefaultPasswordValidationConfiguration implements IPasswordValidationConfiguration {

	private static final String configFile = "passwordValidation.properties";
	
	@Override
	public String getConfig(String configKey) throws Exception {
		String configValue;
		
		if (null == configKey) {
			throw new Exception("Null Key");
		}
		
		try (InputStream input = getClass().getClassLoader().getResourceAsStream(configFile)) {
			Properties p = new Properties();  
			p.load(input);
			configValue = p.getProperty(configKey);
		}
		catch (IOException e) {
			// Log the IOException
			configValue = null;
		}
		return configValue;
	}
}
