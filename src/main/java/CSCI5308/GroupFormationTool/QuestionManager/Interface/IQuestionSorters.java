package CSCI5308.GroupFormationTool.QuestionManager.Interface;

import CSCI5308.GroupFormationTool.QuestionManager.Model.QuestionModel;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Sorters;

import java.util.List;

public interface IQuestionSorters {
	public List<QuestionModel> sort(String bannerID, Sorters sorters);

	public List<QuestionModel> clearSort(String bannerID);
}
