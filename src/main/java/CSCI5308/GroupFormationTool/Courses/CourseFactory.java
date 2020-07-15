package CSCI5308.GroupFormationTool.Courses;

public class CourseFactory implements CourseAbstractFactory {

	public InterfaceCourse createCourseObject() {
		return new Course();
	}

}
