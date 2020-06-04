package com.csci5308.grouptool.Signup.Repository;

import com.csci5308.grouptool.Database.DBConnector;
import com.csci5308.grouptool.Signup.Interface.IUserValidations;
import com.csci5308.grouptool.Signup.Interface.UserDAO;
import com.csci5308.grouptool.Signup.Model.UserModel;
import com.csci5308.grouptool.Signup.Service.UserValidationsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class UserDAOImpl implements UserDAO {

    public boolean validateUser(UserModel userModel){
        boolean validated = true;
        IUserValidations userValidations = new UserValidationsImpl();
        if(!userValidations.checkIfPasswordMatches(userModel)){
            userModel.setMessage("Password does not match");
            validated = false;
        } else if(!userValidations.checkBannerID(userModel)){
            userModel.setMessage("Provide proper Banner id");
            validated = false;
        } else if(!userValidations.checkEmailid(userModel)){
            userModel.setMessage("Email is not valid");
            validated = false;
        } else if(userValidations.validateIfUserExists(userModel)){
            userModel.setMessage("User already exists");
            validated = false;
        }
        return validated;
    }

    public void addUser(UserModel userModel) throws SQLException {
        DBConnector db = new DBConnector();
        db.createConnection();
//        db.execute("use CSCI5308_7_TEST;");
        String query1 = String.format("Insert into Users values ('%s','%s','%s','%s','%s');",userModel.getId(), userModel.getFname(),userModel.getLname(),userModel.getEmail(),userModel.getPassword());
        String query2 = String.format("Insert into SystemRole values(5,'%s');", userModel.getId());
        int a = db.executeUpdate(query1);
        int b = db.executeUpdate(query2);
        db.connectionClose();
        userModel.setMessage(a>0 & b>0? "You have registered successfully" : "Registration fail");
    }
}
