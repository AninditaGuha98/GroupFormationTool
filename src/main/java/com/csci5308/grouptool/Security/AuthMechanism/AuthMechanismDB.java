package com.csci5308.grouptool.Security.AuthMechanism;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csci5308.grouptool.Database.DBConfigure;

import java.sql.*;

public class AuthMechanismDB implements IAuthMechanism {

	private String url;
	private String dbUserName;
	private String dbPassword;
	
	public AuthMechanismDB() {
		DBConfigure dbConfigure = new DBConfigure();
		this.url = dbConfigure.getUrl();
		this.dbUserName = dbConfigure.getUser();
		this.dbPassword = dbConfigure.getPass();
	}
	
	@Override
	public boolean isAvailableUser(String userEmail) {
		
		boolean isAvailableUser = false;
		int rows = 0;
		
		PreparedStatement stat = null;
		Connection conn = null;
		String query = "SELECT COUNT(*) FROM Users WHERE email = ?;";
		try {
		    conn = DriverManager.getConnection(url, dbUserName, dbPassword);
		    stat = conn.prepareStatement(query);
		    stat.setString(1, userEmail);
		    
		    ResultSet rs = stat.executeQuery();
		    if(rs.next()) {
		       rows = rs.getInt(1);
		    }
		    if (rows == 1)
		    	isAvailableUser = true;
		}
		catch (Exception e )
		{
			//TODO
			e.printStackTrace();
		} 
		finally
		{
			try {
				stat.close();
				conn.close();
			} 
			catch (Exception e)
			{
				//TODO
				e.printStackTrace();
			}
		}
		return isAvailableUser;
		
	}

	@Override
	public boolean isValidUser(String userEmail, String rawPassword) {
		boolean isValidleUser = false;
		String hashedPassword = "";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		PreparedStatement stat = null;
		Connection conn = null;
		String query = "SELECT password FROM Users WHERE email = ?;";
		try {
		    conn = DriverManager.getConnection(url, dbUserName, dbPassword);
		    stat = conn.prepareStatement(query);
		    stat.setString(1, userEmail);
		    
		    ResultSet rs = stat.executeQuery();
		    if(rs.next()) {
		       hashedPassword = rs.getString(1);
		    }
		    if (passwordEncoder.matches(rawPassword, hashedPassword))
		    	isValidleUser = true;
		}
		catch (Exception e )
		{
			// TODO
			e.printStackTrace();
		} 
		finally
		{
			try {
				stat.close();
				conn.close();
			} 
			catch (Exception e)
			{
				// TODO
				e.printStackTrace();
			}
		}
		return isValidleUser;
	}

	@Override
	public List<String> getUserRoles(String userEmail) {
		List<String> roles = new ArrayList<String>();
		PreparedStatement stat = null;
		Connection conn = null;
		String query = "SELECT Roles.roleName From Users, SystemRole, Roles "
				+ "WHERE Users.bannerID = SystemRole.bannerID "
				+ "AND SystemRole.roleID = Roles.roleID "
				+ "AND email = ?";
		try {
		    conn = DriverManager.getConnection(url, dbUserName, dbPassword);
		    stat = conn.prepareStatement(query);
		    stat.setString(1, userEmail);
		    
		    ResultSet rs = stat.executeQuery();
		    while (rs.next()) {
		       roles.add("ROLE_"+ rs.getString(1));
		    }
		}
		catch (Exception e )
		{
			// TODO
			e.printStackTrace();
		} 
		finally
		{
			try {
				stat.close();
				conn.close();
			} 
			catch (Exception e)
			{
				// TODO
				e.printStackTrace();
			}
		}
		return roles;
	}

}
