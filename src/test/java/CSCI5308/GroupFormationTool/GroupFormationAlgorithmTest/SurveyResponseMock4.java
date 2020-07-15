package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import java.util.Arrays;
import java.util.List;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.SurveyResponse;

public class SurveyResponseMock4 extends SurveyResponse {

	public SurveyResponseMock4() {
		super();

		List<String> responses = Arrays.asList("2","1,4","4","");
		super.setBannerID("B04");
		super.setFirstName("Elton");
		super.setLastName("John");
		super.setResponses(responses);
	}
}
