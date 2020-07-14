package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class GroupAlgorithmDB implements IGroupAlgorithmDB {

	public List<ISurveyResponse> loadResponses(int surveyID) {
		CallStoredProcedure proc = null;
		List<ISurveyResponse> surveyResponses = new ArrayList<ISurveyResponse>();
		try {
			proc = new CallStoredProcedure("spLoadSurveyUsers(?)");
			proc.setParameter(1, "1");
			ResultSet responseResults;
			ResultSet results = proc.executeWithResults();
			ISurveyResponse surveyResponseObj;
			HashMap<String, String> responseObj;
			if (null != results) {
				while (results.next()) {
					surveyResponseObj =SurveyScaleObjectFactory.createObject(new SurveyResponseObjectFactory());
					surveyResponseObj.setBannerID(results.getString(1));
					surveyResponseObj.setFirstName(results.getString(2));
					surveyResponseObj.setLastName(results.getString(3));
					proc = new CallStoredProcedure("spGetUserResponses(?,?)");
					proc.setParameter(1, "1");
					proc.setParameter(2, results.getString(4));
					responseResults = proc.executeWithResults();
					if (null != responseResults) {
						responseObj = new HashMap<String, String>();
						while (responseResults.next()) {
							responseObj.put(responseResults.getString(1), responseResults.getString(2));
						}
						surveyResponseObj.setQuestionResponses(responseObj);
					}
					surveyResponses.add(surveyResponseObj);
				}
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			if (null != proc) {
				proc.cleanup();
			}
		}
		return surveyResponses;
	}
}
