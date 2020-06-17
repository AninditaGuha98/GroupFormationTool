package CSCI5308.GroupFormationTool.QuestionManager.Model;

import java.util.HashMap;

import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;

public class QuestionModel {
    private String typeSelect;
    private String questionTitle;
    private String questionText;
    private String responseText;
    private int responseScore;
    private Long userID;
    public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	private HashMap<String, String> questionTypeList = new HashMap<>();
    public QuestionModel(){
        this.questionTypeList.put("numeric","Numeric");
        this.questionTypeList.put("mcq1","Multiple Choice Question, Choose One");
        this.questionTypeList.put("mcq2","Multiple Choice Question, Choose Multiple");
        this.questionTypeList.put("free","Free");
    }

    public String getTypeSelect() {
        return typeSelect;
    }

    public void setTypeSelect(String typeSelect) {
        this.typeSelect = typeSelect;
    }

    public HashMap<String, String> getQuestionTypeList() {
        return questionTypeList;
    }

    public void setQuestionTypeList(HashMap<String, String> questionTypeList) {
        this.questionTypeList = questionTypeList;
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
    
    public boolean createQuestion(IQuestionsPersistence questionDB) {
    	return questionDB.createQuestion(this);
    }
    
    
}
