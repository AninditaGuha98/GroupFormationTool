package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyFormulaController {

	ISurveyScale surveyScale = SurveyScaleObjectFactory.createObject(new SurveyScaleFactory());

	@RequestMapping("/computeformula")
	public String computeformula(SurveyScale surveyscaleobj, Model model, @RequestParam(name = "id") long courseID,@RequestParam(name = "size") int size) {
		List<ISurveyScale> surveyScales;
		surveyScale = surveyscaleobj;
		int groupsize=size;
		List<ISurveyResponse> surveyResponses=GroupFormationDBFactory.FactorySingleton().createGroupFormationDB().loadResponses(courseID);
		surveyScales = surveyScale.convertor();
		//algorithm
		GroupFormationRandom groupObj=new GroupFormationRandom();
		List <IGroup> groupresults=groupObj.formGroup(surveyResponses, surveyScales, groupsize);
		//
		model.addAttribute("groupresult", groupresults);
		return "QuestionManager/groupresults";

	}

}
