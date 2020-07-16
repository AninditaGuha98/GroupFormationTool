package CSCI5308.GroupFormationTool.CreateSurvey;

public interface ICreateSurveyDBFactory {
    public ICreateSurveyDB createSurveyDB();
    public IQueryQuestionsRepo queryQuestionsRepo();
    public ISurveyExistRepo surveyExistRepo();
}
