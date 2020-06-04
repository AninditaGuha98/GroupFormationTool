package com.csci5308.grouptool.Signup.Controller;

import com.csci5308.grouptool.Signup.Interface.UserDAO;
import com.csci5308.grouptool.Signup.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;

@Controller
public class RegistrationController implements WebMvcConfigurer {
    @Autowired
    UserDAO userDAO;

    @PostMapping("/signup")
    public ModelAndView onSubmit(ModelAndView modelAndView, @ModelAttribute("userModel") UserModel userModel, BindingResult result){
        if(userDAO.validateUser(userModel)){
            try {
                userDAO.addUser(userModel);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        modelAndView.addObject("message",userModel.getMessage());
        modelAndView.setViewName("homeredirect");
        return modelAndView;
    }
}
