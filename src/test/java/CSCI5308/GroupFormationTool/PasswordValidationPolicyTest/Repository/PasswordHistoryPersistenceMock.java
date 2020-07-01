package CSCI5308.GroupFormationTool.PasswordValidationPolicyTest.Repository;

import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordHistoryPersistence;

public class PasswordHistoryPersistenceMock implements IPasswordHistoryPersistence {

	private boolean result;
	
	public PasswordHistoryPersistenceMock(boolean result) {
		this.result = result;
	}
	
	@Override
	public boolean followedHistoryConstraint(String bannerID, String password, int history) {
		return this.result;
	}

}
