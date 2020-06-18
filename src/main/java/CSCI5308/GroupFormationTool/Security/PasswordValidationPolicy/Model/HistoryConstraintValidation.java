package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import CSCI5308.GroupFormationTool.Security.BCryptPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.IPasswordEncryption;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordHistoryPersistence;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidation;
import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordValidationConfiguration;

public class HistoryConstraintValidation implements IPasswordValidation {

	private static final String HISTORY_CONSTRAINT = "history_constraint";
	public static final String VALID_PASSWORD_MESSAGE = "Password follows history constraints of %d.";
	public static final String INVALID_PASSWORD_MESSAGE = "Password must no be among your %d previous passwords.";

	private IPasswordHistoryPersistence passwordHistoryPersistence;
	private int historyConstraint;
	
	public HistoryConstraintValidation(IPasswordHistoryPersistence persistence) {
		this.passwordHistoryPersistence = persistence;
	}
	
	public int getHistoryConstraint() {
		return this.historyConstraint;
	}
	
	private void setHistoryConstraint(String historyConstraint) {
		int intHistoryConstraint;
		try {
			intHistoryConstraint = Integer.parseInt(historyConstraint);
		}
		catch (Exception e) {
			e.printStackTrace();
			intHistoryConstraint = 0;
		}
		
		if (intHistoryConstraint <= 0)
			this.historyConstraint = 0;
		else
			this.historyConstraint = intHistoryConstraint;
	}
	
	@Override
	public boolean isValidPassword(String password, IPasswordValidationConfiguration config) {
		String configValue;
		String bannerID = "";
		String encryptedPassword;
		IPasswordEncryption passwordEncryption = new BCryptPasswordEncryption();
		
		if (null == password) {
			return false;
		}
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!authentication.isAuthenticated())	{
			return true;
		}
		bannerID = authentication.getPrincipal().toString();

		try {
			configValue = config.getConfig(HISTORY_CONSTRAINT);
		}
		catch (Exception e) {
			// log the Exception
			configValue = null;
		}
		setHistoryConstraint(configValue);

		if (this.historyConstraint == 0) {
			return true;
		}
		
		encryptedPassword = passwordEncryption.encryptPassword(password);
		if (passwordHistoryPersistence.isValidHistoryConstraint
				(bannerID, encryptedPassword, historyConstraint)) {
			return true;
		}
		return false;
	}

	@Override
	public String getPasswordValidationMessage(String password, IPasswordValidationConfiguration config) {
		if (isValidPassword(password, config)) {
			return String.format(VALID_PASSWORD_MESSAGE, this.historyConstraint);
		} else {
			return String.format(INVALID_PASSWORD_MESSAGE, this.historyConstraint);
		}
	}

}
