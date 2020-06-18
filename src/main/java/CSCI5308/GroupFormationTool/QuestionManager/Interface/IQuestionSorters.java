package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import CSCI5308.GroupFormationTool.QuestionManager.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Sorters;

import java.util.List;

public interface IQuestionSorters {
	public List<Question> sort(String bannerID, Sorters sorters);

	public List<Question> clearSort(String bannerID);
}
