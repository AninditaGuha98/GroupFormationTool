package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

public class GroupAlgorithmDB implements IGroupAlgorithmDB {

	public List<ISurveyResponse> loadResponses(int surveyID) {
		CallStoredProcedure proc = null;
		List<ISurveyResponse> surveyResponses = new ArrayList<ISurveyResponse>();
		try {
			proc = new CallStoredProcedure("spLoadSurveyUsers(?)");			
			proc.setParameter(1, "1");
			ResultSet responseResults,optionsCountResult;
			ResultSet results = proc.executeWithResults();
			ISurveyResponse surveyResponseObj;
			List<String> questionsList;
			List<String> studentresponsesList;
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
						questionsList=new ArrayList<String>();
						studentresponsesList=new ArrayList<String>();
						while (responseResults.next()) 
						{							
							if (questionsList.contains(responseResults.getString(1))) {
								int index=questionsList.indexOf(responseResults.getString(1));
								String value=studentresponsesList.get(index);
								studentresponsesList.set(index,value+","+responseResults.getString(2));
								
							}else {
								questionsList.add(responseResults.getString(1));
								int index=questionsList.indexOf(responseResults.getString(1));
								studentresponsesList.add(index,responseResults.getString(2));
							}
						}								
						surveyResponseObj.setQuestions(questionsList);
						surveyResponseObj.setResponses(studentresponsesList);
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
