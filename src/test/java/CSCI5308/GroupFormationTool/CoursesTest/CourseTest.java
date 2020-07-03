package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.InterfaceCourse;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;

@SpringBootTest
@SuppressWarnings("deprecation")
class CourseTest 
{
	@Test
	public void ConstructorTests() 
	{
		InterfaceCourse interfaceCourse = new Course();
		Assert.isTrue(interfaceCourse.getId() == -1);
		Assert.isTrue(interfaceCourse.getTitle().isEmpty());

		ICoursePersistence courseDB = new CourseDBMock();
		interfaceCourse = new Course(0, courseDB);
		Assert.isTrue(interfaceCourse.getId() == 0);
		Assert.isTrue(interfaceCourse.getTitle().equals("Software Engineering"));
	}

	@Test
	public void setIdTest() 
	{
		InterfaceCourse interfaceCourse = new Course();
		interfaceCourse.setId(7);
		Assert.isTrue(interfaceCourse.getId() == 7);
	}

	@Test
	public void getIdTest() 
	{
		InterfaceCourse interfaceCourse = new Course();
		interfaceCourse.setId(7);
		Assert.isTrue(interfaceCourse.getId() == 7);
	}

	@Test
	public void setTitleTest() 
	{
		InterfaceCourse interfaceCourse = new Course();
		interfaceCourse.setTitle("Advanced Topics in Software Development");
		Assert.isTrue(interfaceCourse.getTitle().equals("Advanced Topics in Software Development"));
	}

	@Test
	public void getTitleTest() 
	{
		InterfaceCourse interfaceCourse = new Course();
		interfaceCourse.setTitle("Advanced Topics in Software Development");
		Assert.isTrue(interfaceCourse.getTitle().equals("Advanced Topics in Software Development"));
	}

	@Test
	public void deleteCourseTest() 
	{
		ICoursePersistence courseDB = new CourseDBMock();
		boolean status = courseDB.deleteCourse(0);
		Assert.isTrue(status);
	}

	@Test
	public void createCourseTest() 
	{
		ICoursePersistence courseDB = new CourseDBMock();
		InterfaceCourse interfaceCourse = new Course();
		interfaceCourse.setId(0);
		interfaceCourse.setTitle("Software Engineering");
		courseDB.createCourse(interfaceCourse);
		Assert.isTrue(interfaceCourse.getId() == 0);
		Assert.isTrue(interfaceCourse.getTitle().equals("Software Engineering"));
	}

}
