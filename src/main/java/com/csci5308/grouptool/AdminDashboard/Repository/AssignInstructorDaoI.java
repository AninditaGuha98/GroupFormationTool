package com.csci5308.grouptool.AdminDashboard.Repository;

import java.util.ArrayList;

import com.csci5308.grouptool.ControllerObjects.User;

public interface AssignInstructorDaoI {
	public ArrayList<User> displayUsers();
	public String assignInstructor(String courseId,String bannerId);

}
