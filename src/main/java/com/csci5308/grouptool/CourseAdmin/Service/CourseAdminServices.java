package com.csci5308.grouptool.CourseAdmin.Service;


import com.csci5308.grouptool.CourseAdmin.Interface.InterfaceCourseAdminRepository;
import com.csci5308.grouptool.CourseAdmin.Interface.InterfaceCourseAdminServices;
import com.csci5308.grouptool.CourseAdmin.Model.FileModel;
import com.csci5308.grouptool.CourseAdmin.Model.TAmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;

@Service
public class CourseAdminServices implements InterfaceCourseAdminServices {
    ArrayList<String> bannerid=new ArrayList<>();
    ArrayList<String> firstname=new ArrayList<>();
    ArrayList<String> lastname=new ArrayList<>();


    @Autowired
    private InterfaceCourseAdminRepository interfaceCourseAdminRepository;

    @Override
    public void CheckTAexistence(TAmodel tAmodel) throws SQLException, ClassNotFoundException {
        if(!interfaceCourseAdminRepository.CheckifTAexists(tAmodel)){
            tAmodel.setTaMessage("Incorrect Fields. Please Check the details");
        }
        else{
            String courseid = tAmodel.getCourseid();
            tAmodel.setTaMessage("User added as Teaching Assistant for the course "+courseid);
        }
    }

    @Override

    public void CSVReader(FileModel fileModel,int courseId) throws IOException {
        try {
            String line;
            boolean flag = true;
            MultipartFile filecontent = fileModel.getFile();
            InputStream inputstream = filecontent.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream));
            while ((line = bufferedReader.readLine()) != null) {
                if (flag) {
                    flag = false;
                    continue;
                }
                String[] words = line.split(",");
                bannerid.add(words[0]);
                firstname.add(words[1]);
                lastname.add(words[2]);
            }
            boolean checkFlag = interfaceCourseAdminRepository.UploadCSVtoDatabase(bannerid, firstname, lastname, courseId);
            if (checkFlag) {
                fileModel.setFileMessage("Upload successful");
            } else {
                fileModel.setFileMessage("Upload unsuccessful, Please try again");
            }
        }
        catch (Exception e){
            fileModel.setFileMessage("Upload unsuccessful, Please upload csv file");
        }
        System.out.println(fileModel.getFileMessage());
    }


}
