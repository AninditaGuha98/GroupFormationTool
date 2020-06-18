package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import java.util.List;

import CSCI5308.GroupFormationTool.QuestionManager.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Sorters;

public interface IQuestionSorters {
	public List<Question> sort(String bannerID, Sorters sorters);

	public List<Question> clearSort(String bannerID);
}
