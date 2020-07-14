package CSCI5308.GroupFormationTool.Courses;

public class ObjectFactory {

	public static InterfaceCourse createObject(CourseAbstractFactory courseAbsFObj) {
		return courseAbsFObj.createCourseObject();
	}

	public static ICoursePersistence createDBObject(CourseDBAbstractFactory courseAbsFObj) {
		return courseAbsFObj.createCourseDBObject();
	}

}
