package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.SystemConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;

public class SaveSurveyRepo implements ISaveSurveyRepo {

    @Override
    public boolean saveSurvey(long courseID, long userID, int status){
        ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel=SystemConfig.instance().getCreateSurveyQuestionsModel();
        int surveyID;
        CallStoredProcedure proc=null;
        CallStoredProcedure procedure=null;
        CallStoredProcedure procedure1=null;
        CallStoredProcedure procedure2=null;
        ArrayList<Integer> questionsID=new ArrayList<>();
        String [] selectedQuestions;
        try{
            if(status==0){
                surveyID = fetchSurveyID(courseID, status);
                selectedQuestions=iCreateSurveyQuestionsModel.getSelectedQuestions();

                proc=new CallStoredProcedure("spDeleteSavedQuestions(?)");
                proc.setParameter(1,surveyID);
                proc.execute();

                for(int i=0; i<selectedQuestions.length;i++){
                    procedure=new CallStoredProcedure("spGetQuestionIDs(?,?,?)");
                    procedure.setParameter(1,userID);
                    procedure.setParameter(2,selectedQuestions[i]);
                    procedure.setParameter(3,surveyID);
                    ResultSet resultSet=procedure.executeWithResults();
                    if(null!= resultSet){
                        while(resultSet.next()){
                            questionsID.add(resultSet.getInt(1));
                        }
                    }
                }

                for(int i=0;i<questionsID.size();i++){
                    Calendar cal = Calendar.getInstance();
                    java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
                    procedure1 = new CallStoredProcedure("spSaveSurveyQuestions(?,?,?)");
                    procedure1.setParameter(1,surveyID);
                    procedure1.setParameter(2,questionsID.get(i));
                    procedure1.setParameter(3,timestamp);
                    procedure1.execute();
                }
                return true;

            }
            if(status==1){
                procedure2 = new CallStoredProcedure("spPublishSurvey(?)");
                procedure2.setParameter(1,courseID);
                procedure2.execute();
                return true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            if (null!=proc){
                procedure.cleanup();
            }
            if (null!=procedure){
                procedure.cleanup();
            }
            if (null!=procedure1){
                procedure1.cleanup();
            }
            if (null!=procedure2){
                procedure2.cleanup();
            }
        }
        return false;
    }

    public int fetchSurveyID(long courseID,int state){
        int surveyID=0;
        CallStoredProcedure procedure=null;
        try{
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
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        finally {
            if(null!=procedure){
                procedure.cleanup();
            }
        }
        return surveyID;
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

                surveyID=fetchSurveyID(courseID,state);
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
