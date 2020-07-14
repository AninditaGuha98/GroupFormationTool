package CSCI5308.GroupFormationTool.MyGroupFormation;

import java.util.List;
import java.util.Set;

public interface IGroupFormatiomAlgorithm {
	List<IGroup> formGroup(List<ISurveyResponse> surveryResults, List<ISurveyScale> surveyScales); 
}
