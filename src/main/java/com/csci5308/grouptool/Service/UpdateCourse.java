package com.csci5308.grouptool.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.csci5308.grouptool.ControllerObjects.Course;
import com.csci5308.grouptool.Repository.UpdateCourseDao;

@Service
public class UpdateCourse implements UpdateCourseI{
	
//	@Autowired
//	UpdateCourseDao dao;
	
	@Override
	public String addCourse(Course course) {
		System.out.println("Service ID"+course.getCourseID());
		System.out.println("Service Name"+course.getCourseName());
		UpdateCourseDao upds=new UpdateCourseDao();
		upds.addCourse(course);
		// TODO Auto-generated method stub
		return null;
	}
	
}
