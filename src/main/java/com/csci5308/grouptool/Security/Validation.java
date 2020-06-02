package com.csci5308.grouptool.Security;

import com.csci5308.grouptool.Database.DBConnector;
import com.csci5308.grouptool.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Validation {

    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean validateIfUserExists(UserModel userModel){
        boolean value = false;
        DBConnector db = new DBConnector();
        db.createConnection();
        String query = String.format("select bannerID from Users where bannerID= '%S';",userModel.getId());
        System.out.println(query);
        try {
            ResultSet result = db.executeQuery(query);
            value = result.next();
            db.connectionClose();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return value;
    }

    public boolean checkEmailid(UserModel userModel){
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return userModel.getEmail().matches(regex);
    }

    public boolean checkBannerID(UserModel userModel){
        String id = userModel.getId();
        return id.substring(0, 3).equals("B00") && id.length() == 9;
    }

    public boolean checkIfPasswordMatches(UserModel userModel){
        return userModel.getPassword().equals(userModel.getConfirmPassword());
    }
}

