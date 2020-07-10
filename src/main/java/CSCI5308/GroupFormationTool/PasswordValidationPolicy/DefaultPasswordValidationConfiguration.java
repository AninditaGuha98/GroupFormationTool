package CSCI5308.GroupFormationTool.PasswordValidationPolicy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.LoggerFactory;


public class DefaultPasswordValidationConfiguration implements IPasswordValidationConfiguration {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DefaultPasswordValidationConfiguration.class); 
	private static final String CONFIG_FILE = "passwordValidation.properties";

	@Override
	public String getConfig(String configKey) throws IllegalArgumentException {
		String configValue;

		if (null == configKey) {
			throw new IllegalArgumentException("Null Key can not be retrieved.");
		}

		try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
			Properties p = new Properties();
			p.load(input);
			configValue = p.getProperty(configKey);
			logger.info("password={}, action={}, status={}",
					"ValidationConfiguration", "Get Key/Value", "Success");
		} catch (IOException e) {
			logger.warn("password={}, action={}, status={}, message={}",
					"ValidationConfiguration", "Get Key/Value", "Fail", e.getMessage());
			configValue = null;
		}
		return configValue;
	}
}
