package CSCI5308.GroupFormationTool.Security.PasswordValidationPolicy;

import java.sql.ResultSet;
import java.sql.SQLException;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class PasswordHistoryDB implements IPasswordHistoryPersistence {

	@Override
	public boolean isValidHistoryConstraint(String bannerID, String password, int history) {
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
		catch (SQLException e)
		{
			// Logging needed.
			e.printStackTrace();
		}
		finally
		{
			if (null != proc)
			{
				proc.cleanup();
			}
		}
		return isValid;
	}
}
