package CSCI5308.GroupFormationTool.Courses;

public class CourseDBFactory implements CourseDBAbstractFactory{

	@Override
	public ICoursePersistence createCourseDBObject() {
		// TODO Auto-generated method stub
		return new CourseDB();
	}
	 

}
