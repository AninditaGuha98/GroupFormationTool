package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;

public interface InterfaceCreateQuestionsController {
	public ModelAndView questionEditor();

	public String answerEditor(QuestionModel questionModel);

	public String preview();

	public String finish();
}
