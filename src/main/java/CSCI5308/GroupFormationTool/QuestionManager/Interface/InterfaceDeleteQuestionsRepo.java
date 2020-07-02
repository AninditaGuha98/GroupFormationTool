package CSCI5308.GroupFormationTool.QuestionManager.Interface;

public interface InterfaceDeleteQuestionsRepo {

    boolean checkIfResponsesExistInDB(long userId, String[] selectedQuestions);

}
