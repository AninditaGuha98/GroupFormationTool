package CSCI5308.GroupFormationTool.GroupForma	tionAlgorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GroupFormationRandom implements IGroupFormatiomAlgorithm {

	@Override
	public List<IGroup> formGroup(List<ISurveyResponse> surveryResults, 
			List<ISurveyScale> surveyScales, int groupSize) {
		List<IGroup> groups;
		List<ISurveyResponse> newStudentList;
		int numberOfGroups = (int) Math.ceil((double) surveryResults.size()/ (double) groupSize);
		
		newStudentList = new ArrayList<ISurveyResponse>();
		for (int i = 0; i < surveryResults.size(); i++) {
			newStudentList.add(surveryResults.get(i));
		}
		
		groups = new ArrayList<IGroup>();
		for (int i = 0; i < numberOfGroups; i++) {
			IGroup group = new Group();
			group.setGroupNumber(i);
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
