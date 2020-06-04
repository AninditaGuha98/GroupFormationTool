package com.csci5308.grouptool.AdminDashboard.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.csci5308.grouptool.ControllerObjects.Course;
import com.csci5308.grouptool.util.DatabaseConnection;

@Repository
public class UpdateCourseDao implements UpdateCourseDaoI {
	Connection connection;
	String query;
	PreparedStatement statement;
	Statement selectStatement;
	int rowsEffected;
	ResultSet rs;

	
	@Override
	public boolean checkIfCourseExists(Course course)
	{
		//
		Boolean result=false;
		connection = DatabaseConnection.getConnection();
		try {
			selectStatement = connection.createStatement();
			query = "SELECT courseID FROM Courses WHERE courseCode='"+course.getCourseID()+"';";
			rs = selectStatement.executeQuery(query);			
			while (rs.next()) {
				result=true;
			}
		} catch (SQLException e) {
			result=false;
			e.printStackTrace();
		} finally {
			try {
				selectStatement.close();
				connection.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		//
		return result;		
	}
	
	@Override
	public String addCourse(Course course) {
		String message = "Course added successfully";

		if(checkIfCourseExists(course))
		{
			message = "Course already exists";
		}
		else
		{
			query = "INSERT " + " INTO " + "Courses" + " (courseCode,courseName) " + " values(?,?); ";
			connection = DatabaseConnection.getConnection();
			try {
				System.out.println("ps " + statement);
				statement.setString(1, course.getCourseID());
				statement.setString(2, course.getCourseName());
				rowsEffected = statement.executeUpdate();
			} catch (SQLIntegrityConstraintViolationException ex) {
				message = "Course with ID " + course.getCourseID() + " already exists";
			} catch (SQLException e) {
				message = "Course could not be added";
			} finally {
				try {
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return message;
	}

	public ArrayList<Course> displayCourse() {
		ArrayList<Course> courseList = new ArrayList<Course>();
		connection = DatabaseConnection.getConnection();
		try {
			selectStatement = connection.createStatement();
			query = "SELECT courseCode,courseName from Courses";
			rs = selectStatement.executeQuery(query);
			Course course;
			while (rs.next()) {
				course = new Course();
				course.setCourseID(rs.getString("courseCode"));
				course.setCourseName(rs.getString("courseName"));
				courseList.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				selectStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return courseList;
	}

	@Override
	public String deleteCourse(ArrayList<String> coursesToDelete) {
		String message="Course deleted successfully";
		Iterator<String> i = coursesToDelete.iterator();
		connection = DatabaseConnection.getConnection();
		while (i.hasNext()) {
			String currentCourse = i.next();
			query = "DELETE FROM courserole WHERE courseID IN (SELECT courseID FROM courses WHERE courseCode ='"
					+ currentCourse + "');";
			try {
				statement = connection.prepareStatement(query);
				statement.executeUpdate();
					query = "DELETE FROM courses WHERE courseCode='" + currentCourse + "';";
					statement = connection.prepareStatement(query);
					rowsEffected = statement.executeUpdate();
					if(rowsEffected>0)
					{
						message="Course deleted successfully";
					}
			} catch (SQLException e) {
				message = "Course could not be removed";
			}
		}
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
}