package CSCI5308.GroupFormationTool.SurveyResponses;

import CSCI5308.GroupFormationTool.QuestionManager.InterfaceQuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.InterfaceResponses;

import java.util.*;

public interface ISurveyResponseDB {
     HashMap<Integer, Integer> checkIfSurveyPublished(long courseID);
     List<InterfaceQuestionModel> getSurveyQuestions(long surveyID);
     Map<Long, ArrayList<InterfaceResponses>> getSurveyResponses();
}
