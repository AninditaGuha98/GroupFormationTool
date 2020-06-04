package com.csci5308.grouptool.Signup.Repository;

import com.csci5308.grouptool.Database.DBConnector;
import com.csci5308.grouptool.Signup.Model.UserModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class UserDAOImplTest {
    @InjectMocks
    DBConnector dbConnector;

    @Mock
    UserDAOImpl userDAO;

    @Mock
    private Connection c;

    @Mock
    private Statement stmt;

    @Mock
    private ResultSet rs;

    private UserModel userModel;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        assertNotNull(dbConnector);

        userModel = new UserModel();
        userModel.setId("B00123456");
        userModel.setFname("Jazz");
        userModel.setLname("Josh");
        userModel.setEmail("jj@gmail.com");
        userModel.setPassword("qwerty");

        when(c.createStatement()).thenReturn(stmt);
        when(stmt.executeUpdate(Mockito.any())).thenReturn(1);
        when(stmt.execute(any())).thenReturn(false);
    }

    @Test
    void validateUser() throws SQLException {
        userDAO.addUser(userModel);
        Mockito.verify(userDAO).addUser(userModel);
    }
}