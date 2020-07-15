package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import CSCI5308.GroupFormationTool.MyGroupFormation.ISurveyResponse;

public class SurveyScaleMCQ2 extends AbstractSurveyScale {

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
		int distance = 0;
		int bitVal1 = 1 >> val1;
		int bitVal2 = 1 >> val2;
		
		distance = countSetBits(bitVal1 ^ bitVal2);
		return distance;
	}
	
	private int distanceDissimilar(int val1, int val2) {
		int distance = 0;
		int bitVal1 = 1 >> val1;
		int bitVal2 = 1 >> val2;
		
		distance = countSetBits(~(bitVal1 ^ bitVal2));
		return distance;
	}
	
	private static int countSetBits(int n) 
    { 
	        int count = 0; 
	        while (n > 0) { 
	            count += n & 1; 
	            n >>= 1; 
	        } 
	        return count; 
	} 
}
