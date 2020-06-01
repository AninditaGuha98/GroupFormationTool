package com.csci5308.grouptool.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.csci5308.grouptool.ControllerObjects.Course;
import com.csci5308.grouptool.util.DatabaseConnection;

@Repository
public class UpdateCourseDao implements UpdateCourseDaoI
{
	Connection connection;
	String query;
	PreparedStatement statement;
	int rowsEffected;
	@Override
	public String addCourse(Course course) {
		System.out.println("DAO ID"+course.getCourseID());
		System.out.println("DAO Name"+course.getCourseName());
		//Insert into db
		query = "INSERT " + " INTO " + "Courses" + " (courseCode,courseName) " + " values(?,?); ";		
		connection = DatabaseConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			System.out.println("ps "+statement);
			statement.setString(1, course.getCourseID());
			statement.setString(2, course.getCourseName());
			rowsEffected = statement.executeUpdate();
			if (rowsEffected > 0) {
				System.out.println("value added");
			}
		}

		catch (SQLException e) {
			System.out.println("value not added exception");
		}

		finally {
			System.out.println("value finally");
		}
		return null;
	}
}
