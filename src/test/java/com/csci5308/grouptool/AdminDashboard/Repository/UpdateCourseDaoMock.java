package com.csci5308.grouptool.AdminDashboard.Repository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.csci5308.grouptool.AdminDashboard.Repository.UpdateCourseDao;
import com.csci5308.grouptool.AdminDashboard.Repository.UpdateCourseDaoI;
import com.csci5308.grouptool.ControllerObjects.Course;

@RunWith(MockitoJUnitRunner.class)
public class UpdateCourseDaoMock
{
	UpdateCourseDaoI updateCourseObjectMock=mock(UpdateCourseDao.class);
	Course course;
	ArrayList<String> courseList;
	
	UpdateCourseDaoMock()
	{
		course=new Course();
		course.setCourseID("CSCI5308");
		course.setCourseName("Adv Software Dev");
		courseList=new ArrayList<String>();
		courseList.add("CSCI5308");
	}
	
	@Test
	public void addCourseTest()
	{
		when(updateCourseObjectMock.addCourse(course)).thenReturn("Course added successfully");
		assertEquals(updateCourseObjectMock.addCourse(course),"Course added successfully");
		verify(updateCourseObjectMock).addCourse(course);
	}
	
	@Test
	public void checkIfCourseExistsTest()
	{
		when(updateCourseObjectMock.checkIfCourseExists(course)).thenReturn(true);
		assertTrue(updateCourseObjectMock.checkIfCourseExists(course));
		verify(updateCourseObjectMock).checkIfCourseExists(course);
	}
	
	@Test
	public void deleteCourseTest()
	{
		when(updateCourseObjectMock.deleteCourse(courseList)).thenReturn("Course deleted successfully");
		assertEquals(updateCourseObjectMock.deleteCourse(courseList),"Course deleted successfully");
		verify(updateCourseObjectMock).deleteCourse(courseList);
	}
}
