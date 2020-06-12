package CSCI5308.GroupFormationTool.CourseHomePage.Interface;

import java.util.List;

import CSCI5308.GroupFormationTool.AccessControl.User;
import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.Role;

public interface ICourseUserRelationship
{
	public boolean userHasRoleInCourse(User user, Role role, Course course);
	public List<Role> loadAllRoluesForUserInCourse(User user, Course course);
	public boolean enrollUserInCourse(User user, Course course, Role role);
}
