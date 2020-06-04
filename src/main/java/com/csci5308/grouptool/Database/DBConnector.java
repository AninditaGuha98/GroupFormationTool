package com.csci5308.grouptool.Database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

public class DBConnector {
    private java.sql.Connection conn;
    private ResultSet resultSet;
    private Statement stmnt;
    InterfaceDBConfigure interfaceDBConfigure=new DBConfigure();

    public void createConnection() {
        String driver = interfaceDBConfigure.getDriver();
        String url = interfaceDBConfigure.getUrl();
        String pass = interfaceDBConfigure.getPass();
        String user = interfaceDBConfigure.getUser();

        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url, user, pass);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmnt=conn.createStatement();
        return stmnt.executeQuery(query);
    }
    public PreparedStatement executePreparedQuery(String query) throws SQLException{
        PreparedStatement pstmnt= conn.prepareStatement(query,ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
        return pstmnt;
    }
    public void execute(String query) throws SQLException {
        Statement stmnt=conn.createStatement();
        stmnt.execute(query);
    }

    public int executeUpdate(String query) throws SQLException{
        Statement stmnt = conn.createStatement();
        int rows = stmnt.executeUpdate(query);
        return rows;
    }

    public void connectionClose() throws SQLException {
        if(conn!=null) {
            conn.close();
        }

    }
}
