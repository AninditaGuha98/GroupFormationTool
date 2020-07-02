package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceQuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceResponses;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Responses;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;

@Controller
public class CreateQuestionsController {

	InterfaceQuestionModel interfaceQuestionModel = new QuestionModel();
	InterfaceResponses interfaceResponses=new Responses();
	IQuestionsPersistence questionDB = SystemConfig.instance().getQuestionDB();
	private long userID;

	@RequestMapping("/questioneditor")
	public ModelAndView questionEditor(Model model, @RequestParam(name = "userID") long userID) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("questionModel", interfaceQuestionModel);
		this.userID = userID;
		mv.setViewName("QuestionManager/questioneditor");
		return mv;
	}

	@RequestMapping("/answereditor")
	public String answerEditor(QuestionModel questionModel, Model model) {
		this.interfaceQuestionModel=questionModel;
		this.interfaceQuestionModel.setUserID(this.userID);
		if (interfaceQuestionModel.getTypeSelect().equals("mcq1") || interfaceQuestionModel.getTypeSelect().equals("mcq2")) {
			model.addAttribute("question_type", true);
		}
		return "QuestionManager/answereditor";
	}

	@RequestMapping("/finish")
	public String finish(Responses response, Model model) {
		this.interfaceResponses=response;
		interfaceQuestionModel.createQuestion(questionDB);
		if (interfaceResponses.getResponse_txt() != null && interfaceResponses.getScore_txt() != null) {
			interfaceResponses.insertResponses(questionDB);
		}
		model.addAttribute("userID", this.userID);
		return "QuestionManager/finish";
	}
}
