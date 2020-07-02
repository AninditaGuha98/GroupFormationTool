package CSCI5308.GroupFormationTool.QuestionManager.Model;

import CSCI5308.GroupFormationTool.QuestionManager.DeleteQuestionsModel;
import CSCI5308.GroupFormationTool.QuestionManager.InterfaceDeleteQuestionsModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteQuestionsModelTest {


    @Test
    void getListQuestions() {
        String[] questions={"test"};
        InterfaceDeleteQuestionsModel interfaceDeleteQuestionsModel=new DeleteQuestionsModel();
        interfaceDeleteQuestionsModel.setListQuestions(questions);
        assertEquals(questions,interfaceDeleteQuestionsModel.getListQuestions());
    }

    @Test
    void setListQuestions() {
        String[] questions={"test"};
        InterfaceDeleteQuestionsModel interfaceDeleteQuestionsModel=new DeleteQuestionsModel();
        interfaceDeleteQuestionsModel.setListQuestions(questions);
        assertEquals(questions,interfaceDeleteQuestionsModel.getListQuestions());
    }

    @Test
    void getSelectedQuestions() {
        String[] questions={"question1"};
        InterfaceDeleteQuestionsModel interfaceDeleteQuestionsModel=new DeleteQuestionsModel();
        interfaceDeleteQuestionsModel.setSelectedQuestions(questions);
        assertSame(questions,interfaceDeleteQuestionsModel.getSelectedQuestions());
    }

    @Test
    void setSelectedQuestions() {
        String[] questions={"question1"};
        InterfaceDeleteQuestionsModel interfaceDeleteQuestionsModel=new DeleteQuestionsModel();
        interfaceDeleteQuestionsModel.setSelectedQuestions(questions);
        assertSame(questions,interfaceDeleteQuestionsModel.getSelectedQuestions());
    }
}