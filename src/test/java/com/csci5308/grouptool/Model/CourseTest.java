package com.csci5308.grouptool.Model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.csci5308.grouptool.ControllerObjects.User;

public class CourseTest 
{	
	@Test
	void set_getbannerID()
	{
		User uObj=new User();
		uObj.setBannerId("B00888888");
		assertSame("B00888888",uObj.getBannerId());
	}
	
	@Test
	void set_getFirstName()
	{
		User uObj=new User();
		uObj.setFirstName("Ryan");
		assertSame("Ryan",uObj.getFirstName());
	}
	
	@Test
	void set_getLastName()
	{
		User uObj=new User();
		uObj.setLastName("Ferns");
		assertSame("Ferns",uObj.getLastName());
	}
	
}
