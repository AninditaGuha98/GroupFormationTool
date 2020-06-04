package com.csci5308.grouptool.AdminDashboard.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csci5308.grouptool.AdminDashboard.Service.UpdateCourse;
import com.csci5308.grouptool.ControllerObjects.Course;

@Controller
public class DelCourses {
	@RequestMapping(value = "/DelCourse", method = RequestMethod.GET)
	public String deleteCourseController(Model model) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		UpdateCourse courseService = new UpdateCourse();
		courseList = courseService.displayCourse();
		model.addAttribute("courseList", courseList);
		return "displaycourses";
	}

	@RequestMapping(value = "/checkedCourse", method = RequestMethod.POST)
	public String deleteCheckedCourse(@RequestParam("checkedCourse") ArrayList<String> coursesChecked, Model model) {
		String message = "hello";
		if (coursesChecked != null) {
			UpdateCourse courseService = new UpdateCourse();
			message = courseService.deleteCourse(coursesChecked);
			model.addAttribute("message", message);
			model.addAttribute("courseList", new ArrayList<>());
		}
		return "displaycourses";
	}

}
