package com.csci5308.grouptool.CourseAdmin.Repository;

import com.csci5308.grouptool.CourseAdmin.Interface.InterfaceCourseAdminRepository;
import com.csci5308.grouptool.CourseAdmin.Model.TAmodel;
import com.csci5308.grouptool.Database.DBConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseAdminRepository implements InterfaceCourseAdminRepository {
    int courseid;

    @Override
    public boolean CheckifTAexists(TAmodel tAmodel) throws SQLException, ClassNotFoundException {
        DBConnector dbConnector=new DBConnector();
        dbConnector.createConnection();
        try{
            PreparedStatement pstmnt =dbConnector.executePreparedQuery("select * from Users where bannerID=?");
            pstmnt.setString(1,tAmodel.getBannerid());
            ResultSet resultSet=pstmnt.executeQuery();
            if (!resultSet.next()){
                dbConnector.connectionClose();
                return false;
            }
            else {
                PreparedStatement preparedStatement=dbConnector.executePreparedQuery("select courseID from Courses where courseCode=?");
                preparedStatement.setString(1,tAmodel.getCourseid());
                ResultSet rslt=preparedStatement.executeQuery();
                if (!rslt.next()) {
                    dbConnector.connectionClose();
                    return false;
                }
                else{
                    rslt.first();
                    rslt.beforeFirst();
                    while(rslt.next()){
                        courseid = rslt.getInt("courseID");
                    }
                    PreparedStatement preparedStatement1=dbConnector.executePreparedQuery("insert into CourseRole values(?,1,?);");
                    preparedStatement1.setInt(1,courseid);
                    preparedStatement1.setString(2,tAmodel.getBannerid());
                    preparedStatement1.execute();
                }
            }
        }
        catch (Exception ignored){
            return false;
        }
        dbConnector.connectionClose();
        return true;
    }

    public boolean UploadCSVtoDatabase(ArrayList<String> bannerid,ArrayList<String> firstname,ArrayList<String> lastname,int courseid){
        DBConnector dbConnector=new DBConnector();
        dbConnector.createConnection();
        try{
            for(int i=0; i<bannerid.size();i++){
                PreparedStatement preparedStatement=dbConnector.executePreparedQuery("select * from Users where bannerID=?");
                preparedStatement.setString(1,bannerid.get(i));
                ResultSet resultSet=preparedStatement.executeQuery();
                resultSet.beforeFirst();
                if(!resultSet.next()){
                    PreparedStatement preparedStatement1=dbConnector.executePreparedQuery("insert into Users values(?,?,?,\"\",\"\")");
                    preparedStatement1.setString(1,bannerid.get(i));
                    preparedStatement1.setString(2,firstname.get(i));
                    preparedStatement1.setString(3,lastname.get(i));
                    preparedStatement1.execute();
                }
                try{
                    PreparedStatement preparedStatement3=dbConnector.executePreparedQuery("select * from CourseRole where courseID=? and bannerID=?");
                    preparedStatement3.setInt(1,courseid);
                    preparedStatement3.setString(2,bannerid.get(i));
                    ResultSet rslt=preparedStatement3.executeQuery();
                    rslt.beforeFirst();
                    if(!rslt.next()) {
                        PreparedStatement preparedStatement2 = dbConnector.executePreparedQuery("insert into CourseRole values(?,4,?)");
                        preparedStatement2.setInt(1, courseid);
                        preparedStatement2.setString(2, bannerid.get(i));
                        preparedStatement2.execute();
                    }
                }
                catch (Exception e){
                    return false;
                }
            }
            dbConnector.connectionClose();
            return true;
        }

        catch (Exception ignored){
            return false;
        }
    }
}
