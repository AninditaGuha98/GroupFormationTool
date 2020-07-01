package CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface;

public interface IPasswordHistoryPersistence {
	public boolean followedHistoryConstraint(String bannerID, String password, int history);
}
