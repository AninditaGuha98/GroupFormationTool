package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.Arrays;
import java.util.List;

public class SurveyScaleMCQ1 extends SurveyScale {

	@Override
	public double distance(ISurveyResponse rp1, ISurveyResponse rp2, int index) {
		int rpValue1 = convertValue(rp1.getResponses().get(index));
		int rpValue2 = convertValue(rp2.getResponses().get(index));
		double distance = 0;
		List<String> criteria;
		
		criteria = Arrays.asList(this.getCriteria().toLowerCase().split(","));
		for(String criterion: criteria) {
			switch(criterion) {
				case "similar":
					distance += (double) distanceSimilar(rpValue1, rpValue2);
					break;
				case "dissimilar":
					distance += (double) distanceDissimilar(rpValue1, rpValue2);
					break;
				case "grtx":
					break;
				case "lessx":
					break;
				default:
			}
		}
		
		return distance;
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
