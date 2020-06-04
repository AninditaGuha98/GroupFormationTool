package com.csci5308.grouptool.Database;

import org.junit.jupiter.api.AfterEach;
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
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;

class DBConnectorTest {
//    @InjectMocks
//    private DBConnector dbConnection;

    @Mock
    private DBConnector dbConnection;

    @Mock
    private Connection mockConnection;

    @Mock private Statement mockStatement;

    @Mock
    private ResultSet rs;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
        Mockito.when(dbConnection.executeQuery("")).thenReturn(rs);
        Mockito.when(mockConnection.createStatement().execute(Mockito.any())).thenReturn(false);
    }

    @AfterEach
    public void validate() {
        validateMockitoUsage();
    }

    @Test
    void createConnection() throws SQLException {
        dbConnection.createConnection();
        Mockito.verify(dbConnection).createConnection();

    }
}