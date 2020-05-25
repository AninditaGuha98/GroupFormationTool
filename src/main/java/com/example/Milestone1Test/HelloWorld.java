package com.example.Milestone1Test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorld {
	
	@GetMapping("/")
	  public String greetingForm() {
	    return "helloworld.html";
	  }
	

}
