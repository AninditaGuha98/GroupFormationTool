package com.csci5308.grouptool.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DBConnector {
    private static DBConfigure dbConfiguration;
    private java.sql.Connection conn;
    private ResultSet resultSet;
    private Statement stmnt;

    DBConfigure dbConfigure = new DBConfigure();

    public void createConnection() {
        String driver = dbConfigure.getDriver();
        String url = dbConfigure.getUrl();
        String pass = dbConfigure.getPass();
        String user = dbConfigure.getUser();

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
        ResultSet result = stmnt.executeQuery(query);
        return result ;
    }

    public int executeUpdate(String query) throws SQLException{
        Statement stmnt = conn.createStatement();
        int rows = stmnt.executeUpdate(query);
        return rows;
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
