package CSCI5308.GroupFormationTool.Survey;

public interface IUpdateQuestionsListService {
    ICreateSurveyQuestionsModel displayUpdatedQuestionList(String[] heading, String[] type, String que);
    ICreateSurveyQuestionsModel removeQuestions(String que);
}
