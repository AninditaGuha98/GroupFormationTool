package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.ISurveyResponse;
import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.ISurveyScale;
import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.SurveyScaleNumeric;

class SurveyScaleNumericTest {

	@Test
	public void distanceTest() {
		ISurveyResponse sr1 = new SurveyResponseMock2();
		ISurveyResponse sr2 = new SurveyResponseMock4();
		ISurveyScale sc = new SurveyScaleMock3();
		
		assertEquals(0.0, sc.distance(sr1, sr1, 2));
		assertEquals(0.0, sc.distance(sr2, sr2, 2));
		assertEquals(1.0, sc.distance(sr1, sr2, 2));
		assertEquals(1.0, sc.distance(sr2, sr1, 2));
	}
	
	@Test
	void converValueTest() {
		assertEquals(1, SurveyScaleNumeric.convertValue("1"));
		assertEquals(4, SurveyScaleNumeric.convertValue("4"));
		assertEquals(0, SurveyScaleNumeric.convertValue("String"));
		assertEquals(0, SurveyScaleNumeric.convertValue("0"));
	}
	
	@Test
	void distanceSimilarTest() {
		assertEquals(0, SurveyScaleNumeric.distanceSimilar(0, 0));
		assertEquals(0, SurveyScaleNumeric.distanceSimilar(4, 4));
		assertEquals(1, SurveyScaleNumeric.distanceSimilar(4, 5));
		assertEquals(1, SurveyScaleNumeric.distanceSimilar(5, 4));
		assertEquals(4, SurveyScaleNumeric.distanceSimilar(8, 4));
	}
	
}
	
