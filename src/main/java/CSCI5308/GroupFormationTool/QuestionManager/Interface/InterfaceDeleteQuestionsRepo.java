package CSCI5308.GroupFormationTool.QuestionManager.Interface;

public interface InterfaceDeleteQuestionsRepo {

	public boolean checkIfResponsesExistInDB(long userId, String[] selectedQuestions);

//	public boolean deleteQuestionsFromDB(long userId, String[] selectedQuestions);
}
