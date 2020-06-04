package com.csci5308.grouptool.CourseAdmin.Interface;

import com.csci5308.grouptool.CourseAdmin.Model.FileModel;
import com.csci5308.grouptool.CourseAdmin.Model.TAmodel;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;

public interface InterfaceCourseAdminController extends WebMvcConfigurer {
    @GetMapping("/coursepage")
    public String FrontPage(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes);

    @PostMapping("/courseadmin")
    ModelAndView DisplayPage(Model model,HttpServletRequest httpServletRequest);

    @PostMapping("/FindTA")
    ModelAndView AddTeachingAssistant(TAmodel tAmodel) throws SQLException, ClassNotFoundException;

    @PostMapping("/uploadCSV")
    ModelAndView UploadCSV(FileModel fileModel,HttpServletRequest httpServletRequest) throws IOException;
}
