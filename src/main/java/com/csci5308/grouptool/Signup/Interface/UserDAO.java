package com.csci5308.grouptool.Signup.Interface;

import com.csci5308.grouptool.Signup.Model.UserModel;

import java.sql.SQLException;

public interface UserDAO {
    public boolean validateUser(UserModel userModel);
    public void addUser(UserModel userModel) throws SQLException;
}
