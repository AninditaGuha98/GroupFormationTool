package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy.Interface;

public interface IPasswordHistoryPersistence {
	public boolean followedHistoryConstraint(String bannerID, String password, int history);
}
