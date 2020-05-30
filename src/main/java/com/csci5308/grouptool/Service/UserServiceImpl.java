package com.csci5308.grouptool.Service;

import com.csci5308.grouptool.Interface.UserService;
import com.csci5308.grouptool.Model.UserModel;
import com.csci5308.grouptool.Repository.UserRepositoryImpl;
import org.springframework.stereotype.Service;



@Service

public class UserServiceImpl implements UserService{

    public boolean checkifuserexists(UserModel userModel){
        UserRepositoryImpl userRepository= new UserRepositoryImpl();
        return userRepository.matchfname(userModel);

    }
}
