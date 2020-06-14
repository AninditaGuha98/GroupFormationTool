package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateQuestionsController {

    @RequestMapping("/questioneditor")
    public String questionEditor() {
        return "QuestionManager/questioneditor";
    }

    @RequestMapping("/answereditor")
    public String answerEditor() {
        return "QuestionManager/answereditor";
    }

    @RequestMapping("/finish")
    public String finish() {
        return "QuestionManager/finish";
    }

}
