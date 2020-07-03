package CSCI5308.GroupFormationTool.Courses;

import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.SystemConfig;
import CSCI5308.GroupFormationTool.AccessControl.User;

@Controller
public class CourseAdminController {
	private static final String ID = "id";
	private static final String TITLE = "title";
	private static final String INSTRUCTOR = "instructor";

	@GetMapping("/admin/course")
	public String course(Model model) {
		ICoursePersistence courseDB = SystemConfig.instance().getCourseDB();
		List<InterfaceCourse> allCourses = courseDB.loadAllCourses();
		model.addAttribute("courses", allCourses);
		return "admin/course";
	}

	@RequestMapping(value = "/admin/assigninstructor")
	public String assignInstructor(Model model, @RequestParam(name = ID) long courseID) {
		ICoursePersistence courseDB = SystemConfig.instance().getCourseDB();
		InterfaceCourse interfaceCourse = new Course();
		courseDB.loadCourseByID(courseID, interfaceCourse);
		model.addAttribute("course", interfaceCourse);
		ICourseUserRelationshipPersistence courseUserRelationshipDB = SystemConfig.instance()
				.getCourseUserRelationshipDB();
		List<User> allUsersNotCurrentlyInstructors = courseUserRelationshipDB
				.findAllUsersWithoutCourseRole(Role.INSTRUCTOR, courseID);
		model.addAttribute("users", allUsersNotCurrentlyInstructors);
		return "admin/assigninstructor";
	}

	@GetMapping("/admin/deletecourse")
	public ModelAndView deleteCourse(@RequestParam(name = ID) long courseID) {
		ICoursePersistence courseDB = SystemConfig.instance().getCourseDB();
		InterfaceCourse interfaceCourse = new Course();
		interfaceCourse.setId(courseID);
		interfaceCourse.delete(courseDB);
		ModelAndView mav = new ModelAndView("redirect:/admin/course");
		return mav;
	}

	@RequestMapping(value = "/admin/createcourse", method = RequestMethod.POST)
	public ModelAndView createCourse(@RequestParam(name = TITLE) String title) {
		ICoursePersistence courseDB = SystemConfig.instance().getCourseDB();
		InterfaceCourse interfaceCourse = new Course();
		interfaceCourse.setTitle(title);
		interfaceCourse.createCourse(courseDB);
		ModelAndView mav = new ModelAndView("redirect:/admin/course");
		return mav;
	}

	@RequestMapping(value = "/admin/assigninstructortocourse")
	public ModelAndView assignInstructorToCourse(@RequestParam(name = INSTRUCTOR) List<Integer> instructor,
			@RequestParam(name = ID) long courseID) {
		InterfaceCourse interfaceCourse = new Course();
		interfaceCourse.setId(courseID);
		Iterator<Integer> iter = instructor.iterator();
		ICourseUserRelationshipPersistence courseUserRelationshipDB = SystemConfig.instance()
				.getCourseUserRelationshipDB();
		while (iter.hasNext()) {
			User u = new User();
			u.setId(iter.next().longValue());
			courseUserRelationshipDB.enrollUser(interfaceCourse, u, Role.INSTRUCTOR);
		}
		ModelAndView mav = new ModelAndView("redirect:/admin/course");
		return mav;
	}
}