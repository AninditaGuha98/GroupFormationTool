package CSCI5308.GroupFormationTool.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SurveyController {

    @RequestMapping("/surveyhome")
    public ModelAndView deleteQuestions(Model model, @RequestParam(name = "userID") long userID) {
        ModelAndView mv = new ModelAndView("Survey/surveyhome");

        return mv;
    }
}
