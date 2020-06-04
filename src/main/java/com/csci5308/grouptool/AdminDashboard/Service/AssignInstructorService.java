package com.csci5308.grouptool.AdminDashboard.Service;

import java.util.ArrayList;

import com.csci5308.grouptool.AdminDashboard.Repository.AssignInstructorDao;
import com.csci5308.grouptool.AdminDashboard.Repository.AssignInstructorDaoI;
import com.csci5308.grouptool.ControllerObjects.User;

public class AssignInstructorService implements AssignInstructorServiceI 
{
	@Override
	public ArrayList<User> displayUsers() {
		ArrayList<User> userList=new ArrayList<User>();
		AssignInstructorDaoI instructorDaoObject=new AssignInstructorDao();
		userList=instructorDaoObject.displayUsers();
		return userList;
	}

	@Override
	public String assignInstructor(String courseId, String bannerId) {
		AssignInstructorDaoI instructorDaoObject=new AssignInstructorDao();
		String message=instructorDaoObject.assignInstructor(courseId,bannerId);
		return message;
	}

}
