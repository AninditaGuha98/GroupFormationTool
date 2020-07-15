package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import java.util.List;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.ISurveyResponse;
import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.ISurveyScale;

public interface IGroupFormationTestFactory {
	public List<ISurveyResponse> createSurveyResponses();
	public List<ISurveyScale>	createSurveyScalses();
	public int	createGroupSize();
}
