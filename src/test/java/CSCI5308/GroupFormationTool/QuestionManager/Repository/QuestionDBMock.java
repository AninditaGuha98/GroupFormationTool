package CSCI5308.GroupFormationTool.QuestionManager.Repository;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashMap;
import org.junit.jupiter.api.Test;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Responses;

public class QuestionDBMock {
	IQuestionsPersistence questionDBMock = mock(QuestionDB.class);
	QuestionModel questionModelMock;
	Responses responseMock;
	HashMap<String, String> hashMapObj = new HashMap<String, String>();

	QuestionDBMock() {
		questionModelMock = new QuestionModel();
		questionModelMock.setUserID((long) 1);
		questionModelMock.setQuestionTitle("General");
		questionModelMock.setQuestionText("How are your leadership skills");
		hashMapObj.put("mcq1", "Multiple Choice Question, Choose One");
		questionModelMock.setQuestionTypeList(hashMapObj);
		responseMock = new Responses();
		responseMock.setResponse_txt("Beginner");
		responseMock.setScore_txt("1");
	}

	@Test
	public void createQuestionTest() {
		when(questionDBMock.createQuestion(questionModelMock)).thenReturn(true);
		assertTrue(questionDBMock.createQuestion(questionModelMock));
		verify(questionDBMock).createQuestion(questionModelMock);
	}

	@Test
	public void insertResponsesTest() {
		when(questionDBMock.insertResponses(responseMock)).thenReturn(true);
		assertTrue(questionDBMock.insertResponses(responseMock));
		verify(questionDBMock).insertResponses(responseMock);
	}

}
