package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.DefaultPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.IPasswordValidationConfiguration;

class DefaultPasswordValidationConfigurationTest {

	private static final String MIN_LENGTH = "min_length";
	private static final String MAX_LENGTH = "max_length";
	private static final String MIN_LOWERCASE = "min_lowercase";
	private static final String MIN_UPPERCASE = "min_uppercase";
	private static final String MIN_NON_ALPHANUM = "min_non_alphanum";
	private static final String FORBIDDEN_CHARSET = "forbidden_charset";
	private static final String HISTORY_CONSTRAINT = "history_constraint";
	
	private Map<String, String> passwordValidationAssertionMap;

	public DefaultPasswordValidationConfigurationTest() {
		passwordValidationAssertionMap = new HashMap<>();
		initializePasswordValidationList();
	}
	
	private void initializePasswordValidationList() {
		passwordValidationAssertionMap.put(MIN_LENGTH, "8");
		passwordValidationAssertionMap.put(MAX_LENGTH, "12");
		passwordValidationAssertionMap.put(MIN_LOWERCASE, "2");
		passwordValidationAssertionMap.put(MIN_UPPERCASE, "2");
		passwordValidationAssertionMap.put(MIN_NON_ALPHANUM, "2");
		passwordValidationAssertionMap.put(FORBIDDEN_CHARSET, "\\&\"'");
		passwordValidationAssertionMap.put(HISTORY_CONSTRAINT, "4");
	}
	
	
	@Test
	void getConfigTest() {
		IPasswordValidationConfiguration defConfig = 
				SystemConfig.instance().getPasswordValidationConfiguration();
		String configValue;
		
		try {
			for (String configKey : passwordValidationAssertionMap.keySet()) {
				configValue = passwordValidationAssertionMap.get(configKey);
				assertEquals(configValue, defConfig.getConfig(configKey));
			}
		}
		catch (Exception e) {
			// Log the Exception
			e.printStackTrace();
		}
		
	}
	
	@Test
	void getConfigNonExistingKeyTest() {
		IPasswordValidationConfiguration defConfig = 
				SystemConfig.instance().getPasswordValidationConfiguration();
		String configValue;
		
		try {
			configValue = defConfig.getConfig("non_existing_key");
			assertEquals(null, configValue);
		}
		catch (Exception e) {
			// Log the exception
			e.printStackTrace();
		}
		
	}
	

	@Test
	void getConfigNullKeyTest() {
		IPasswordValidationConfiguration defConfig = 
				SystemConfig.instance().getPasswordValidationConfiguration();
		String configValue;
		
		try {
			configValue = defConfig.getConfig(null);
			assertTrue(false);
		}
		catch (Exception e) {
			// Log the exception
			e.printStackTrace();
			assertEquals(e.getMessage(), "Null Key");
		}
	}

}
