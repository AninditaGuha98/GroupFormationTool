package CSCI5308.GroupFormationTool.QuestionManager.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.*;
import org.junit.jupiter.api.Test;

public class QuestionDBMock {
	IQuestionsPersistence questionDBMock = mock(QuestionDB.class);
	IQuestionFactory questionFactory;
	QuestionModel questionModel;
	IResponseFactory responseFactory;
	Responses responses;
	HashMap<String, String> hashMapObj = new HashMap<String, String>();
	List<QuestionModel> questions = new ArrayList<>();
	String[] selectedQuestions = {"Rate your java skills"};

	QuestionDBMock() {
		questionFactory = QuestionModelBuilder.FactorySingleton();
		questionFactory.setUserID((long) 1);
		questionFactory.setQuestionTitle("General");
		questionFactory.setQuestionText("How are your leadership skills");
		questionModel = questionFactory.createQuestionModel();
		hashMapObj.put("mcq1", "Multiple Choice Question, Choose One");
		questionModel.setQuestionTypeList(hashMapObj);
		responseFactory.setResponse_txt("Beginner");
		responseFactory.setScore_txt("1");
		responses= responseFactory.createResponses();

	//	interfaceQuestionModelMock.setQuestionTitle("Credits");
		questions.add(questionModel);
	}

	@Test
	public void loadAllQuestionsByID(){
		when(questionDBMock.loadAllQuestionsByID("B999999")).thenReturn(questions);
		assertEquals(questionDBMock.loadAllQuestionsByID("B999999"),questions);
		verify(questionDBMock).loadAllQuestionsByID("B999999");
	}

	@Test
	public void createQuestionTest() {
		when(questionDBMock.createQuestion(questionModel)).thenReturn(true);
		assertTrue(questionDBMock.createQuestion(questionModel));
		verify(questionDBMock).createQuestion(questionModel);
	}

	@Test
	public void insertResponsesTest() {
		when(questionDBMock.insertResponses(responses)).thenReturn(true);
		assertTrue(questionDBMock.insertResponses(responses));
		verify(questionDBMock).insertResponses(responses);
	}

	@Test
	public void deleteQuestionsFromDB(){
		when(questionDBMock.deleteQuestionsFromDB(1,selectedQuestions)).thenReturn(true);
		assertTrue(questionDBMock.deleteQuestionsFromDB(1,selectedQuestions));
		verify(questionDBMock).deleteQuestionsFromDB(1,selectedQuestions);
	}

}
