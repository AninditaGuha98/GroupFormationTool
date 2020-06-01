package com.csci5308.grouptool.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.csci5308.grouptool.Repository.UpdateCourseDao;
import com.csci5308.grouptool.Service.UpdateCourse;

@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)
public class UpdateCourseTest {
	
	@InjectMocks
	UpdateCourse updcourse;
	
	@Mock
	UpdateCourseDao courseDao;
	
	@Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void addCourseTest()
	{
		
	}
	
	
}
