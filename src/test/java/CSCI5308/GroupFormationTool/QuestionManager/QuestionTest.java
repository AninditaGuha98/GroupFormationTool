package CSCI5308.GroupFormationTool.QuestionManager;

import CSCI5308.GroupFormationTool.QuestionManager.Model.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    void getQuestionId() {
        Question question = new Question();
        question.setQuestionId(1);
        assertTrue(1 == question.getQuestionId());
    }

    @Test
    void setQuestionId() {
        Question question = new Question();
        question.setQuestionId(1);
        assertTrue(1 == question.getQuestionId());
    }

    @Test
    void getId() {
        Question question = new Question();
        question.setId(2);
        assertTrue(2 == question.getId());

    }

    @Test
    void setId() {
        Question question = new Question();
        question.setId(2);
        assertTrue(2 == question.getId());
    }

    @Test
    void getQuestionTitle() {
        Question question = new Question();
        question.setQuestionTitle("Credits");
        assertTrue(question.getQuestionTitle().equals("Credits"));
    }

    @Test
    void setQuestionTitle() {
        Question question = new Question();
        question.setQuestionTitle("Credits");
        assertTrue(question.getQuestionTitle().equals("Credits"));
    }

    @Test
    void getQuestionHeading() {
        Question question = new Question();
        question.setQuestionHeading("How many credits you take?");
        assertTrue(question.getQuestionHeading().equals("How many credits you take?"));
    }

    @Test
    void setQuestionHeading() {
        Question question = new Question();
        question.setQuestionHeading("How many credits you take?");
        assertTrue(question.getQuestionHeading().equals("How many credits you take?"));
    }

    @Test
    void getQuestionType() {
        Question question = new Question();
        question.setQuestionType("numeric");
        assertTrue(question.getQuestionType().equals("numeric"));
    }

    @Test
    void setQuestionType() {
        Question question = new Question();
        question.setQuestionType("numeric");
        assertTrue(question.getQuestionType().equals("numeric"));
    }

//    @Test
//    void getDateCreated() {
//        Question question = new Question();
//        java.util.Date utilDate = new java.util.Date();
//        question.setDateCreated(new java.sql.Timestamp(utilDate.getTime()));
//        assertTrue(question.getDateCreated().equals(new java.sql.Timestamp(utilDate.getTime())));
//    }
//
//    @Test
//    void setDateCreated() {
//        Question question = new Question();
//        java.util.Date utilDate = new java.util.Date();
//        question.setDateCreated(new java.sql.Timestamp(utilDate.getTime()));
//        assertTrue(question.getDateCreated().equals(new java.sql.Timestamp(utilDate.getTime())));
//    }
}