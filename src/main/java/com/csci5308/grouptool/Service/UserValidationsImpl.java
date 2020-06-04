package com.csci5308.grouptool.Service;

import com.csci5308.grouptool.Database.DBConnector;
import com.csci5308.grouptool.Interface.IUserValidations;
import com.csci5308.grouptool.Model.UserModel;
import com.csci5308.grouptool.Security.Encryption_Decryption;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserValidationsImpl implements IUserValidations {
    public boolean validateIfUserExists(UserModel userModel){
        boolean value = false;
        DBConnector db = new DBConnector();
        db.createConnection();
        String query = String.format("select bannerID from Users where bannerID= '%S';",userModel.getId());
        System.out.println(query);
        try {
            db.execute("use CSCI5308_7_DEVINT;");
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
        Encryption_Decryption encryptionDecryption = new Encryption_Decryption();
        BCryptPasswordEncoder passwordEncoder =(BCryptPasswordEncoder) encryptionDecryption.passwordEncoder();
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return passwordEncoder.matches(userModel.getConfirmPassword(),userModel.getPassword());
    }
}
