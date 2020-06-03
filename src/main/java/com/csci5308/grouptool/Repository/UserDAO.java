package com.csci5308.grouptool.Repository;

import com.csci5308.grouptool.Database.DBConnector;
import com.csci5308.grouptool.Model.UserModel;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UserDAO {

    public boolean addDetails(UserModel userModel) throws SQLException {
        DBConnector db = new DBConnector();
        db.createConnection();
        db.execute("use CSCI5308_7_DEVINT;");
        String query1 = String.format("Insert into Users values ('%s','%s','%s','%s','%s');",userModel.getId(), userModel.getFname(),userModel.getLname(),userModel.getEmail(),userModel.getPassword());
        String query2 = String.format("Insert into SystemRole values(5,'%s');", userModel.getId());
        int a = db.executeUpdate(query1);
        int b = db.executeUpdate(query2);
        db.connectionClose();
        return a>0 & b>0;
    }
}
