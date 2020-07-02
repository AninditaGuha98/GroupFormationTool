package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import org.springframework.web.servlet.ModelAndView;

public interface InterfaceCreateQuestionsController {
	public ModelAndView questionEditor();

	public String answerEditor(InterfaceQuestionModel interfaceQuestionModel);

	public String preview();

	public String finish();
}
