package com.csci5308.grouptool.Controller;

import com.csci5308.grouptool.Interface.UserService;
import com.csci5308.grouptool.Model.UserModel;
import com.csci5308.grouptool.Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.naming.Binding;

@Controller
public class MainController implements WebMvcConfigurer {

//    @GetMapping("/index")
//    public String FrontPage(UserModel userModel){
//        return "index";
//    }

    @GetMapping("/")
    public String showSignup(Model model){
        model.addAttribute("userModel", new UserModel());
        return "signup";
    }
}
