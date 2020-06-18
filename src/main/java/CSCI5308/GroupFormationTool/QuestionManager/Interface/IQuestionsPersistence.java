package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Responses;

public interface IQuestionsPersistence {

	public List<Question> loadAllQuestionsByID(String bannerID);

	public boolean createQuestion(QuestionModel question);

	public boolean insertResponses(Responses response);
}
