package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.List;

public interface IGroupFormatiomAlgorithm {
	List<IGroup> formGroup(List<ISurveyResponse> surveryResults, List<ISurveyScale> surveyScales, int groupSize);
}
