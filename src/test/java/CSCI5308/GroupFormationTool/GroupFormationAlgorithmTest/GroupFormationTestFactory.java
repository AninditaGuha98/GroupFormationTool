package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.ISurveyResponse;
import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.ISurveyScale;

public class GroupFormationTestFactory implements IGroupFormationTestFactory {

	@Override
	public List<ISurveyResponse> createSurveyResponses() {
		List<ISurveyResponse> responses = new ArrayList<ISurveyResponse>();
		responses.add(new SurveyResponseMock1());
		responses.add(new SurveyResponseMock2());
		responses.add(new SurveyResponseMock3());
		responses.add(new SurveyResponseMock4());
		responses.add(new SurveyResponseMock5());
		return responses;
	}

	@Override
	public List<ISurveyScale> createSurveyScalses() {
		List<ISurveyScale> surveyScales = new ArrayList<ISurveyScale>();
		surveyScales.add(new SurveyScaleMock1());
		surveyScales.add(new SurveyScaleMock2());
		surveyScales.add(new SurveyScaleMock3());
		surveyScales.add(new SurveyScaleMock4());
		return surveyScales;
	}

	@Override
	public int createGroupSize() {
		return 2;
	}

}
