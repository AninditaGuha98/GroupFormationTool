package CSCI5308.GroupFormationTool.Survey;

public interface IQueryQuestionsRepo {

    public ICreateSurveyQuestionsModel listQuestionsForUser (long userID);
}
