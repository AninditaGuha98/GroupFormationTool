package com.csci5308.grouptool.Database;

import java.sql.*;
import java.util.*;

public class ConnectDB {

    public void DevBranchDB(String[] args) throws ClassNotFoundException{
        Connection con=null;
        Statement stmnt=null;
        ResultSet result=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306", "CSCI5308_7_DEVINT_USER","CSCI5308_7_DEVINT_7061");
            stmnt=con.createStatement();
            stmnt.execute("use CSCI5308_7_DEVINT;");
            result=stmnt.executeQuery("show tables;");

            while(result.next()){
                System.out.println(result);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
