package CSCI5308.GroupFormationTool.GroupFormationAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Group implements IGroup {

	private int groupSize;
	private int groupNumber;
	private List<ISurveyResponse> groupList;

	public Group() {
		this.groupNumber = -1;
		this.groupSize = 0;
		groupList = new ArrayList<ISurveyResponse>();
	}

	@Override
	public int getGroupSize() {
		return this.groupSize;
	}

	@Override
	public void setGropuSize(int groupSize) {
		this.groupSize = groupSize;
	}

	@Override
	public int getGroupNumber() {
		return this.groupNumber;
	}

	@Override
	public void setGroupNumber(int groupNumber) {
		this.groupNumber = groupNumber;
	}

	@Override
	public int getCurrentSize() {
		return this.groupList.size();
	}
	
	@Override
	public List<ISurveyResponse> getGroupMembers() {
		return this.groupList;
	}

	@Override
	public void addGroupMember(ISurveyResponse member) throws IllegalStateException {
		if (getCurrentSize() == getGroupSize()) {
			throw new IllegalStateException("Group is full.");
		}
		groupList.add(member);
	}
	
	@Override
	public boolean hasRoom() {
		if (getCurrentSize() < getGroupSize()) {
			return true;
		} else {
			return false;
		}
	}
}
