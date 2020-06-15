package CSCI5308.GroupFormationTool.QuestionManager.Model;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionModelTest {

    @Test
    void getQuestionType() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionType("mcq1");
        assertSame("mcq1",questionModel.getQuestionType());
    }

    @Test
    void setQuestionType() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionType("mcq2");
        assertSame("mcq2",questionModel.getQuestionType());
    }

    @Test
    void getQuestionTitle() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionTitle("Course Credits");
        assertSame("Course Credits",questionModel.getQuestionTitle());
    }

    @Test
    void setQuestionTitle() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionTitle("Course Credits");
        assertSame("Course Credits",questionModel.getQuestionTitle());
    }

    @Test
    void getQuestionText() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionText("How many credit hours is the course?");
        assertSame("How many credit hours is the course?",questionModel.getQuestionText());
    }

    @Test
    void setQuestionText() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionText("How many credit hours is the course?");
        assertSame("How many credit hours is the course?",questionModel.getQuestionText());
    }

    @Test
    void getResponseText() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setResponseText("responsetext");
        assertSame("responsetext",questionModel.getResponseText());
    }

    @Test
    void setResponseText() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setResponseText("responsetext");
        assertSame("responsetext",questionModel.getResponseText());
    }

    @Test
    void getResponseScore() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setResponseScore(3);
        assertSame(3,questionModel.getResponseScore());
    }

    @Test
    void setResponseScore() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setResponseScore(3);
        assertSame(3,questionModel.getResponseScore());
    }
}