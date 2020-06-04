package com.csci5308.grouptool.AdminDashboard.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;

import com.csci5308.grouptool.ControllerObjects.Course;
import com.csci5308.grouptool.ControllerObjects.User;
import com.csci5308.grouptool.util.DatabaseConnection;

public class AssignInstructorDao implements AssignInstructorDaoI {
	Connection connection;
	String query;
	PreparedStatement statement;
	Statement selectStatement;
	int rowsEffected;
	ResultSet rs;

	@Override
	public ArrayList<User> displayUsers() {
		ArrayList<User> userList = new ArrayList<User>();
		connection = DatabaseConnection.getConnection();
		try {
			selectStatement = connection.createStatement();
			query = "SELECT bannerID,firstName,lastName from users";
			rs = selectStatement.executeQuery(query);
			User user;
			while (rs.next()) {
				user = new User();
				user.setBannerId(rs.getString("bannerID"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println("value finally");
			try {
				selectStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return userList;
	}

	public String assignInstructor(String courseId, String bannerId) {

		// Insert into db
		String message = "Select a course against an instructor";
		query = "insert into courserole(courseID,roleID,bannerID) SELECT courseID,'2','" + bannerId
				+ "' from courses where courseCode='" + courseId + "';";
		connection = DatabaseConnection.getConnection();
		try {
			statement = connection.prepareStatement(query);
			rowsEffected = statement.executeUpdate();
			if (rowsEffected > 0) {
				message="Instructor assigned";
			}
		} catch (SQLIntegrityConstraintViolationException ex) {
			message = "Instructor could not be assigned";
		} catch (SQLException e) {
			message = "Instructor could not be assigned";
		}

		finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return message;
	}
}
