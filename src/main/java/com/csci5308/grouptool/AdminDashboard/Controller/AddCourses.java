package com.csci5308.grouptool.AdminDashboard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csci5308.grouptool.AdminDashboard.Service.UpdateCourse;
import com.csci5308.grouptool.AdminDashboard.Service.UpdateCourseI;
import com.csci5308.grouptool.ControllerObjects.Course;

@Controller
public class AddCourses {
	@RequestMapping(value = "/AddCourse", method = RequestMethod.GET)
	public String assignCoursePageLaunch(Model model) {
		model.addAttribute("course", new Course());
		return "addcourse";
	}

//	@RequestMapping(value ="/AssignInstructor",method = RequestMethod.GET)
//	public String assignInstructor() 
//	{
//		return "assigninstructor";
//	}

	@RequestMapping(value = "/InsertCourse", method = RequestMethod.POST)
	public String assignCourseController(@ModelAttribute Course course, Model model) {
		UpdateCourseI updc = new UpdateCourse();
		String message = updc.addCourse(course);
		model.addAttribute("message", message);
		return "addcourse";
	}
}
