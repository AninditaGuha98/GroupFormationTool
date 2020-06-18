package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

public class PasswordHistoryDB implements IPasswordHistoryPersistence {

	@Override
	public boolean isValidHistoryConstraint(String bannerID, String password, int history) {
		// TODO Auto-generated method stub
		return true;
	}

}
