package CSCI5308.GroupFormationTool.Survey;


public interface ISaveSurveyRepo {

    boolean saveSurvey(long courseID, int status);

    boolean getSavedQuestions(long courseID);
}
