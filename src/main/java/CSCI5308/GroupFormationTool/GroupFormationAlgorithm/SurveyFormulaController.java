package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SurveyFormulaController {

	ISurveyScale surveyScale = SurveyScaleObjectFactory.createObject(new SurveyScaleFactory());

	@RequestMapping("/computeformula")
	public String computeformula(SurveyScale surveyscaleobj, Model model) {
		surveyScale = surveyscaleobj;
		ISurveyScale tempObj;
		String criteria[] = surveyScale.getCriteria().split(",");
		String questionType[] = surveyScale.getQuestiontype().split(",");
		String questionText[] = surveyScale.getQuestiontext().split(",");
		List<ISurveyScale> questionCriteria = new ArrayList<ISurveyScale>();
		for (int i = 0; i < questionType.length; i++) {
			tempObj = SurveyScaleObjectFactory.createObject(new SurveyScaleFactory());
			tempObj.setCriteria(criteria[i]);
			tempObj.setQuestiontype(questionType[i]);
			tempObj.setQuestiontext(questionText[i]);
			questionCriteria.add(tempObj);
		}
		//algorithm
		//
		List<ISurveyResponse> surveyResponses=GroupFormationDBFactory.FactorySingleton().createGroupFormationDB().loadResponses(1);
		model.addAttribute("groupResults", surveyResponses);
		return "QuestionManager/groupresults";

	}

}
