package CSCI5308.GroupFormationTool.Survey;

public interface ICreateSurveyQuestionsModel {
    String[] getQuestionType();

    void setQuestionType(String[] questionType);

    String[] getQuestionHeading();

    void setQuestionHeading(String[] questionHeading);

    Integer[] getQuestionID();

    void setQuestionID(Integer[] questionID);


    String[] getSelectedQuestions();

    void setSelectedQuestions(String[] selectedQuestions);
}
