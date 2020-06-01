package com.csci5308.grouptool.util;

import java.sql.Connection; 
import java.sql.DriverManager; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConnection {
	 private static Connection con ; 
	@Autowired
	 static DBConfiguration dbConfiguration ;
 
	    public static Connection getConnection() 
	    {     	
	        try { 
	        	System.out.println("check:"+dbConfiguration.getPassword());
	        //	Class.forName(dbConfiguration.getDriver()).getClass(); 
	        	System.out.println("check:"+dbConfiguration.getUrl());
	        	System.out.println("check:"+dbConfiguration.getUsername());
	        	System.out.println("check:"+dbConfiguration.getPassword());
	            con = DriverManager.getConnection(dbConfiguration.getUrl(), dbConfiguration.getUsername(), dbConfiguration.getPassword()); 
	        } 
	        catch (Exception e) { 
	        	System.out.println(e.getMessage());
	            con = null;
	        	
       } 
	        return con; 
    } 
	    
	    private DatabaseConnection(DBConfiguration dbConfiguration) {
	    	DatabaseConnection.dbConfiguration = dbConfiguration;
		}

}
