package CSCI5308.GroupFormationTool.Survey;

public class CreateSurveyQuestionsModel implements ICreateSurveyQuestionsModel {

    private String[] questionHeading;
    private String[] questionType;
    private Integer[] questionID;
    private String [] selectedQuestions;

    @Override
    public String[] getQuestionType() {
        return questionType;
    }

    @Override
    public void setQuestionType(String[] questionType) {
        this.questionType = questionType;
    }

    @Override
    public String[] getQuestionHeading() {
        return questionHeading;
    }

    @Override
    public void setQuestionHeading(String[] questionHeading) {
        this.questionHeading = questionHeading;
    }

    @Override
    public Integer[] getQuestionID() {
        return questionID;
    }

    @Override
    public void setQuestionID(Integer[] questionID) {
        this.questionID = questionID;
    }

    @Override
    public String[] getSelectedQuestions() {
        return selectedQuestions;
    }

    @Override
    public void setSelectedQuestions(String[] selectedQuestions) {
        this.selectedQuestions = selectedQuestions;
    }
}
