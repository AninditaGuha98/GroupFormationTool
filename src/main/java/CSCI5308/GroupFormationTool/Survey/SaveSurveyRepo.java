package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.SystemConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SaveSurveyRepo implements ISaveSurveyRepo {



    @Override
    public boolean saveSurvey(long courseID, int status){
        CallStoredProcedure procedure=null;
        try{
            if(status==0){
                procedure = new CallStoredProcedure("spCreateSurvey(?,?)");
                procedure.setParameter(1,courseID);
                procedure.setParameter(2,status);
                procedure.execute();

            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if (null!=procedure){
                procedure.cleanup();
            }
        }

        return true;
    }


    @Override
    public boolean getSavedQuestions(long courseID) {
        ISurveyExistRepo iSurveyExistRepo= SystemConfig.instance().getSurveyExistRepo();
        int state;
        int surveyID=0;
        ArrayList<String> questions=new ArrayList<>();
        ArrayList<String> questionType=new ArrayList<>();
        state=iSurveyExistRepo.checkSurveyStatus(courseID);
        CallStoredProcedure procedure=null;
        CallStoredProcedure procedure1=null;
        try{
            if(state==0){
                procedure=new CallStoredProcedure("spFetchSurveyID(?,?)");
                procedure.setParameter(1,courseID);
                procedure.setParameter(2,state);
                ResultSet resultSet=procedure.executeWithResults();

                if(null!= resultSet){
                    while(resultSet.next())
                    {
                        surveyID=resultSet.getInt(1);
                    }
                }
                System.out.println("surveyID"+surveyID);

                procedure1=new CallStoredProcedure("spGetSavedData(?)");
                procedure1.setParameter(1,surveyID);
                ResultSet resultSet1=procedure1.executeWithResults();

                if(null!= resultSet1){
                    while(resultSet1.next()){
                        questions.add(resultSet1.getString(1));
                        questionType.add(resultSet1.getString(2));
                    }
                    ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel = SystemConfig.instance().getCreateSurveyQuestionsModel();
                    iCreateSurveyQuestionsModel.setSelectedQuestions(questions.toArray(new String[questions.size()]));
                    iCreateSurveyQuestionsModel.setSelectedTypes(questionType.toArray(new String[questionType.size()]));
                }

            }

            else if(state==1){
                return false;
            }

        }
        catch(SQLException e){
        e.printStackTrace();
    }
        finally {
            if (null != procedure) {
                procedure.cleanup();
            }
            if(null!=procedure1){
                procedure1.cleanup();
            }
        }

    return true;
    }
}
