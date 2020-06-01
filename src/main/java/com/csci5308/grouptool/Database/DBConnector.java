package com.csci5308.grouptool.Database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DBConnector {
    private java.sql.Connection conn;
    private ResultSet resultSet;
    private Statement stmnt;
    DBConfigure dbConfigure=new DBConfigure();

    public void createConnection() {
        String driver = dbConfigure.getDriver();
        String url = dbConfigure.getUrl();
        String pass = dbConfigure.getPass();
        String user = dbConfigure.getUser();

        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url, user, pass);
        }
        catch (Exception ignored){

        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmnt=conn.createStatement();
        ResultSet result = stmnt.executeQuery(query);
        while(result.next()) {
            System.out.println(result.getRow());
        }
        return result ;
    }
    public void execute(String query) throws SQLException {
        Statement stmnt=conn.createStatement();
        stmnt.execute(query);
    }

    public void connectionClose() throws SQLException {
        if(conn!=null) {
            conn.close();
        }
    }
}
