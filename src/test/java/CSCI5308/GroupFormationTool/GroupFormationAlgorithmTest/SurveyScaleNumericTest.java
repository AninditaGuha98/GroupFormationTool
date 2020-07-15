package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.SurveyScaleNumeric;

class SurveyScaleNumericTest {

	@Test
	public void distanceTest() {
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
	
