package CSCI5308.GroupFormationTool.SurveyResponses;

import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
public class SurveyResponseController {
    ISurveyResponseDB surveyResponseDB = SystemConfig.instance().getSurveyResponseDB();
    ISurveyresult surveyresult = SystemConfig.instance().getSurveyresult();
    private static final String ID = "surveyID";
    private static final String user = "userID";

    @GetMapping("/surveyresponse/surveyresponse")
    public String surveyQuestions(Model model, @RequestParam(name = ID) long surveyID, @RequestParam(name = user) long userID){
        model.addAttribute("surveyID",surveyID);
        model.addAttribute("userID",userID);
        model.addAttribute("questions",surveyResponseDB.getSurveyQuestions(surveyID));
        model.addAttribute("responses",surveyResponseDB.getSurveyResponses());
        return "surveyresponse/surveyresponse";
    }

    @RequestMapping(value ="/surveyresponse/surveyresponse", method = RequestMethod.POST)
    public String submitSurveyResponse(Model model, HttpServletRequest httpServletRequest, HttpServletResponse res, @RequestParam(name = ID) long surveyID, @RequestParam(name = user) long userID){
        if(surveyresult.checkIfResponseSubmitted(userID)){
            model.addAttribute("message","You have already submitted your response");
        } else {
            Map m= httpServletRequest.getParameterMap();
            Set s = m.entrySet();
            boolean result = true;
            Iterator it = s.iterator();
            while(it.hasNext() && result){
                Map.Entry<String,String[]> entry = (Map.Entry<String,String[]>)it.next();
                String key = entry.getKey();
                String[] value = entry.getValue();
                if(!(key.equals("surveyID") || key.equals("userID") ||key.equals("_csrf"))){
                    Long questionID= Long.parseLong(key);
                    if(value.length>1 && result){
                        for (int i = 0; i < value.length; i++) {
                            result = surveyresult.submitSurveyResponse(userID,surveyID,questionID,value[i]);
                        }
                    }else{
                        result = surveyresult.submitSurveyResponse(userID,surveyID,questionID,value[0]);
                    }
                }
            }
            if(result){
                model.addAttribute("message","Your survey has been submitted successfully");
            }else{
                model.addAttribute("message","Error has occured. Submit response again");
            }
        }
        return "surveyresponse/responseresult";
    }
}
