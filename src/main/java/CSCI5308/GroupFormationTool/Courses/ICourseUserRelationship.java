package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

public interface ICourseUserRelationship {
	public boolean userHasRoleInCourse(User user, Role role, InterfaceCourse course);

	public List<Role> loadAllRoluesForUserInCourse(User user, InterfaceCourse course);

	public boolean enrollUserInCourse(User user, InterfaceCourse course, Role role);
}
