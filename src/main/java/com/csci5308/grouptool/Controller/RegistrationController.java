package com.csci5308.grouptool.Controller;

import com.csci5308.grouptool.Interface.UserService;
import com.csci5308.grouptool.Model.UserModel;
import com.csci5308.grouptool.Repository.UserDAO;
import com.csci5308.grouptool.Security.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import com.csci5308.grouptool.Model.UserModel;
import com.csci5308.grouptool.Service.UserServiceImpl;

import java.sql.SQLException;

@Controller
public class RegistrationController {

    @PostMapping("/signup")
    public String onSubmit(@ModelAttribute("userModel") UserModel userModel, BindingResult result){
        String message="";
        UserDAO user = new UserDAO();
        Validation al = new Validation();
        if(!al.checkIfPasswordMatches(userModel)){
            message = "Password does not match";
        } else if(!al.checkBannerID(userModel)){
            message = "Provide proper Banner id";
        } else if(!al.checkEmailid(userModel)){
            message = "Email is not valid";
        } else if(al.validateIfUserExists(userModel)){
            message = "User already exists";
        } else {
            try {
                user.addDetails(userModel);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        System.out.println(message);
        return "signup";
    }

    //    public ModelAndView CheckIfUserDetailsExistElseCreate(UserModel userModel) {
//        UserService userService = new UserServiceImpl();
//        ModelAndView mv = new ModelAndView("signup");
//        if (userService.checkifuserexists(userModel)) {
//              mv.addObject("message","User Exists");
//              mv.setViewName("signup");
//        } else {
//            mv.addObject("message","User Created");
//            mv.setViewName("signup");
//        }
//         return mv;
//    }
}
