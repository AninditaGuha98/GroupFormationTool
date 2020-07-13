package CSCI5308.GroupFormationTool.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SurveyController {

    private ICreateSurveyQuestionsModel iCreateSurveyQuestionsModel =new CreateSurveyQuestionsModel();
    private IQueryQuestionsRepo iQueryQuestionsRepo = new QueryQuestionsRepo();

    @RequestMapping("/surveyhome")
    public ModelAndView surveyHome(Model model, CreateSurveyQuestionsModel createSurveyQuestionsModel, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID) {
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        iQueryQuestionsRepo.listQuestionsForUser(userID);
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        mv.addObject("questionsList",createSurveyQuestionsModel.getQuestionHeading());
        mv.addObject("typeList",createSurveyQuestionsModel.getQuestionType());
        return mv;
    }


    @RequestMapping("/addQuestions")
    public ModelAndView addQuestions(Model model, CreateSurveyQuestionsModel createSurveyQuestionsModel, @RequestParam(name="selectedQue") String que, @RequestParam(name="id") long courseID, @RequestParam(name = "userID") long userID){
//        this.iSurveyQuestionsModel=surveyQuestionsModel;
        ModelAndView mv = new ModelAndView("Survey/surveyhome");
        mv.addObject("courseID",courseID);
        mv.addObject("userID", userID);
        System.out.println("questions:"+que);
        mv.addObject("questionsList", iQueryQuestionsRepo.listQuestionsForUser(userID).getQuestionHeading());
        mv.addObject("typeList", iQueryQuestionsRepo.listQuestionsForUser(userID).getQuestionType());

        return mv;
    }



}
