package CSCI5308.GroupFormationTool.QuestionManager.Model;


import java.sql.Timestamp;

import java.sql.Date;


public class Question {
    private int questionId;
    private int id;
    private String questionTitle;
    private String questionHeading;
    private String questionType;

    private Timestamp dateCreated;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public void setQuestionTitle(String questionTitle) {
        this.questionTitle = questionTitle;
    }

    public String getQuestionHeading() {
        return questionHeading;
    }

    public void setQuestionHeading(String questionHeading) {
        this.questionHeading = questionHeading;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public Timestamp getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Timestamp dateCreated) {
        this.dateCreated = dateCreated;
    }
}
