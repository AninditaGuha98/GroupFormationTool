package com.csci5308.grouptool.Signup.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserModelTest {

    @Test
    void getId() {
        UserModel user = new UserModel();
        user.setId("B00123456");
        assertTrue(user.getId().equals("B00123456"));
    }

    @Test
    void setId() {
        UserModel user = new UserModel();
        user.setId("B00111222");
        assertTrue(user.getId().equals("B00111222"));
    }

    @Test
    void getFname() {
        UserModel user = new UserModel();
        user.setFname("Jazz");
        assertTrue(user.getFname().equals("Jazz"));
    }

    @Test
    void setFname() {
        UserModel user = new UserModel();
        user.setFname("Josh");
        assertTrue(user.getFname().equals("Josh"));
    }

    @Test
    void getLname() {
        UserModel user = new UserModel();
        user.setLname("Moore");
        assertTrue(user.getLname().equals("Moore"));
    }

    @Test
    void setLname() {
        UserModel user = new UserModel();
        user.setLname("Jack");
        assertTrue(user.getLname().equals("Jack"));
    }

    @Test
    void getEmail() {
        UserModel user = new UserModel();
        user.setEmail("a@gmail.com");
        assertTrue(user.getEmail().equals("a@gmail.com"));
    }

    @Test
    void setEmail() {
        UserModel user = new UserModel();
        user.setEmail("a@dal.ca");
        assertTrue(user.getEmail().equals("a@dal.ca"));
    }

    @Test
    void getPassword() {
        UserModel user = new UserModel();
        user.setPassword("qwerty");
        assertTrue(user.getPassword().equals("qwerty"));
    }

    @Test
    void setPassword() {
        UserModel user = new UserModel();
        user.setPassword("poiuyt");
        assertTrue(user.getPassword().equals("poiuyt"));
    }

    @Test
    void getConfirmPassword() {
        UserModel user = new UserModel();
        user.setConfirmPassword("qwerty");
        assertTrue(user.getConfirmPassword().equals("qwerty"));
    }

    @Test
    void setConfirmPassword() {
        UserModel user = new UserModel();
        user.setConfirmPassword("poiuyt");
        assertTrue(user.getConfirmPassword().equals("poiuyt"));
    }
}