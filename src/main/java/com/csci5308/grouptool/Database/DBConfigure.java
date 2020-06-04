package com.csci5308.grouptool.Database;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


public class DBConfigure implements InterfaceDBConfigure {

    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_7_TEST?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user="CSCI5308_7_TEST_USER";
    String pass="CSCI5308_7_TEST_7612";

    @Override
    public String getDriver() {
        return driver;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPass() {
        return pass;
    }
}
