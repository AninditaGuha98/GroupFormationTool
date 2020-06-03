package com.csci5308.grouptool.Database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DBConfigure {
    public static final String driver="com.mysql.cj.jdbc.Driver";
    public static final String url="jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_7_DEVINT?serverTimezone=UTC";
    public static final String user="CSCI5308_7_DEVINT_USER";
    public static final String pass="CSCI5308_7_DEVINT_7061";


    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
}
