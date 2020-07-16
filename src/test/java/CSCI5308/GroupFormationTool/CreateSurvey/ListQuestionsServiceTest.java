package CSCI5308.GroupFormationTool.CreateSurvey;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ListQuestionsServiceTest {

    @Mock
    IQueryQuestionsRepo iQueryQuestionsRepo;

    @InjectMocks
    IListQuestionsService iListQuestionsService;

    @BeforeEach
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void listAllQuestionsforUser(long userID) {
//        userID=2;
//        String [] questionHeadings={"question1", "question2"};
//        String [] questionTypes={"question1", "question2"};
//        ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel = null;
//        iCreateSurveyQuestionsModel.setQuestionHeading(questionHeadings);
//        iCreateSurveyQuestionsModel.setQuestionType(questionTypes);
//        iCreateSurveyQuestionsModel=iQueryQuestionsRepo.listQuestionsForUser(userID);
//        when(iQueryQuestionsRepo.listQuestionsForUser(userID).thenReturn(questionHeadings));
//        iListQuestionsService.listAllQuestionsforUser(userID);
//        assertEquals(questionHeadings,)
    }

    @Test
    void listRepeatQuestions() {
    }
}