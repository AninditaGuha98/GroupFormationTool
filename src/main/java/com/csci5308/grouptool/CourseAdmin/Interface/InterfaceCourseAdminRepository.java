package com.csci5308.grouptool.CourseAdmin.Interface;

import com.csci5308.grouptool.CourseAdmin.Model.TAmodel;

import java.sql.SQLException;
import java.util.ArrayList;

public interface InterfaceCourseAdminRepository {
    boolean CheckifTAexists(TAmodel tAmodel) throws SQLException, ClassNotFoundException;
    public boolean UploadCSVtoDatabase(ArrayList<String> bannerid,ArrayList<String> firstname,ArrayList<String> lastname,int courseId);
}
