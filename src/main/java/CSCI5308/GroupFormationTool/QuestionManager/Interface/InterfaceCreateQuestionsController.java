package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import org.springframework.web.servlet.ModelAndView;

public interface InterfaceCreateQuestionsController {
	public ModelAndView questionEditor();

	public String answerEditor(QuestionModel questionModel);

	public String preview();

	public String finish();
}
