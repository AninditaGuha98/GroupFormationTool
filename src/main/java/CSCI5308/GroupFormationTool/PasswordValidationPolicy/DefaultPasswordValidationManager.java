package CSCI5308.GroupFormationTool.PasswordValidationPolicy;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CSCI5308.GroupFormationTool.SystemConfig;

public class DefaultPasswordValidationManager implements IPasswordValidationManager {

	private static final Logger logger = LoggerFactory.getLogger(DefaultPasswordValidationManager.class); 
	private IPasswordValidationFactory factory;
	private List<IPasswordValidation> moduleList;
	
	public DefaultPasswordValidationManager() {
		factory = SystemConfig.instance().getPasswordValidationFactory();
		moduleList = new ArrayList<IPasswordValidation>();
		
		logger.info("password={}, action={}, status={}",
				"ValidationManager", "Add Policies", "Starting...");
		moduleList.add(factory.createMinLengthValidation());
		moduleList.add(factory.createMaxLenghtValidation());
		moduleList.add(factory.createMinLowerCaseValidation());
		moduleList.add(factory.createMinUpperCaseValidation());
		moduleList.add(factory.createMinNonAlphaNumValidation());
		moduleList.add(factory.createForbiddenCharSetValidation());
		moduleList.add(factory.createHistoryConstraintValidation());
		logger.info("password={}, action={}, status={}",
				"ValidationManager", "Add Policies", "Done");
	}

	@Override
	public boolean isValidPassword(String password) {
		IPasswordValidationConfiguration configuration = factory.createPasswordValidationConfig();
		
		logger.info("password={}, action={}, status={}",
				"ValidationManager", "Check Password Validity", "Starting...");
		for (IPasswordValidation validationModule: moduleList) {
			if (validationModule.isValidPassword(password, configuration)) {
			} else {
				logger.info("password={}, action={}, status={}",
						"ValidationManager", "Check Password Validity", "Failed");
				return false;
			}
		}
		logger.info("password={}, action={}, status={}",
				"ValidationManager", "Check Password Validity", "Success");
		return true;
	}

	@Override
	public List<String> getPasswordValidationFailures(String password) {
		IPasswordValidationConfiguration configuration = factory.createPasswordValidationConfig();
		List<String> failureMessages = new ArrayList<String>();

		logger.info("password={}, action={}, status={}",
				"ValidationManager", "Get Validity Messages", "Starting...");
		for (IPasswordValidation validationModule : moduleList) {
			if (validationModule.isValidPassword(password, configuration)) {
			} else {
				failureMessages.add(validationModule.getValidationFailureMessage(password, configuration));
			}
		}
		logger.info("password={}, action={}, status={}",
				"ValidationManager", "Get Validity Messages", "Done");
		return failureMessages;
	}
}
