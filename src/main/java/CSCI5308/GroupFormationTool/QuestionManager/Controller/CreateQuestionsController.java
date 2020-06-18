package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Responses;

@Controller
public class CreateQuestionsController {

	QuestionModel questionModel = new QuestionModel();
	private long userID;

	@RequestMapping("/questioneditor")
	public ModelAndView questionEditor(Model model, @RequestParam(name = "userID") long userID) {
		ModelAndView mv = new ModelAndView();
		QuestionModel questionModel = new QuestionModel();
		mv.addObject("questionModel", questionModel);
		this.userID = userID;
		mv.setViewName("QuestionManager/questioneditor");
		return mv;
	}

	@RequestMapping("/answereditor")
	public String answerEditor(QuestionModel questionModel, Model model) {
		this.questionModel = questionModel;
		this.questionModel.setUserID(this.userID);
		if (questionModel.getTypeSelect().equals("mcq1") || questionModel.getTypeSelect().equals("mcq2")) {
			model.addAttribute("question_type", true);
		}
		return "QuestionManager/answereditor";
	}

	@RequestMapping("/finish")
	public String finish(Responses response, Model model) {
		IQuestionsPersistence questionDB = SystemConfig.instance().getQuestionDB();
		questionModel.createQuestion(questionDB);
		if (response.getResponse_txt() != null && response.getScore_txt() != null) {
			response.insertResponses(questionDB);
		}
		model.addAttribute("userID", this.userID);
		return "QuestionManager/finish";
	}
}
