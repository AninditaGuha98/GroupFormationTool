package com.csci5308.grouptool.AdminDashboard.Service;

import java.util.ArrayList;

import com.csci5308.grouptool.ControllerObjects.Course;

public interface UpdateCourseI 
{
String addCourse(Course course);
ArrayList<Course> displayCourse();
String deleteCourse(ArrayList<String> coursesToDelete);
}
