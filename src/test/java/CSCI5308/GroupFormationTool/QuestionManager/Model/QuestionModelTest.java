package CSCI5308.GroupFormationTool.QuestionManager.Model;


import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class QuestionModelTest {
    @Test
    void getTypeSelect() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setTypeSelect("1");
        assertSame("1",questionModel.getTypeSelect());
    }

    @Test
    void setTypeSelect() {
        QuestionModel questionModel=new QuestionModel();
        questionModel.setTypeSelect("1");
        assertSame("1",questionModel.getTypeSelect());
    }

    @Test
    void getQuestionTypeList() {
        HashMap<String,String> mock= new HashMap<>();
        mock.put("numeric","Numeric");
        QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionTypeList(mock);
        assertSame(mock,questionModel.getQuestionTypeList());
    }

    @Test
    void setQuestionTypeList() {
        HashMap<String,String> mock= new HashMap<>();
        mock.put("numeric","Numeric");
        QuestionModel questionModel=new QuestionModel();
        questionModel.setQuestionTypeList(mock);
        assertSame(mock,questionModel.getQuestionTypeList());
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