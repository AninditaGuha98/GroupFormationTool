package com.csci5308.grouptool.SecurityTest;

import com.csci5308.grouptool.Model.UserModel;
import com.csci5308.grouptool.Security.Validation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {

    @Test
    void validateIfUserExists() {
    }

    @Test
    void checkEmailid() {
        UserModel user = new UserModel();
        user.setEmail("p@gmail.com");
        assertTrue(new Validation().checkEmailid(user));
        user.setEmail("asdfg");
        assertFalse(new Validation().checkEmailid(user));
    }

    @Test
    void checkBannerID() {
        UserModel user = new UserModel();
        user.setId("B00123456");
        assertTrue(new Validation().checkBannerID(user));
        user.setId("098765432");
        assertFalse(new Validation().checkBannerID(user));
    }

    @Test
    void checkIfPasswordMatches() {
        UserModel user = new UserModel();
        user.setPassword("qwerty");
        user.setConfirmPassword("qwerty");
        assertTrue(new Validation().checkIfPasswordMatches(user));
        user.setPassword("asdf");
        user.setConfirmPassword("oiuytgrfe");
        assertFalse(new Validation().checkIfPasswordMatches(user));
    }
}