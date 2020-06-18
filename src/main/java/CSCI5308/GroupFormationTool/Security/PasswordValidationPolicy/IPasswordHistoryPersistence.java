package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

public interface IPasswordHistoryPersistence {
	public boolean isValidHistoryConstraint(String bannerID, String password, int history);
}
