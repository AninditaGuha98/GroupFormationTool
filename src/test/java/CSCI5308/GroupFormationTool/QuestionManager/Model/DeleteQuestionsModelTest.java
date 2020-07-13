package CSCI5308.GroupFormationTool.QuestionManager.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeleteQuestionsModelTest {
    IDeleteFactory deleteFactory = DeleteQuestionsBuilder.FactorySingleton();
    DeleteQuestionsModel deleteQuestionsModel;

    @Test
    void getListQuestions() {
        String[] questions={"test"};
        deleteFactory.setListQuestions(questions);
        deleteQuestionsModel = deleteFactory.createDeleteModel();
        assertEquals(questions,deleteQuestionsModel.getListQuestions());
    }

    @Test
    void setListQuestions() {
        String[] questions={"test"};
        deleteFactory.setListQuestions(questions);
        deleteQuestionsModel = deleteFactory.createDeleteModel();
        assertEquals(questions,deleteQuestionsModel.getListQuestions());
    }

    @Test
    void getSelectedQuestions() {
        String[] questions={"question1"};
        deleteFactory.setSelectedQuestions(questions);
        deleteQuestionsModel = deleteFactory.createDeleteModel();
        assertSame(questions,deleteQuestionsModel.getSelectedQuestions());
    }

    @Test
    void setSelectedQuestions() {
        String[] questions={"question1"};
        deleteFactory.setSelectedQuestions(questions);
        deleteQuestionsModel = deleteFactory.createDeleteModel();
        assertSame(questions,deleteQuestionsModel.getSelectedQuestions());
    }
}