package CSCI5308.GroupFormationTool.Survey;

public interface IQueryQuestionsRepo {

    ICreateSurveyQuestionsModel listQuestionsForUser (long userID);
}
