package com.csci5308.grouptool.Security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityContoller {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}	
}
