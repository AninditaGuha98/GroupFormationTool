package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;

public interface ICourseUserRelationshipPersistence {
	public List<User> findAllUsersWithoutCourseRole(Role role, long courseID);

	public List<User> findAllUsersWithCourseRole(Role role, long courseID);

	public boolean enrollUser(InterfaceCourse course, User user, Role role);

	public List<Role> loadUserRolesForCourse(InterfaceCourse course, User user);
}
