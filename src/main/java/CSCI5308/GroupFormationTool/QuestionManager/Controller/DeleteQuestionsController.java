package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceDeleteQuestionsRepo;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.InterfaceListQuestionsRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.QuestionManager.Model.DeleteQuestionsModel;

@Controller
public class DeleteQuestionsController {
	InterfaceDeleteQuestionsRepo deleteQuestionsRepo = SystemConfig.instance().getDeleteQuestionsRepo();
	InterfaceListQuestionsRepo listQuestionsRepo = SystemConfig.instance().getListQuestionsRepo();
	IQuestionsPersistence questionDB = SystemConfig.instance().getQuestionDB();

	@RequestMapping("/deletequestionspage")
	public ModelAndView deleteQuestions(Model model, @RequestParam(name = "userID") long userID) {
		ModelAndView mv = new ModelAndView("QuestionManager/deletequestions");

		mv.addObject("deleteQuestions", listQuestionsRepo.listQuestionsFromDB(userID));
		mv.addObject("message", "");
		mv.addObject("flag", true);
		model.addAttribute("userID", userID);
		return mv;
	}

	@RequestMapping("/checkResponse")
	public ModelAndView checkResponseBeforeDelete(Model model, DeleteQuestionsModel deleteQuestionsModel,
			@RequestParam(name = "userID") long userID) {
		ModelAndView mv = new ModelAndView();
		model.addAttribute("userID", userID);
		mv.addObject("deleteQuestions", deleteQuestionsModel);
		mv.addObject("userID", userID);
		mv.setViewName("QuestionManager/deletequestions");
		if (deleteQuestionsRepo.checkIfResponsesExistInDB(userID,deleteQuestionsModel.getSelectedQuestions())) {
			questionDB.deleteQuestionsFromDB(userID, deleteQuestionsModel.getSelectedQuestions());
			mv.addObject("message", "Successfully deleted");
			return mv;
		}
		mv.addObject("message", "prompt");
		String StringList = "";
		for (String s : deleteQuestionsModel.getSelectedQuestions()) {
			StringList += s + ",,";
		}
		mv.addObject("selectedQue", StringList);
		mv.addObject("flag", false);
		return mv;
	}

	@RequestMapping("/deletequestions")
	public ModelAndView deleteQuestions(Model model, @RequestParam(name = "selectedQue") String selectedQue,
			@RequestParam(name = "userID") long userID) {
		String[] chosenQuestions = selectedQue.split(",,");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("QuestionManager/deletequestions");

		if (questionDB.deleteQuestionsFromDB(userID, chosenQuestions)) {
			mv.addObject("message", "Successfully deleted");
			mv.addObject("flag", false);
		} else {
			mv.addObject("message", "Could not delete");
		}
		model.addAttribute("userID", userID);
		return mv;
	}

}