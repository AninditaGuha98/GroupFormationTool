package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.List;
import java.util.Set;

import CSCI5308.GroupFormationTool.ComputeSurvey.AbstractSurveyScale;

public interface IGroupFormatiomAlgorithm {
	List<IGroup> formGroup(List<ISurveyResponse> surveryResults, List<AbstractSurveyScale> surveyScales,
			int groupSize); 
}
