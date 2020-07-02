package CSCI5308.GroupFormationTool.QuestionManager.Interface;


import java.util.List;

public interface IQuestionSorters {
	public List<InterfaceQuestionModel> sort(String bannerID, InterfaceSorters interfaceSorters);

	public List<InterfaceQuestionModel> clearSort(String bannerID);
}
