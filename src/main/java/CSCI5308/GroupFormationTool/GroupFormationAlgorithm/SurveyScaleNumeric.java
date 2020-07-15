package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;


public class SurveyScaleNumeric extends SurveyScale {

	@Override
	public double distance(ISurveyResponse rp1, ISurveyResponse rp2, int index) {
//		int rpValue1 = convertValue(rp1.getResponse(index));
//		int rpValue2 = convertValue(rp2.getResponse(index));
		
		return 0;
	}
	
	public static int convertValue(String rpString) {
		int rpValue = 0;
		
		try {
			rpValue = Integer.parseInt(rpString);
		}
		catch(NumberFormatException e) {
			// Log Error
		}
		return rpValue;
	}

	public static int distanceSimilar(int val1, int val2) {
		return Math.abs(val1-val2);
	}
}
