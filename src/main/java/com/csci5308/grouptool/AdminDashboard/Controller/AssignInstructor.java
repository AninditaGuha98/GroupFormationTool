package com.csci5308.grouptool.AdminDashboard.Controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.csci5308.grouptool.AdminDashboard.Service.AssignInstructorService;
import com.csci5308.grouptool.AdminDashboard.Service.AssignInstructorServiceI;
import com.csci5308.grouptool.AdminDashboard.Service.UpdateCourse;
import com.csci5308.grouptool.ControllerObjects.Course;
import com.csci5308.grouptool.ControllerObjects.User;

@Controller
public class AssignInstructor {
	ArrayList<Course> courseList;
	ArrayList<User> userList;

	@RequestMapping(value = "/AssignInstructor", method = RequestMethod.GET)
	public String assignCoursePageLaunch(Model model) {
		userList = new ArrayList<User>();
		AssignInstructorServiceI instructorServiceObj = new AssignInstructorService();
		userList = instructorServiceObj.displayUsers();
		model.addAttribute("userList", userList);
		courseList = new ArrayList<Course>();
		UpdateCourse courseService = new UpdateCourse();
		courseList = courseService.displayCourse();
		model.addAttribute("courseList", courseList);
		return "selectinstructor";
	}

	@RequestMapping(value = "/assignRole", method = RequestMethod.POST)
	public String assignRole(@RequestParam("CourseCode") String courseCode, User user, Model model) {
		model.addAttribute("courseList", courseList);
		model.addAttribute("userList", userList);
		AssignInstructorServiceI instructorServiceObj = new AssignInstructorService();
		String[] courseID = courseCode.split("-");
		String message = instructorServiceObj.assignInstructor(courseID[0].trim(), user.getBannerId());
		model.addAttribute("message", message);
		return "selectinstructor";
	}
}
