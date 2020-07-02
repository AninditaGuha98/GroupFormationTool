package CSCI5308.GroupFormationTool.QuestionManager.Model;


import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceQuestionModel;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class QuestionModelTest {
    @Test
    void getTypeSelect() {
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setTypeSelect("1");
        assertSame("1", interfaceQuestionModel.getTypeSelect());
    }

    @Test
    void setTypeSelect() {
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setTypeSelect("1");
        assertSame("1", interfaceQuestionModel.getTypeSelect());
    }

    @Test
    void getQuestionTypeList() {
        HashMap<String,String> mock= new HashMap<>();
        mock.put("numeric","Numeric");
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setQuestionTypeList(mock);
        assertSame(mock, interfaceQuestionModel.getQuestionTypeList());
    }

    @Test
    void setQuestionTypeList() {
        HashMap<String,String> mock= new HashMap<>();
        mock.put("numeric","Numeric");
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setQuestionTypeList(mock);
        assertSame(mock, interfaceQuestionModel.getQuestionTypeList());
    }



    @Test
    void getQuestionTitle() {
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setQuestionTitle("Course Credits");
        assertSame("Course Credits", interfaceQuestionModel.getQuestionTitle());
    }

    @Test
    void setQuestionTitle() {
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setQuestionTitle("Course Credits");
        assertSame("Course Credits", interfaceQuestionModel.getQuestionTitle());
    }

    @Test
    void getQuestionText() {
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setQuestionText("How many credit hours is the course?");
        assertSame("How many credit hours is the course?", interfaceQuestionModel.getQuestionText());
    }

    @Test
    void setQuestionText() {
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setQuestionText("How many credit hours is the course?");
        assertSame("How many credit hours is the course?", interfaceQuestionModel.getQuestionText());
    }

    @Test
    void getResponseText() {
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setResponseText("responsetext");
        assertSame("responsetext", interfaceQuestionModel.getResponseText());
    }

    @Test
    void setResponseText() {
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setResponseText("responsetext");
        assertSame("responsetext", interfaceQuestionModel.getResponseText());
    }

    @Test
    void getResponseScore() {
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setResponseScore(3);
        assertSame(3, interfaceQuestionModel.getResponseScore());
    }

    @Test
    void setResponseScore() {
        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
        interfaceQuestionModel.setResponseScore(3);
        assertSame(3, interfaceQuestionModel.getResponseScore());
    }
}