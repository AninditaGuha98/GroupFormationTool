package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionSorters;
import CSCI5308.GroupFormationTool.QuestionManager.Interface.IQuestionsPersistence;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Sorters;

@Controller
public class ListQuestionsController {
	IQuestionsPersistence questionDb = SystemConfig.instance().getQuestionDB();
	IQuestionSorters sortersDB = SystemConfig.instance().getSortersDB();
	Sorters sort = new Sorters();
	Map<String, String> sortingFields = sort.sortingFieldList();
	Map<String, String> sortingOrders = sort.sortingOrderList();
	String bannerID;

	@RequestMapping(value = "/listquestions", method = RequestMethod.GET)
	public String showQuestions(ModelMap model, Principal principal) {
		setModelForSorting(model);
		bannerID = principal.getName();
		model.addAttribute("questions", questionDb.loadAllQuestionsByID(bannerID));
		return "QuestionManager/listquestions";
	}

	@RequestMapping(value = "/listquestions", method = RequestMethod.POST, params = "action=sort")
	public ModelAndView performSort(@ModelAttribute("sorters") Sorters sorters, BindingResult result, ModelMap model) {
		setModelForSorting(model);
		model.addAttribute("questions", sortersDB.sort(bannerID, sorters));
		model.addAttribute("message", "Table is sorted by " + sortingFields.get(sorters.getSortField()) + " in "
				+ sortingOrders.get(sorters.getSortOrder()) + " Order");
		return new ModelAndView("QuestionManager/listquestions", model);
	}

	@RequestMapping(value = "/listquestions", method = RequestMethod.POST, params = "action=clearSort")
	public ModelAndView performClearSort(@ModelAttribute("sorters") Sorters sorters, BindingResult result,
			ModelMap model) {
		setModelForSorting(model);
		model.addAttribute("questions", sortersDB.clearSort(bannerID));
		return new ModelAndView("QuestionManager/listquestions", model);
	}

	public void setModelForSorting(ModelMap model) {
		model.addAttribute("sorters", sort);
		model.addAttribute("sortingFields", sortingFields);
		model.addAttribute("sortingOrders", sortingOrders);
	}
}
