package com.csci5308.grouptool.CourseAdmin.Interface;

import com.csci5308.grouptool.CourseAdmin.Model.FileModel;
import com.csci5308.grouptool.CourseAdmin.Model.TAmodel;

import java.io.IOException;
import java.sql.SQLException;

public interface InterfaceCourseAdminServices {
    void CheckTAexistence(TAmodel tAmodel) throws SQLException, ClassNotFoundException;
    void CSVReader(FileModel fileModel, int courseId) throws IOException;
}