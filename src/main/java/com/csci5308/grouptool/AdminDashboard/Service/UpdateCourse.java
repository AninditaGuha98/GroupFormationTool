package com.csci5308.grouptool.AdminDashboard.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csci5308.grouptool.AdminDashboard.Repository.UpdateCourseDao;
import com.csci5308.grouptool.ControllerObjects.Course;

@Service
public class UpdateCourse implements UpdateCourseI {

//	@Autowired
//	UpdateCourseDao dao;

	@Override
	public String addCourse(Course course) {
		UpdateCourseDao upds = new UpdateCourseDao();
		String message = upds.addCourse(course);
		return message;
	}

	@Override
	public ArrayList<Course> displayCourse() {
		ArrayList<Course> courseList = new ArrayList<Course>();
		UpdateCourseDao upds = new UpdateCourseDao();
		courseList = upds.displayCourse();
		return courseList;
	}

	@Override
	public String deleteCourse(ArrayList<String> coursesToDelete) {
		UpdateCourseDao upds = new UpdateCourseDao();
		String message = upds.deleteCourse(coursesToDelete);
		return message;
	}

}
