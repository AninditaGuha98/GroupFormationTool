package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import CSCI5308.GroupFormationTool.QuestionManager.Model.DeleteQuestionsModel;

public interface InterfaceListQuestionsRepo {
    public DeleteQuestionsModel listQuestionsFromDB(long userId);
}
