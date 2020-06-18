package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/questionmanager")
	public String questionnaireAdmin(Model model, @RequestParam(name = "userID") long userID) {
		model.addAttribute("userID", userID);
		return "QuestionManager/QuestionManagerPage";
	}

//    Start point controller for create questions tab
	@RequestMapping("/welcomequestions")
	public String CreateQuestions(Model model, @RequestParam(name = "userID") long userID) {
		model.addAttribute("userID", userID);
		return "QuestionManager/welcome";
	}

//    Start point controller for list questions tab
	@RequestMapping("/listquestions")
	public String ListQuestions(Model model, @RequestParam(name = "userID") long userID) {
		model.addAttribute("userID",userID);
		return "QuestionManager/listquestions";
	}
}
