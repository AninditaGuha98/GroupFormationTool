package CSCI5308.GroupFormationTool.QuestionManager.Model;

public class QuestionModel {
    private String questionType;
    private String questionTitle;
    private String questionText;
    private String responseText;
    private int responseScore;

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public int getResponseScore() {
        return responseScore;
    }

    public void setResponseScore(int responseScore) {
        this.responseScore = responseScore;
    }
}
