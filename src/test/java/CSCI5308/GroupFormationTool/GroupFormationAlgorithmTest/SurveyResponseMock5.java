package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import java.util.Arrays;
import java.util.List;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.SurveyResponse;

public class SurveyResponseMock5 extends SurveyResponse {

	public SurveyResponseMock5() {
		super();

		List<String> responses = Arrays.asList("2","1,2,3,4","8","");
		super.setBannerID("B05");
		super.setFirstName("Elvis");
		super.setLastName("Presely");
		super.setResponses(responses);
	}
}
