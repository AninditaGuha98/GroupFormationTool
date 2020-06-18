package CSCI5308.GroupFormationTool.QuestionManager.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteQuestionsModelTest {


    @Test
    void getListQuestions() {
        String[] questions={"test"};
        DeleteQuestionsModel deleteQuestionsModel=new DeleteQuestionsModel();
        deleteQuestionsModel.setListQuestions(questions);
        assertEquals(questions,deleteQuestionsModel.getListQuestions());
    }

    @Test
    void setListQuestions() {
        String[] questions={"test"};
        DeleteQuestionsModel deleteQuestionsModel=new DeleteQuestionsModel();
        deleteQuestionsModel.setListQuestions(questions);
        assertEquals(questions,deleteQuestionsModel.getListQuestions());
    }

    @Test
    void getSelectedQuestions() {
        String[] questions={"question1"};
        DeleteQuestionsModel deleteQuestionsModel=new DeleteQuestionsModel();
        deleteQuestionsModel.setSelectedQuestions(questions);
        assertSame(questions,deleteQuestionsModel.getSelectedQuestions());
    }

    @Test
    void setSelectedQuestions() {
        String[] questions={"question1"};
        DeleteQuestionsModel deleteQuestionsModel=new DeleteQuestionsModel();
        deleteQuestionsModel.setSelectedQuestions(questions);
        assertSame(questions,deleteQuestionsModel.getSelectedQuestions());
    }
}