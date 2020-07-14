package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Dictionary;
import java.util.HashMap;

@Controller
public class SurveyController {

    private ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel = SystemConfig.instance().getCreateSurveyQuestionsModel();
    private IQueryQuestionsRepo iQueryQuestionsRepo = SystemConfig.instance().getQueryQuestionsRepo();
    private IUpdateQuestionsListService iUpdateQuestionsListService= new UpdateQuestionsListService();
    private IListQuestionsService IlistQuestionsService=new ListQuestionsService();
    private SaveSurveyRepo saveSurveyRepo=new SaveSurveyRepo();

    @RequestMapping("/surveyhome")
    public ModelAndView surveyHome(Model model, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID) {
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        Dictionary hashMap= IlistQuestionsService.listAllQuestionsforUser(userID);
        mv.addObject("courseID",courseID);
        mv.addObject("userID",userID);
        mv.addObject("questionsList",hashMap);
        mv.addObject("flag", false);
        mv.addObject("publish",false);
        return mv;
    }


    @RequestMapping("/addQuestions")
    public ModelAndView addQuestions(Model model, @RequestParam(name="selectedQue") String que, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        iCreateSurveyQuestionsModel= iUpdateQuestionsListService.displayUpdatedQuestionList(iCreateSurveyQuestionsModel.getQuestionHeading(),iCreateSurveyQuestionsModel.getQuestionType(),que);
        mv.addObject("flag", true);
        mv.addObject("publish",false);
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
        mv.addObject("flag", true);
        mv.addObject("publish",false);
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
        mv.addObject("flag", true);
        mv.addObject("publish",true);
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        mv.addObject("questionsList", IlistQuestionsService.listRepeatQuestions());
        mv.addObject("selectedQuestions",iCreateSurveyQuestionsModel.getSelectedQuestions());
        mv.addObject("selectedType", iCreateSurveyQuestionsModel.getSelectedTypes());
//        if(saveSurveyRepo.saveSurvey(courseID,status)){
//            mv.addObject("msgFlag",0);
//            mv.addObject("message","Questions have been saved successfuly, you can edit later.");
//        }
        return mv;
    }
}
