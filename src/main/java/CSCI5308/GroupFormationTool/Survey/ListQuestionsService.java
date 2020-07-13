package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.SystemConfig;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class ListQuestionsService implements IListQuestionsService {

    IQueryQuestionsRepo iQueryQuestionsRepo= SystemConfig.instance().getQueryQuestionsRepo();
    ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel=SystemConfig.instance().getCreateSurveyQuestionsModel();


    Dictionary hashmap= new Hashtable<>();
    @Override
    public Dictionary listAllQuestionsforUser(long userID){

        iCreateSurveyQuestionsModel=iQueryQuestionsRepo.listQuestionsForUser(userID);
        for(int i =0; i<iCreateSurveyQuestionsModel.getQuestionHeading().length;i++)
        {
            hashmap.put(iCreateSurveyQuestionsModel.getQuestionHeading()[i],iCreateSurveyQuestionsModel.getQuestionType()[i]);
        }
        return hashmap;
    }

    @Override
    public Dictionary listRepeatQuestions(){
        for(int i =0; i<iCreateSurveyQuestionsModel.getQuestionHeading().length;i++)
        {
            hashmap.put(iCreateSurveyQuestionsModel.getQuestionHeading()[i],iCreateSurveyQuestionsModel.getQuestionType()[i]);
        }
        return hashmap;
    }
}
