package com.csci5308.grouptool.CourseAdmin.Controller;

import com.csci5308.grouptool.CourseAdmin.Interface.InterfaceCourseAdminController;
import com.csci5308.grouptool.CourseAdmin.Interface.InterfaceCourseAdminServices;
import com.csci5308.grouptool.CourseAdmin.Model.FileModel;
import com.csci5308.grouptool.CourseAdmin.Model.TAmodel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

@Controller
public class CourseAdminController implements InterfaceCourseAdminController {
    @Autowired
    private InterfaceCourseAdminServices interfaceCourseAdminServices;
    @Autowired
    TAmodel tAmodel;
    @Autowired
    FileModel fileModel;

    int courseId;
    int userId;


    @Override
    @GetMapping("/coursepage")
    public String FrontPage(HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes) {
        try{
            Map<String, ?> attribute= RequestContextUtils.getInputFlashMap(httpServletRequest);
            assert attribute != null;
            userId= (Integer) attribute.get("userId");
            courseId=(Integer) attribute.get("courseId");
        }
        catch (Exception ignored){
        }
        courseId=2;
        userId=10;
        redirectAttributes.addFlashAttribute("userId", userId);
        redirectAttributes.addFlashAttribute("courseId", courseId);
        return "coursepageinst";
    }

    @Override
    @PostMapping("/courseadmin")
    public ModelAndView DisplayPage(Model model,HttpServletRequest httpServletRequest) {
        try{
            Map<String, ?> attribute= RequestContextUtils.getInputFlashMap(httpServletRequest);
            assert attribute != null;
            userId= (Integer) attribute.get("userId");
            courseId=(Integer) attribute.get("courseId");
        }
        catch (Exception ignored){
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("tAmodel", tAmodel);
        mv.addObject("fileModel", fileModel);
        mv.setViewName("courseadmin");
        return mv;
    }

    @Override
    @PostMapping("/findTA")
    public ModelAndView AddTeachingAssistant(TAmodel tAmodel) throws SQLException, ClassNotFoundException {
        ModelAndView mv = new ModelAndView();
        interfaceCourseAdminServices.CheckTAexistence(tAmodel);
        mv.addObject("tAmodel", tAmodel);
        mv.addObject("fileModel", fileModel);
        mv.setViewName("courseadmin");
        return mv;
    }

    @Override
    @PostMapping("/uploadCSV")
    public ModelAndView UploadCSV(FileModel fileModel, HttpServletRequest httpServletRequest) throws IOException {
        try{
            Map<String, ?> attribute= RequestContextUtils.getInputFlashMap(httpServletRequest);
            assert attribute != null;
            userId=(Integer) attribute.get("userId");
            courseId= (Integer) attribute.get("courseID");
        }
        catch (Exception ignored){}
        ModelAndView mv=new ModelAndView();
        interfaceCourseAdminServices.CSVReader(fileModel,courseId);
        fileModel.setFile(null);
        mv.addObject("fileModel", fileModel);
        mv.addObject("tAmodel", tAmodel);
        mv.setViewName("courseadmin");
        return mv;
    }
}

