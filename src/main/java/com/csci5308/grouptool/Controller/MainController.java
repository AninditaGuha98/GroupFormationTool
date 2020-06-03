package com.csci5308.grouptool.Controller;

import com.csci5308.grouptool.Interface.UserService;
import com.csci5308.grouptool.Model.UserModel;
import com.csci5308.grouptool.Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class MainController implements WebMvcConfigurer {

	@GetMapping("/index")
	public String FrontPage(UserModel userModel) {
		return "index";
	}

	@PostMapping("/submit")
	public ModelAndView CheckIfUserDetailsExistElseCreate(UserModel userModel) {
		UserService userService = new UserServiceImpl();
		ModelAndView mv = new ModelAndView("index");
		if (userService.checkifuserexists(userModel)) {
			mv.addObject("message", "User Exists");
			mv.setViewName("index");
		} else {
			mv.addObject("message", "User Created");
			mv.setViewName("index");
		}
		return mv;
	}
}
