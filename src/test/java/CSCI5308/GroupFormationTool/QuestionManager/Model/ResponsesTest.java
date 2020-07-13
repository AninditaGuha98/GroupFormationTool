package CSCI5308.GroupFormationTool.QuestionManager.Model;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class ResponsesTest {
    @Mock
    IResponseFactory responseFactory = ResponseBuilder.FactorySingleton();
    Responses responses;

    @Test
    void getResponse_txt() {
        responseFactory.setResponse_txt("JAVA,PyTHON,JS,C,C++");
        responses = responseFactory.createResponses();
        assertTrue(responses.getResponse_txt().equals("JAVA,PyTHON,JS,C,C++"));
    }

    @Test
    void setResponse_txt() {
        responseFactory.setResponse_txt("JAVA,PyTHON,JS,C,C++");
        responses = responseFactory.createResponses();
        assertTrue(responses.getResponse_txt().equals("JAVA,PyTHON,JS,C,C++"));
    }

    @Test
    void getScore_txt() {
        responseFactory.setScore_txt("1,2,3,4");
        responses = responseFactory.createResponses();
        assertTrue(responses.getScore_txt().equals("1,2,3,4"));
    }

    @Test
    void setScore_txt() {
        responseFactory.setScore_txt("1,2,3,4");
        responses = responseFactory.createResponses();
        assertTrue(responses.getScore_txt().equals("1,2,3,4"));
    }
}