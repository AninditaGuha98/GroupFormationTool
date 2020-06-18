package CSCI5308.GroupFormationTool.SecurityTest.PasswordValidationPolicyTest.Repository;

import CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface.IPasswordHistoryPersistence;

public class PasswordHistoryPersistenceMock implements IPasswordHistoryPersistence {

	private boolean result;
	
	public PasswordHistoryPersistenceMock(boolean result) {
		this.result = result;
	}
	
	@Override
	public boolean isValidHistoryConstraint(String bannerID, String password, int history) {
		return this.result;
	}

}
