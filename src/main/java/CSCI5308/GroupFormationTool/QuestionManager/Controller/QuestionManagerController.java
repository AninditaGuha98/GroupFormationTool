package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionManagerController {


    @RequestMapping("/questionmanager")
    public String questionnaireAdmin() {
        return "course/questionadmin";
    }
}
