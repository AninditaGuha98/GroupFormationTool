package com.csci5308.grouptool.Database;

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

class DBConnectorTest {
    @InjectMocks
    private DBConnector dbConnection;
    @Mock
    private Connection mockConnection;
    @Mock private Statement mockStatement;

    @Mock
    private ResultSet rs;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createConnection() throws SQLException {
        Mockito.when(mockConnection.createStatement()).thenReturn(mockStatement);
        Mockito.when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
        Mockito.when(dbConnection.executeQuery("")).thenReturn(rs);
        Mockito.when(mockConnection.createStatement().execute(Mockito.any())).thenReturn(false);
        Mockito.verify(mockConnection.createStatement(), Mockito.times(1));
    }
}