package CSCI5308.GroupFormationTool.ComputeSurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SurveyFormulaController {
	
	SurveyScale surveyScale=new SurveyScale();
	@RequestMapping("/computeformula")
    public String computeformula(SurveyScale surveyscaleobj, Model model) {
        surveyScale=surveyscaleobj;
        return "null";
        
    }

}
