package CSCI5308.GroupFormationTool.Survey;

import CSCI5308.GroupFormationTool.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SurveyController {

    private ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel = SystemConfig.instance().getiCreateSurveyQuestionsModel();
    private IQueryQuestionsRepo iQueryQuestionsRepo = SystemConfig.instance().getQueryQuestionsRepo();
    private IUpdateQuestionsListService iUpdateQuestionsListService= new UpdateQuestionsListService();

    @RequestMapping("/surveyhome")
    public ModelAndView surveyHome(Model model, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID) {
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        iCreateSurveyQuestionsModel = iQueryQuestionsRepo.listQuestionsForUser(userID);
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        mv.addObject("questionsList",iCreateSurveyQuestionsModel.getQuestionHeading());
        mv.addObject("typeList",iCreateSurveyQuestionsModel.getQuestionType());
        mv.addObject("flag", false);
        return mv;
    }


    @RequestMapping("/addQuestions")
    public ModelAndView addQuestions(Model model, @RequestParam(name="selectedQue") String que, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        iCreateSurveyQuestionsModel= iUpdateQuestionsListService.displayUpdatedQuestionList(iCreateSurveyQuestionsModel.getQuestionHeading(),iCreateSurveyQuestionsModel.getQuestionType(),que);
        mv.addObject("flag", true);
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        mv.addObject("questionsList", iCreateSurveyQuestionsModel.getQuestionHeading());
        mv.addObject("typeList", iCreateSurveyQuestionsModel.getQuestionType());
        mv.addObject("selectedQuestions",iCreateSurveyQuestionsModel.getSelectedQuestions());
        mv.addObject("selectedType", iCreateSurveyQuestionsModel.getSelectedTypes());
        return mv;
    }



}
