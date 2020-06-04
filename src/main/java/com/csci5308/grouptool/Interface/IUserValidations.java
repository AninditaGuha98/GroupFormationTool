package com.csci5308.grouptool.Interface;

import com.csci5308.grouptool.Model.UserModel;

public interface IUserValidations {
    public boolean validateIfUserExists(UserModel userModel);
    public boolean checkEmailid(UserModel userModel);
    public boolean checkBannerID(UserModel userModel);
    public boolean checkIfPasswordMatches(UserModel userModel);
}
