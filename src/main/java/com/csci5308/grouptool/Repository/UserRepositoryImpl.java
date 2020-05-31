package com.csci5308.grouptool.Repository;

import com.csci5308.grouptool.Interface.ConnectDB;
import com.csci5308.grouptool.Model.UserModel;

public class UserRepositoryImpl {

    public boolean matchfname(UserModel userModel){
        return "Anindita".equals(userModel.getfname());
    }
}
