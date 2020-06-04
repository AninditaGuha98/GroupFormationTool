package com.csci5308.grouptool.Service;

import com.csci5308.grouptool.Database.DBConnector;
import com.csci5308.grouptool.Model.UserModel;
import com.csci5308.grouptool.Security.Validation;
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

class UserValidationsImplTest {

    @InjectMocks
    DBConnector dbConnector;

    @Mock
    UserValidationsImpl userValidations;

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

        when(c.createStatement()).thenReturn(stmt);
        when(stmt.executeQuery("")).thenReturn(rs);
        when(stmt.execute(any())).thenReturn(false);
        when(userValidations.validateIfUserExists(userModel)).thenReturn(true);
    }

    @Test
    void validateIfUserExists() {
        assertTrue(userValidations.validateIfUserExists(userModel));
        Mockito.verify(userValidations).validateIfUserExists(any());
    }

    @Test
    void validateIfUserDoesntExists(){
        UserModel u = new UserModel();
        u.setId("B00987654");
        assertFalse(userValidations.validateIfUserExists(u));
        Mockito.verify(userValidations).validateIfUserExists(any());
    }

    @Test
    void checkEmailid() {
        UserModel user = new UserModel();
        user.setEmail("p@gmail.com");
        assertTrue(new UserValidationsImpl().checkEmailid(user));
        user.setEmail("asdfg");
        assertFalse(new UserValidationsImpl().checkEmailid(user));
    }

    @Test
    void checkBannerID() {
        UserModel user = new UserModel();
        user.setId("B00123456");
        assertTrue(new UserValidationsImpl().checkBannerID(user));
        user.setId("098765432");
        assertFalse(new UserValidationsImpl().checkBannerID(user));
    }

    @Test
    void checkIfPasswordMatches() {
        UserModel user = new UserModel();
        user.setPassword("qwerty");
        user.setConfirmPassword("qwerty");
        assertTrue(new UserValidationsImpl().checkIfPasswordMatches(user));
        user.setPassword("asdf");
        user.setConfirmPassword("oiuytgrfe");
        assertFalse(new UserValidationsImpl().checkIfPasswordMatches(user));
    }
}