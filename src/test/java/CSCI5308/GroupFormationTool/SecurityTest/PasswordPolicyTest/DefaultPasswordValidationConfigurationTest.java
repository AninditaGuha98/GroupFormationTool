package CSCI5308.GroupFormationTool.SecurityTest.PasswordPolicyTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.Security.PasswordPolicy.DefaultPasswordValidationConfiguration;
import CSCI5308.GroupFormationTool.Security.PasswordPolicy.IPasswordValidationConfiguration;

class DefaultPasswordValidationConfigurationTest {

	private static final String MIN_LENGTH = "min_length";
	private static final String MAX_LENGTH = "max_length";
	private static final String MIN_LOWERCASE = "min_lowercase";
	private static final String MIN_UPPERCASE = "min_uppercase";
	private static final String MIN_NON_ALPHANUM = "min_non_alphanum";
	private static final String FORBIDDEN_CHARSET = "forbidden_charset";
	private static final String HISTORY_CONSTRAINT = "history_constraint";
	private static final Set<String> passwordValidationList = new HashSet<>();

	public DefaultPasswordValidationConfigurationTest() {
		initializePasswordValidationList();
	}
	
	private void initializePasswordValidationList() {
		passwordValidationList.add(MIN_LENGTH);
		passwordValidationList.add(MAX_LENGTH);
		passwordValidationList.add(MIN_LOWERCASE);
		passwordValidationList.add(MIN_UPPERCASE);
		passwordValidationList.add(MIN_NON_ALPHANUM);
		passwordValidationList.add(FORBIDDEN_CHARSET);
		passwordValidationList.add(HISTORY_CONSTRAINT);
	}
	
	
	@Test
	void getConfigMapTest1() {
		Map<String, String> configMap = new HashMap<>();
		IPasswordValidationConfiguration defaultConfig = new DefaultPasswordValidationConfiguration();
		
		try {
			configMap = defaultConfig.getConfigMap(DefaultPasswordValidationConfigurationTest.passwordValidationList);
			assertEquals("8", configMap.get(MIN_LENGTH));
			assertEquals("20", configMap.get(MAX_LENGTH));
			assertEquals("2", configMap.get(MIN_LOWERCASE));
			assertEquals("4", configMap.get(MIN_UPPERCASE));
			assertEquals("2", configMap.get(MIN_NON_ALPHANUM));
			assertEquals("\\&\"'", configMap.get(FORBIDDEN_CHARSET));
			assertEquals("4", configMap.get(HISTORY_CONSTRAINT));
			assertNotEquals("", configMap.get(HISTORY_CONSTRAINT));
			assertEquals(null, configMap.get("non_existing_key"));
		}
		catch (Exception e) {
		}
		
	}
	
	@Test
	void getConfigMapTest2() {
		Map<String, String> configMap = new HashMap<>();
		IPasswordValidationConfiguration defaultConfig = new DefaultPasswordValidationConfiguration();

		try {
			configMap = defaultConfig.getConfigMap(null);
		}
		catch (Exception e) {
			assertEquals(e.getMessage(), "Null Configuration Keys");
		}
		
	}

}
