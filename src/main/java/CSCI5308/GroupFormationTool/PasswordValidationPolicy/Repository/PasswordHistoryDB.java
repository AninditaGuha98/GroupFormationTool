package CSCI5308.GroupFormationTool.PasswordValidationPolicy.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.PasswordValidationPolicy.Interface.IPasswordHistoryPersistence;

public class PasswordHistoryDB implements IPasswordHistoryPersistence {

	@Override
	public boolean followedHistoryConstraint(String bannerID, String password, int history) {
		CallStoredProcedure proc = null;
		boolean isValid = false;
		
		try {
			proc = new CallStoredProcedure("spFindPasswordHistory(?, ?, ?)");
			proc.setParameter(1, bannerID);
			proc.setParameter(2,  password);
			proc.setParameter(3,  history);
			ResultSet results = proc.executeWithResults();
			if (results.next() == false) {
				isValid = true;
			}
		}
		catch (SQLException e)	{
			e.printStackTrace();
		}
		finally	{
			if (null != proc) {
				proc.cleanup();
			}
		}
		return isValid;
	}
}
