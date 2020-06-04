package com.csci5308.grouptool.AdminDashboard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminDashboard {
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String greeting() {
		return "admindashboard";
	}
}