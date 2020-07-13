package CSCI5308.GroupFormationTool.QuestionManager.Model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class QuestionModelTest {
    @Mock
    IQuestionFactory questionFactory = QuestionModelBuilder.FactorySingleton();

    @Test
    void getTypeSelect() {
        QuestionModel questionModel= questionFactory.createQuestionModel();
        questionModel.setTypeSelect("1");
        assertSame("1", questionModel.getTypeSelect());
    }

    @Test
    void setTypeSelect() {
        QuestionModel questionModel= questionFactory.createQuestionModel();
        questionModel.setTypeSelect("1");
        assertSame("1", questionModel.getTypeSelect());
    }

    @Test
    void getQuestionTypeList() {
        HashMap<String,String> mock= new HashMap<>();
        mock.put("numeric","Numeric");
        QuestionModel questionModel= questionFactory.createQuestionModel();
        questionModel.setQuestionTypeList(mock);
        assertSame(mock, questionModel.getQuestionTypeList());
    }

    @Test
    void setQuestionTypeList() {
        HashMap<String,String> mock= new HashMap<>();
        mock.put("numeric","Numeric");
        QuestionModel questionModel= questionFactory.createQuestionModel();
        questionModel.setQuestionTypeList(mock);
        assertSame(mock, questionModel.getQuestionTypeList());
    }


    @Test
    void getQuestionTitle() {
        questionFactory.setQuestionTitle("Course Credits");
        QuestionModel questionModel= questionFactory.createQuestionModel();
        assertSame("Course Credits", questionModel.getQuestionTitle());
    }
//
//    @Test
//    void setQuestionTitle() {
//        InterfaceQuestionModel interfaceQuestionModel =new QuestionModel();
//        interfaceQuestionModel.setQuestionTitle("Course Credits");
//        assertSame("Course Credits", interfaceQuestionModel.getQuestionTitle());
//    }

    @Test
    void getQuestionText() {
        questionFactory.setQuestionText("How many credit hours is the course?");
        QuestionModel questionModel= questionFactory.createQuestionModel();
        assertSame("How many credit hours is the course?", questionModel.getQuestionText());
    }

    @Test
    void setQuestionText() {
        questionFactory.setQuestionText("How many credit hours is the course?");
        QuestionModel questionModel= questionFactory.createQuestionModel();
        assertSame("How many credit hours is the course?", questionModel.getQuestionText());
    }
}