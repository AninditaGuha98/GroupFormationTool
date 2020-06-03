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
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;

@Controller
public class RegistrationController implements WebMvcConfigurer {

    @PostMapping("/signup")
    public ModelAndView onSubmit(ModelAndView modelAndView, @ModelAttribute("userModel") UserModel userModel, BindingResult result){
    //    ModelAndView mv = new ModelAndView("signup");
        UserDAO user = new UserDAO();
        Validation al = new Validation();
        if(!al.checkIfPasswordMatches(userModel)){
            userModel.setMessage("Password does not match");
        } else if(!al.checkBannerID(userModel)){
            userModel.setMessage("Provide proper Banner id");
        } else if(!al.checkEmailid(userModel)){
            userModel.setMessage("Email is not valid");
        } else if(al.validateIfUserExists(userModel)){
            userModel.setMessage("User already exists");
        } else {
            try {
                userModel.setMessage(user.addDetails(userModel)? "You have registered successfully" : "Registration fail");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        System.out.println(userModel.getMessage());
        modelAndView.addObject("message",userModel.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
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
