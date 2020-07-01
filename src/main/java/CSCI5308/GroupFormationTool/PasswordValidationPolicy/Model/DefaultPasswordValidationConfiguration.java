package CSCI5308.GroupFormationTool.PasswordValidationPolicy.Model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;


public class DefaultPasswordValidationConfiguration implements IPasswordValidationConfiguration {

	private static final String CONFIG_FILE = "passwordValidation.properties";

	@Override
	public String getConfig(String configKey) throws Exception {
		String configValue;

		if (null == configKey) {
			throw new Exception("Null Key");
		}

		try (InputStream input = getClass().getClassLoader().getResourceAsStream(CONFIG_FILE)) {
			Properties p = new Properties();
			p.load(input);
			configValue = p.getProperty(configKey);
		} catch (IOException e) {
			e.printStackTrace();
			configValue = null;
		}
		return configValue;
	}
}
