package com.csci5308.grouptool.Repository;

import com.csci5308.grouptool.Database.DBConnector;
import com.csci5308.grouptool.Model.UserModel;
import java.sql.SQLException;

public class UserDAO {

    public void addDetails(UserModel userModel) throws SQLException {
        DBConnector db = new DBConnector();
        db.createConnection();
        String query1 = String.format("Insert into Users values ('%s','%s','%s','%s','%s');",userModel.getId(), userModel.getFname(),userModel.getLname(),userModel.getEmail(),userModel.getPassword());
        String query2 = String.format("Insert into SystemRole values(5,'%s');", userModel.getId());
        System.out.println(query1);
        int a = db.executeUpdate(query1);
        int b = db.executeUpdate(query2);
        if(a>0 & b>0){
            System.out.println("Successful insert");
        }
        db.connectionClose();
    }
}
