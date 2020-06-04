package com.csci5308.grouptool.Security.Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@ControllerAdvice
class PrincipalControllerAdvice {
	
	@ModelAttribute("currentUser")
	Principal principal(Principal p) {
		return p;
	}
}

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
	
//	@GetMapping("/coursepage")
//	public String getUserHome() {
//		return "userhome";
//	}

	@PostMapping("/homeredirect")
	public String goToMainPage(){
		return "homeredirect";
	}


}
