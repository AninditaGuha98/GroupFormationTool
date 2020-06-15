package CSCI5308.GroupFormationTool.QuestionManager.Controller;

import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateQuestionsController {

    @RequestMapping("/questioneditor")
    public ModelAndView questionEditor() {
        ModelAndView mv=new ModelAndView();
        QuestionModel questionModel=new QuestionModel();
        mv.addObject("questionModel",questionModel);
        mv.setViewName("QuestionManager/questioneditor");
        return mv;
    }


    @RequestMapping("/answereditor")
    public String answerEditor(QuestionModel questionModel) {
        System.out.println(questionModel.getQuestionTitle());
        System.out.println(questionModel.getQuestionText());
        System.out.println(questionModel.getTypeSelect());
        return "QuestionManager/answereditor";
    }

    @RequestMapping("/preview")
    public String preview() {
        return "QuestionManager/preview";
    }

    @RequestMapping("/finish")
    public String finish() {
        return "QuestionManager/finish";
    }

}
