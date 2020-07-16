package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import java.util.Arrays;
import java.util.List;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.SurveyResponse;

public class SurveyResponseMock2 extends SurveyResponse {

	public SurveyResponseMock2() {
		super();

		List<String> responses = Arrays.asList("1","1,2","5","");
		super.setBannerID("B02");
		super.setFirstName("Paul");
		super.setLastName("McCartney");
		super.setResponses(responses);
	}
}
