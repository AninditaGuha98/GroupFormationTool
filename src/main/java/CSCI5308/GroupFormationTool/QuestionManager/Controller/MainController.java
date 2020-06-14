package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/questionmanager")
    public String questionnaireAdmin() {
        return "QuestionManager/QuestionManagerPage";
    }

//    Start point controller for create questions tab
    @RequestMapping("/welcomequestions")
    public String CreateQuestions() {
        return "QuestionManager/welcome";
    }

//    Start point controller for list questions tab

}
