package CSCI5308.GroupFormationTool.QuestionManager.Interface;


import java.util.List;

public interface IQuestionsPersistence {

	public List<InterfaceQuestionModel> loadAllQuestionsByID(String bannerID);

	public boolean createQuestion(InterfaceQuestionModel question);

	public boolean insertResponses(InterfaceResponses response);

	public boolean deleteQuestionsFromDB(long userId, String[] selectedQuestions);
}
