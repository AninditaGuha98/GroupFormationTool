package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import CSCI5308.GroupFormationTool.SystemConfig;

public class GroupFormationMinDistance implements IGroupFormationAlgorithm {

	private PriorityQueue<DistanceNode> pq;
	private Map<ISurveyResponse, IGroup> groupAssociation;

	public GroupFormationMinDistance() {
		pq = new PriorityQueue<GroupFormationMinDistance.DistanceNode>();
		groupAssociation = new HashMap<ISurveyResponse, IGroup>();
	}
	
	private class DistanceNode implements Comparable<DistanceNode> {
		ISurveyResponse student1;
		ISurveyResponse student2;
		Double distance;
		
		public DistanceNode(ISurveyResponse node1, ISurveyResponse node2, double distance) {
			this.student1 = node1;
			this.student2 = node2;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(DistanceNode that) {
			if (this.distance < that.distance) {
				return -1;
			} else if (this.distance > that.distance) {
				return +1;
			} else {
				return 0;
			}
		}
	}
	
	public static double computeDistance(ISurveyResponse student1, ISurveyResponse student2, List<ISurveyScale> surveyScales) {
		double distance = 0;
		for(int k=0; k < surveyScales.size(); k++) {
			ISurveyScale curScale = surveyScales.get(k);
			distance += curScale.distance(student1,student2,k);
		}
		return distance;
	}
	
	@Override
	public List<IGroup> formGroup(List<ISurveyResponse> surveyResults, 
			List<ISurveyScale> surveyScales, int groupSize) {
	
		List<IGroup> groups = new ArrayList<IGroup>();
		int numberOfGroups = (int) Math.ceil((double) surveyResults.size()/ (double) groupSize);

		if (groupSize == 0) {
			return groups;
		}
		
		
		for (int i=0; i < surveyResults.size(); i++) {
			for (int j=i+1; j < surveyResults.size(); j++) {
				double distance = 0;
				ISurveyResponse student1 = surveyResults.get(i);
				ISurveyResponse student2 = surveyResults.get(j);
				distance = computeDistance(student1, student2, surveyScales);
				pq.add(new DistanceNode(student1, student2, distance));
			}
		}
		
		IGroup curGroup;
		int assigned = 0;
		List<DistanceNode> revisitedResponses = new ArrayList<DistanceNode>();
		while(!pq.isEmpty()) {
			DistanceNode curNode = pq.poll();
			ISurveyResponse student1 = curNode.student1;
			ISurveyResponse student2 = curNode.student2;
			if (groupAssociation.containsKey(student1) && groupAssociation.containsKey(student2)) {
				// log warn because it should not have a pair which is added before
			} else if (groupAssociation.containsKey(student1)) {
				curGroup = groupAssociation.get(student1);
				if (curGroup.hasRoom()) {
					curGroup.addGroupMember(student2);
					groupAssociation.put(student2, curGroup);
					assigned++;
				} else {
					revisitedResponses.add(curNode);
				}
				if ((assigned == surveyResults.size()-1) && groups.size() < numberOfGroups) {
					curGroup = SystemConfig.instance().getGroupFormationFactory().createGroup();
					curGroup.setGropuSize(groupSize);
					groups.add(curGroup);
					curGroup.setGroupNumber(groups.size());
					curGroup.addGroupMember(student2);
					groupAssociation.put(student2, curGroup);
					assigned++;
				}
			} else if (groupAssociation.containsKey(student2)) {
				curGroup = groupAssociation.get(student2);
				if (curGroup.hasRoom()) {
					curGroup.addGroupMember(student1);
					groupAssociation.put(student1, curGroup);
					assigned++;
				} else {
					revisitedResponses.add(curNode);
				} 
				if ((assigned == surveyResults.size()-1) && groups.size() < numberOfGroups) {
					curGroup = SystemConfig.instance().getGroupFormationFactory().createGroup();
					curGroup.setGropuSize(groupSize);
					groups.add(curGroup);
					curGroup.setGroupNumber(groups.size());
					curGroup.addGroupMember(student1);
					groupAssociation.put(student1, curGroup);
					assigned++;
				}
			} else {
				if (groups.size() < numberOfGroups) {
					curGroup = SystemConfig.instance().getGroupFormationFactory().createGroup();
					curGroup.setGropuSize(groupSize);
					groups.add(curGroup);
					curGroup.setGroupNumber(groups.size());
					curGroup.addGroupMember(student1);
					groupAssociation.put(student1, curGroup);
					assigned++;
					if (curGroup.hasRoom()) {
						curGroup.addGroupMember(student2);
						groupAssociation.put(student2, curGroup);
						assigned++;
					}
				} else {
					revisitedResponses.add(curNode);
				}
			}
			if (pq.isEmpty()) {
				for (DistanceNode node: revisitedResponses) {
					pq.add(node);
				}
				revisitedResponses.clear();
			}
		}
		return groups;
	}
}
