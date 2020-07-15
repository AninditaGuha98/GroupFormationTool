package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import java.util.Arrays;
import java.util.List;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.SurveyResponse;

public class SurveyResponseMock1 extends SurveyResponse {

	public SurveyResponseMock1() {
		super();

		List<String> responses = Arrays.asList("1","1,4","7","Frank Sinatra");
		super.setBannerID("B01");
		super.setFirstName("Johnny");
		super.setLastName("Cash");
		super.setResponses(responses);
	}
}
