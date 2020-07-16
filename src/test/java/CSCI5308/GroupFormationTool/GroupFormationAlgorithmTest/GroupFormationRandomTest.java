package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.GroupFormationRandom;
import CSCI5308.GroupFormationTool.GroupFormationAlgorithm.IGroupFormatiomAlgorithm;

class GroupFormationRandomTest {

	@Test
	void formGroupTest() {
		IGroupFormationTestFactory factory = new GroupFormationTestFactory();
		IGroupFormatiomAlgorithm algo = new GroupFormationRandom();
		
		algo.formGroup(factory.createSurveyResponsesMock(), factory.createSurveyScalsesMock(), 3);
	}
}
