package com.csci5308.grouptool.CourseAdmin.Model;
import org.springframework.stereotype.Component;

@Component
public class TAmodel {


    private String bannerid;
    private String courseid;

    private String TaMessage;

    public String getTaMessage() {
        return TaMessage;
    }

    public void setTaMessage(String taMessage) {
        TaMessage = taMessage;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }



    public String getBannerid() {
        return bannerid;
    }

    public void setBannerid(String bannerid) {
        this.bannerid = bannerid;
    }
}
