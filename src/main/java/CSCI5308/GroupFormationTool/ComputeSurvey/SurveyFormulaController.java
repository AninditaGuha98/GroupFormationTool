package CSCI5308.GroupFormationTool.ComputeSurvey;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SurveyFormulaController {
	
	SurveyScale surveyScale=new SurveyScale();
	@RequestMapping("/computeformula")
    public String computeformula(SurveyScale surveyscaleobj, Model model) {
        surveyScale=surveyscaleobj;
        SurveyScale tempObj;
        String criteria[]=surveyScale.getCriteria().split(",");
        String questionType[]=surveyScale.getQuestiontype().split(",");
        String questionText[]=surveyScale.getQuestiontext().split(",");
        List <SurveyScale> questionCriteria=new ArrayList<SurveyScale>();
        for(int i=0;i<questionType.length;i++) {
        	tempObj=new SurveyScale();
        	tempObj.setCriteria(criteria[i]);
        	tempObj.setQuestiontype(questionType[i]);
        	tempObj.setQuestiontext(questionText[i]);
        	questionCriteria.add(tempObj);
        }        
        return "null";
        
    }

}
