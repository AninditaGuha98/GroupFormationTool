package CSCI5308.GroupFormationTool.CoursesTest;

import CSCI5308.GroupFormationTool.Courses.InterfaceCourse;
import CSCI5308.GroupFormationTool.Courses.ObjectFactory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.Courses.Course;
import CSCI5308.GroupFormationTool.Courses.CourseFactory;
import CSCI5308.GroupFormationTool.Courses.ICoursePersistence;

@SpringBootTest
@SuppressWarnings("deprecation")
class CourseTest 
{


	@Test
	public void setIdTest() 
	{
		InterfaceCourse interfaceCourse = ObjectFactory.createObject(new CourseFactory());
		interfaceCourse.setId(7);
		Assert.isTrue(interfaceCourse.getId() == 7);
	}

	@Test
	public void getIdTest() 
	{
		InterfaceCourse interfaceCourse = ObjectFactory.createObject(new CourseFactory());
		interfaceCourse.setId(7);
		Assert.isTrue(interfaceCourse.getId() == 7);
	}

	@Test
	public void setTitleTest() 
	{
		InterfaceCourse interfaceCourse = ObjectFactory.createObject(new CourseFactory());
		interfaceCourse.setTitle("Advanced Topics in Software Development");
		Assert.isTrue(interfaceCourse.getTitle().equals("Advanced Topics in Software Development"));
	}

	@Test
	public void getTitleTest() 
	{
		InterfaceCourse interfaceCourse = ObjectFactory.createObject(new CourseFactory());
		interfaceCourse.setTitle("Advanced Topics in Software Development");
		Assert.isTrue(interfaceCourse.getTitle().equals("Advanced Topics in Software Development"));
	}

}
