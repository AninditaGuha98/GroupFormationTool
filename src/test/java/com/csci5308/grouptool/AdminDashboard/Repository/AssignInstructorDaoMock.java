package com.csci5308.grouptool.AdminDashboard.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.jupiter.api.Test;
import com.csci5308.grouptool.AdminDashboard.Repository.AssignInstructorDao;
import com.csci5308.grouptool.AdminDashboard.Repository.AssignInstructorDaoI;
import com.csci5308.grouptool.AdminDashboard.Repository.UpdateCourseDao;
import com.csci5308.grouptool.AdminDashboard.Repository.UpdateCourseDaoI;
import com.csci5308.grouptool.ControllerObjects.Course;

@RunWith(MockitoJUnitRunner.class)
public class AssignInstructorDaoMock 
{
	AssignInstructorDaoI assignInstructorDaoObjMock=mock(AssignInstructorDao.class);
	String courseID;
	String bannerID;
	
	AssignInstructorDaoMock()
	{
		courseID="CSCI5308";
		bannerID="B00888888";
	}
	
	@Test
	public void assignInstructorTest()
	{
		when(assignInstructorDaoObjMock.assignInstructor(courseID, bannerID)).thenReturn("Instructor assigned");
		assertEquals(assignInstructorDaoObjMock.assignInstructor(courseID, bannerID),"Instructor assigned");
		verify(assignInstructorDaoObjMock).assignInstructor(courseID, bannerID);
		
	}
}
