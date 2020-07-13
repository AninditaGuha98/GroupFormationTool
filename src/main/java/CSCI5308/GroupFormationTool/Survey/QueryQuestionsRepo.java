package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.SystemConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class QueryQuestionsRepo implements IQueryQuestionsRepo {

    @Override
    public ICreateSurveyQuestionsModel listQuestionsForUser (long userID){
        ArrayList<Integer> questionID=new ArrayList<>();
        ArrayList<String> questionHeading=new ArrayList<>();
        ArrayList<String> questionType=new ArrayList<>();

        CallStoredProcedure procedure = null;
        try {
            procedure = new CallStoredProcedure("spListSurveyQuestions(?)");
            procedure.setParameter(1, userID);
            ResultSet results = procedure.executeWithResults();
            if (null != results) {
                while (results.next()) {
                    questionID.add(results.getInt(1));
                    questionHeading.add(results.getString(2));
                    questionType.add(results.getString(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != procedure) {
                procedure.cleanup();
            }
        }

        String[] questionsList = questionHeading.toArray(new String[0]);
        String[] questionsType = questionType.toArray(new String[0]);
        ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel = SystemConfig.instance().getCreateSurveyQuestionsModel();
        iCreateSurveyQuestionsModel.setQuestionHeading(questionsList);
        iCreateSurveyQuestionsModel.setQuestionType(questionsType);

        return iCreateSurveyQuestionsModel;
    }
}
