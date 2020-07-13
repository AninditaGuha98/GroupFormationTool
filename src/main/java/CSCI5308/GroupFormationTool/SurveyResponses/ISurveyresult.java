package CSCI5308.GroupFormationTool.SurveyResponses;

public interface ISurveyresult {
    boolean checkIfResponseSubmitted(long userID);
    boolean submitSurveyResponse(long userID, long surveyID, long questionID, String response);
}
