package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CreateQuestionsController {

    @RequestMapping("/questioneditor")
    public String questionnaireAdmin() {
        return "QuestionManager/questioneditor";
    }

}
