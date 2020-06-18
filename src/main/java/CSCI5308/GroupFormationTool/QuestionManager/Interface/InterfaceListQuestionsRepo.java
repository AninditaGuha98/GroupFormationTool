package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import CSCI5308.GroupFormationTool.QuestionManager.Model.DeleteQuestionsModel;

public interface InterfaceListQuestionsRepo {
	 DeleteQuestionsModel listQuestionsFromDB(long userId);
}
