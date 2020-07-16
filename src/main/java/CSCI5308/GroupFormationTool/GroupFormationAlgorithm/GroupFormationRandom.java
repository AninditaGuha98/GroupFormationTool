package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupFormationRandom implements IGroupFormationAlgorithm {

	@Override
	public List<IGroup> formGroup(List<ISurveyResponse> surveyResults, 
			List<ISurveyScale> surveyScales, int groupSize) {
		List<ISurveyResponse> newStudentList;
		List<IGroup> groups = new ArrayList<IGroup>();
		int numberOfGroups = (int) Math.ceil((double) surveyResults.size()/ (double) groupSize);

		if (groupSize == 0 ) {
			return groups;
		}
		
		newStudentList = new ArrayList<ISurveyResponse>();
		for (int i = 0; i < surveyResults.size(); i++) {
			newStudentList.add(surveyResults.get(i));
		}
		
		for (int i = 0; i < numberOfGroups; i++) {
			IGroup group = new Group();
			group.setGroupNumber(i+1);
			group.setGropuSize(groupSize);
			groups.add(group);
		}
		
    	Random randGen = new Random();
    	for (int i = 0; i < numberOfGroups; i++) {
			for (int j = 0; j < groupSize; j++) {
				if (newStudentList.size() > 0) {
					int randNumber = randGen.nextInt(newStudentList.size());
					ISurveyResponse student = newStudentList.get(randNumber);
					groups.get(i).addGroupMember(student);
					newStudentList.remove(randNumber);
				}
			}
		}
		return groups;
	}

}
