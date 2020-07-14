package CSCI5308.GroupFormationTool.SurveyResponses;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SurveyResultDB implements ISurveyresultDB {

    @Override
    public boolean checkIfResponseSubmitted(long userID, long surveyID) {
        CallStoredProcedure proc = null;
        ResultSet results;
        Boolean present;
        try {
            proc = new CallStoredProcedure("spFindSurveyResponse(?,?)");
            proc.setParameter(1, userID);
            proc.setParameter(2,surveyID);
            results= proc.executeWithResults();
            present= results.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return present;
    }

    @Override
    public boolean submitSurveyResponse(long userID, long surveyID, long questionID, String result){
        CallStoredProcedure proc = null;
        try {
            proc = new CallStoredProcedure("spCreateSurveyResponse(?,?,?,?)");
            proc.setParameter(1, userID);
            proc.setParameter(2,surveyID);
            proc.setParameter(3, questionID);
            proc.setParameter(4, result);
            proc.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } finally {
            if (null != proc) {
                proc.cleanup();
            }
        }
        return true;
    }
}
