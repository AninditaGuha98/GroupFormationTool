package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.Dictionary;

@Controller
public class SurveyController {

     ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel = SystemConfig.instance().getCreateSurveyQuestionsModel();
     IQueryQuestionsRepo iQueryQuestionsRepo = SystemConfig.instance().getQueryQuestionsRepo();
     IUpdateQuestionsListService iUpdateQuestionsListService= new UpdateQuestionsListService();
     IListQuestionsService IlistQuestionsService=new ListQuestionsService();
     ISaveSurveyRepo ISaveSurveyRepo = SystemConfig.instance().getSaveSurveyRepo();

    @RequestMapping("/surveyhome")
    public ModelAndView surveyHome(Model model, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID) throws SQLException {
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        boolean surveyFlag;
        surveyFlag=ISaveSurveyRepo.getSavedQuestions(courseID);
        if(surveyFlag==false){
            mv.addObject("surveyFlag",false);
            mv.addObject("surveyMessage", "A Survey is already published.");
            return mv;
        }
        Dictionary hashMap= IlistQuestionsService.listAllQuestionsforUser(userID);
        mv.addObject("surveyFlag",true);
        mv.addObject("courseID", courseID);
        mv.addObject("userID",userID);
        mv.addObject("questionsList",hashMap);
        mv.addObject("selectedQuestions",iCreateSurveyQuestionsModel.getSelectedQuestions());
        mv.addObject("publish",false);
        return mv;
    }


    @RequestMapping("/addQuestions")
    public ModelAndView addQuestions(Model model, @RequestParam(name="selectedQue") String que, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        iCreateSurveyQuestionsModel= iUpdateQuestionsListService.displayUpdatedQuestionList(iCreateSurveyQuestionsModel.getQuestionHeading(),iCreateSurveyQuestionsModel.getQuestionType(),que);
        mv.addObject("publish",false);
        mv.addObject("surveyFlag",true);
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        mv.addObject("questionsList", IlistQuestionsService.listRepeatQuestions());
        mv.addObject("selectedQuestions",iCreateSurveyQuestionsModel.getSelectedQuestions());
        mv.addObject("selectedType", iCreateSurveyQuestionsModel.getSelectedTypes());
        return mv;
    }

    @RequestMapping("/removeQuestions")
    public ModelAndView removeQuestions(Model model, @RequestParam(name="removeQue") String que, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        iCreateSurveyQuestionsModel= iUpdateQuestionsListService.removeQuestions(que);
        mv.addObject("publish",false);
        mv.addObject("surveyFlag",true);
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        mv.addObject("questionsList", IlistQuestionsService.listRepeatQuestions());
        mv.addObject("selectedQuestions",iCreateSurveyQuestionsModel.getSelectedQuestions());
        mv.addObject("selectedType", iCreateSurveyQuestionsModel.getSelectedTypes());
        return mv;
    }

    @RequestMapping("/save")
    public ModelAndView saveSurvey(Model model, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        int status=0;
        mv.addObject("publish",true);
        mv.addObject("surveyFlag",true);
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        mv.addObject("questionsList", IlistQuestionsService.listRepeatQuestions());
        mv.addObject("selectedQuestions",iCreateSurveyQuestionsModel.getSelectedQuestions());
        mv.addObject("selectedType", iCreateSurveyQuestionsModel.getSelectedTypes());
        if(ISaveSurveyRepo.saveSurvey(courseID,userID,status)){
            mv.addObject("msgFlag",0);
            mv.addObject("message","Questions have been saved successfully, you can edit later else publish it now.");
        }
        return mv;
    }

    @RequestMapping("/publish")
    public ModelAndView publishSurvey(Model model, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        int status=1;
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        if(ISaveSurveyRepo.saveSurvey(courseID,userID,status)){
            mv.addObject("surveyFlag",false);
            mv.addObject("surveyMessage","Questions have been published.");
        }
        return mv;
    }
}
