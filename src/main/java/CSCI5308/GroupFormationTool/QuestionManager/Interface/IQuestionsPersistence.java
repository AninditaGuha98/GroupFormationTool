package CSCI5308.GroupFormationTool.QuestionManager.Interface;


import java.util.List;
import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Responses;

public interface IQuestionsPersistence {

	public List<QuestionModel> loadAllQuestionsByID(String bannerID);

	public boolean createQuestion(QuestionModel question);

	public boolean insertResponses(Responses response);

	public boolean deleteQuestionsFromDB(long userId, String[] selectedQuestions);
}
