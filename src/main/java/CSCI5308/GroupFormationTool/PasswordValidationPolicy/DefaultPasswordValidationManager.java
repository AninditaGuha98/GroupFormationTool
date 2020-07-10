package CSCI5308.GroupFormationTool.PasswordValidationPolicy;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.SystemConfig;

public class DefaultPasswordValidationManager implements IPasswordValidationManager {

	private IPasswordValidationFactory factory;
	private List<IPasswordValidation> moduleList;
	
	public DefaultPasswordValidationManager() {
		factory = SystemConfig.instance().getPasswordValidationFactory();
		moduleList = new ArrayList<IPasswordValidation>();
		
		moduleList.add(factory.createMinLengthValidation());
		moduleList.add(factory.createMaxLenghtValidation());
		moduleList.add(factory.createMinLowerCaseValidation());
		moduleList.add(factory.createMinUpperCaseValidation());
		moduleList.add(factory.createMinNonAlphaNumValidation());
		moduleList.add(factory.createForbiddenCharSetValidation());
		moduleList.add(factory.createHistoryConstraintValidation());
	}

	@Override
	public boolean isValidPassword(String password) {
		IPasswordValidationConfiguration configuration = factory.createPasswordValidationConfig();
		for (IPasswordValidation validationModule: moduleList) {
			if (!validationModule.isValidPassword(password, configuration))
				return false;
		}
		return true;
	}

	@Override
	public List<String> getPasswordValidationFailures(String password) {
		IPasswordValidationConfiguration configuration = factory.createPasswordValidationConfig();
		List<String> failureMessages = new ArrayList<String>();

		for (IPasswordValidation validationModule : moduleList) {
			if (!validationModule.isValidPassword(password, configuration))
				failureMessages.add(validationModule.getValidationFailureMessage(password, configuration));
		}

		return failureMessages;
	}
}
