package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveSurveyRepo {

    public boolean saveSurvey(long courseID,int status){


        if(status==0){

        }
        CallStoredProcedure procedure = null;
        CallStoredProcedure proc=null;
        try {
            procedure = new CallStoredProcedure("spCreateSurvey(?,?)");
            procedure.setParameter(1, courseID);
            procedure.setParameter(2,status);
            procedure.execute();



//
//            proc=new CallStoredProcedure("spSaveSurveyQuestions(?,?,?)");
//            proc.setParameter(1,surveyID);
//            proc.setParameter(2,queID);
//            proc.setParameter(3,datetime.date);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }

        return true;
    }
}
