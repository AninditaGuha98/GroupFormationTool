package CSCI5308.GroupFormationTool.QuestionManager;

import java.util.HashMap;

import CSCI5308.GroupFormationTool.QuestionManager.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.InterfaceQuestionModel;

public class QuestionModel implements InterfaceQuestionModel {
    private String typeSelect;
    private String questionTitle;
    private String questionText;
    private String responseText;
    private int responseScore;
    private Long userID;

    @Override
    public Long getUserID() {
        return userID;
    }

    @Override
    public void setUserID(Long userID) {
        this.userID = userID;
    }

    private HashMap<String, String> questionTypeList = new HashMap<>();

    public QuestionModel() {
        this.questionTypeList.put("numeric", "Numeric");
        this.questionTypeList.put("mcq1", "Multiple Choice Question, Choose One");
        this.questionTypeList.put("mcq2", "Multiple Choice Question, Choose Multiple");
        this.questionTypeList.put("free", "Free Text");
    }

    @Override
    public String getTypeSelect() {
        return typeSelect;
    }

    @Override
    public void setTypeSelect(String typeSelect) {
        this.typeSelect = typeSelect;
    }

    @Override
    public HashMap<String, String> getQuestionTypeList() {
        return questionTypeList;
    }

    @Override
    public void setQuestionTypeList(HashMap<String, String> questionTypeList) {
        this.questionTypeList = questionTypeList;
    }

    @Override
    public String getQuestionTitle() {
        return questionTitle;
    }

    @Override
    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    @Override
    public String getQuestionText() {
        return questionText;
    }

    @Override
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public String getResponseText() {
        return responseText;
    }

    @Override
    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    @Override
    public int getResponseScore() {
        return responseScore;
    }

    @Override
    public void setResponseScore(int responseScore) {
        this.responseScore = responseScore;
    }

    @Override
    public boolean createQuestion(IQuestionsPersistence questionDB) {
        return questionDB.createQuestion(this);
    }

}