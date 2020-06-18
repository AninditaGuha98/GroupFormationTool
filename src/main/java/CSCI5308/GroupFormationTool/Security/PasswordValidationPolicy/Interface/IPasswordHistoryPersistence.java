package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface;

public interface IPasswordHistoryPersistence {
	public boolean isValidHistoryConstraint(String bannerID, String password, int history);
}
