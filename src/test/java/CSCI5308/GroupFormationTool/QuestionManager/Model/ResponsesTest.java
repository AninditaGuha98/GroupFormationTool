package CSCI5308.GroupFormationTool.QuestionManager.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResponsesTest {

    @Test
    void getResponse_txt() {
        Responses responses = new Responses();
        responses.setResponse_txt("JAVA,PyTHON,JS,C,C++");
        assertTrue(responses.getResponse_txt().equals("JAVA,PyTHON,JS,C,C++"));
    }

    @Test
    void setResponse_txt() {
        Responses responses = new Responses();
        responses.setResponse_txt("JAVA,PyTHON,JS,C,C++");
        assertTrue(responses.getResponse_txt().equals("JAVA,PyTHON,JS,C,C++"));
    }

    @Test
    void getScore_txt() {
        Responses responses = new Responses();
        responses.setScore_txt("1,2,3,4");
        assertTrue(responses.getScore_txt().equals("1,2,3,4"));
    }

    @Test
    void setScore_txt() {
        Responses responses = new Responses();
        responses.setScore_txt("1,2,3,4");
        assertTrue(responses.getScore_txt().equals("1,2,3,4"));
    }
}