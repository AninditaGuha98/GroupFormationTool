package CSCI5308.GroupFormationTool.MyGroupFormation;

import java.util.List;
import java.util.Set;

public interface IGroup {
	public int getGroupNumber();
	public void setGroupNumber();
	public List<Set<ISurveyResponse>> getGroupMembers();
	public void addGroupMember(ISurveyResponse member);
}
