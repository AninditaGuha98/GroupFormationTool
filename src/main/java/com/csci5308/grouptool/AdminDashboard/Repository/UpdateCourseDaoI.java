package com.csci5308.grouptool.AdminDashboard.Repository;

import java.util.ArrayList;

import com.csci5308.grouptool.ControllerObjects.Course;

public interface UpdateCourseDaoI {
	String addCourse(Course course);
	ArrayList<Course> displayCourse();
	String deleteCourse(ArrayList<String> coursesToDelete);
	boolean checkIfCourseExists(Course course);

}
