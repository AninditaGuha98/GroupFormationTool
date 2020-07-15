package CSCI5308.GroupFormationTool.CreateSurvey;

import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.sql.SQLException;
import java.util.Dictionary;

@Controller
public class SurveyController {

     ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel = SystemConfig.instance().getCreateSurveyQuestionsModel();
     ICreateSurveyDB ICreateSurveyDB = SystemConfig.instance().getCreateSurveyDB();
     IUpdateQuestionsListService iUpdateQuestionsListService= new UpdateQuestionsListService();
     IListQuestionsService IlistQuestionsService=new ListQuestionsService();

    @RequestMapping("/surveyhome")
    public ModelAndView surveyHome(@RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID) throws SQLException {
        boolean surveyFlag;
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        surveyFlag= ICreateSurveyDB.fetchSavedQuestions(courseID);
        mv.addObject("courseID", courseID);
        mv.addObject("userID",userID);
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
    public ModelAndView addQuestions(@RequestParam(name="selectedQue") String que, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
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
    public ModelAndView removeQuestions(@RequestParam(name="removeQue") String que, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
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
    public ModelAndView saveSurvey(@RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
        int status=0;
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        mv.addObject("publish",true);
        mv.addObject("surveyFlag",true);
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        mv.addObject("questionsList", IlistQuestionsService.listRepeatQuestions());
        mv.addObject("selectedQuestions",iCreateSurveyQuestionsModel.getSelectedQuestions());
        mv.addObject("selectedType", iCreateSurveyQuestionsModel.getSelectedTypes());
        if(ICreateSurveyDB.saveSurvey(courseID,userID,status)){
            mv.addObject("msgFlag",0);
            mv.addObject("message","Questions have been saved successfully, you can edit later else publish it now.");
        }
        return mv;
    }

    @RequestMapping("/publish")
    public ModelAndView publishSurvey(@RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
        int status=1;
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        if(ICreateSurveyDB.saveSurvey(courseID,userID,status)){
            mv.addObject("surveyFlag",false);
            mv.addObject("surveyMessage","Questions have been published.");
        }
        return mv;
    }

    @RequestMapping("/unpublish")
    public ModelAndView unpublishSurvey (@RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        ICreateSurveyDB.updatePublishStatus(courseID);
        ICreateSurveyDB.fetchSavedQuestions(courseID);
        Dictionary hashMap= IlistQuestionsService.listAllQuestionsforUser(userID);
        mv.addObject("surveyFlag",true);
        mv.addObject("courseID", courseID);
        mv.addObject("userID",userID);
        mv.addObject("questionsList",hashMap);
        mv.addObject("selectedQuestions",iCreateSurveyQuestionsModel.getSelectedQuestions());
        mv.addObject("publish",false);
        return mv;
    }


}
