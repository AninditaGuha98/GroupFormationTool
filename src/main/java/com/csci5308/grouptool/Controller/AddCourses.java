package com.csci5308.grouptool.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.csci5308.grouptool.ControllerObjects.Course;
import com.csci5308.grouptool.Service.UpdateCourse;

@Controller
public class AddCourses 
{
	@RequestMapping(value ="/AddCourse",method = RequestMethod.GET)
	public String assignCoursePageLaunch(Model model) 
	{
		model.addAttribute("course",new Course());
		return "addcourse";
	}
	
//	@RequestMapping(value ="/AssignInstructor",method = RequestMethod.GET)
//	public String assignInstructor() 
//	{
//		return "assigninstructor";
//	}
	
	@RequestMapping(value ="/InsertCourse",method = RequestMethod.POST)
	public String assignCourseController(@ModelAttribute Course course)
	{
		System.out.println("Controller ID"+course.getCourseID());
		System.out.println("Controller Name"+course.getCourseName());
		UpdateCourse updc=new UpdateCourse();
		updc.addCourse(course);
		return "assigninstructor";
	}
}
