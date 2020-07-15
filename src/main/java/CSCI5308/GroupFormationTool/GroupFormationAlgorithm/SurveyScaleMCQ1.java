package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

public class SurveyScaleMCQ1 extends SurveyScale {

	@Override
	public double distance(ISurveyResponse rp1, ISurveyResponse rp2, int index) {
//		int rpValue1 = convertValue(rp1.getResponse(index));
//		int rpValue2 = convertValue(rp2.getResponse(index));
//		double distance = 0;
//		
//		if (this.getCriteria().equalsIgnoreCase("similar")) {
//			distance = (double) distanceSimilar(rpValue1, rpValue2);
//		} else {
//			distance = (double) distanceDissimilar(rpValue1, rpValue2);
//		}
//		
//		return distance;
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
		return (1 << (rpValue-1));
	}

	public static int distanceSimilar(int val1, int val2) {
		int distance = 0;
		int bitVal1 = val1;
		int bitVal2 = val2;
		
		int xOr = bitVal1 ^ bitVal2;
		if (xOr == 0) {
			distance = 0;
		} else if (xOr != 0) {
			distance = 1;
		}
		return distance;
	}
	
	public static int distanceDissimilar(int val1, int val2) {
		int distance = 0;
		int bitVal1 = val1;
		int bitVal2 = val2;
		
		int xOr = bitVal1 ^ bitVal2;
		if (xOr == 0) {
			distance = 1;
		} else if (xOr != 0) {
			distance = 0;
		}
		return distance;
	}
}
