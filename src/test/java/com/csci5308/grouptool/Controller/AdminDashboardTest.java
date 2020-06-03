package com.csci5308.grouptool.Controller;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.csci5308.grouptool.GroupToolApplication;
import com.csci5308.grouptool.AdminDashboard.Controller.AdminDashboard;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {
		AdminDashboard.class, GroupToolApplication.class })
@AutoConfigureMockMvc
public class AdminDashboardTest 
{
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void checkAdminDashboardLaunch() throws Exception {
		this.mockMvc.perform(get("/Login")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Welcome to the Group Formation Tool")));	
}
	@Test
	public void checkAdminAddCourseLaunch() throws Exception {
		this.mockMvc.perform(get("/AddCourse")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("")));
	}
	@Test
	public void checkAdminDeleteCourseLaunch() throws Exception {
			this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("")));
	}
	@Test
	public void checkAdminAssignInstructorLaunch() throws Exception {
			this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
					.andExpect(content().string(containsString("")));
	}
		
	
}
