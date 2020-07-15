package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import java.util.Arrays;
import java.util.List;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.SurveyResponse;

public class SurveyResponseMock3 extends SurveyResponse {

	public SurveyResponseMock3() {
		super();

		List<String> responses = Arrays.asList("1","2,3","6","");
		super.setBannerID("B03");
		super.setFirstName("Frank");
		super.setLastName("Sinatra");
		super.setResponses(responses);
	}
}
