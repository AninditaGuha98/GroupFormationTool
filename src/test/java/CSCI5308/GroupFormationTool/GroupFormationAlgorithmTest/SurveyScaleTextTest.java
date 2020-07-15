package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.ISurveyResponse;
import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.ISurveyScale;
import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.SurveyScaleText;

class SurveyScaleTextTest {

	@Test
	public void distanceTest() {
		ISurveyResponse sr1 = new SurveyResponseMock2();
		ISurveyResponse sr2 = new SurveyResponseMock4();
		ISurveyScale sc = new SurveyScaleMock4();
		
		assertEquals(0.0, sc.distance(sr1, sr1, 3));
		assertEquals(0.0, sc.distance(sr2, sr2, 3));
		assertEquals(0.0, sc.distance(sr1, sr2, 3));
		assertEquals(0.0, sc.distance(sr2, sr1, 3));
	}
}
	
