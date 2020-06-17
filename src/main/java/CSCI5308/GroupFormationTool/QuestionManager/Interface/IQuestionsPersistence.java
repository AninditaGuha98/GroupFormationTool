package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import CSCI5308.GroupFormationTool.QuestionManager.Model.Question;

import java.util.List;

public interface IQuestionsPersistence {
    public List<Question> loadAllQuestionsByID(String bannerID);
}
