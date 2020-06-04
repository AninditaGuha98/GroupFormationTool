package com.csci5308.grouptool.Database;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class DBConfigure {
   public static final String driver= "com.mysql.cj.jdbc.Driver";
    public static final String url="jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_7_TEST?serverTimezone=AST";
    public static final String user="CSCI5308_7_TEST_USER";
    public static final String pass="CSCI5308_7_TEST_7612";


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
