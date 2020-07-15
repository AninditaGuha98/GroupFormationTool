package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.Arrays;
import java.util.List;

public class SurveyScaleText extends SurveyScale {

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
					break;
				case "dissimilar":
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
		return rpValue;
	}
}
