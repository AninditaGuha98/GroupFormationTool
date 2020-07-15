package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import CSCI5308.GroupFormationTool.MyGroupFormation.ISurveyResponse;

public class SurveyScaleNumeric extends AbstractSurveyScale {

	@Override
	public double distance(ISurveyResponse rp1, ISurveyResponse rp2, int index) {
		int rpValue1 = convertValue(rp1.getResponse(index));
		int rpValue2 = convertValue(rp2.getResponse(index));
		
		return 0;
	}
	
	private static int convertValue(String rpString) {
		return 0;
	}

	private int distanceSimilar(int val1, int val2) {
		return 0;
	}
}
