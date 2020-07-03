package CSCI5308.GroupFormationTool.Courses;

import java.util.List;

import CSCI5308.GroupFormationTool.Courses.Course;

public interface ICoursePersistence {
	public List<Course> loadAllCourses();

	public void loadCourseByID(long id, Course course);

	public boolean createCourse(Course course);

	public boolean deleteCourse(long id);
}
