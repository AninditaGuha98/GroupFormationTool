package com.csci5308.grouptool.AdminDashboard.Service;

import java.util.ArrayList;

import com.csci5308.grouptool.ControllerObjects.User;

public interface AssignInstructorServiceI {
	public ArrayList<User> displayUsers();
	public String assignInstructor(String courseId,String bannerId);
}
