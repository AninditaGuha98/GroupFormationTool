package CSCI5308.GroupFormationTool.GroupFormationAlgorithmTest;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.SurveyResponses.SurveyResultDB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SurveyResultDBTest {
    @Mock
    CallStoredProcedure procedure;

    @Mock
    ResultSet rs;

    @Mock
    private SurveyResultDB surveyResultDB;

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        assertNotNull(procedure);
        when(procedure.executeWithResults()).thenReturn(rs);
        when(surveyResultDB.checkIfResponseSubmitted(19,1)).thenReturn(true);
        when(surveyResultDB.checkIfResponseSubmitted(19,2)).thenReturn(false);
        when(surveyResultDB.submitSurveyResponse(22,1,69,"Three")).thenReturn(true);
        when(surveyResultDB.submitSurveyResponse(22,1,50,"Java")).thenReturn(false);
    }

    @Test
    void checkIfResponseSubmitted() {
        assertTrue(surveyResultDB.checkIfResponseSubmitted(19,1));
        assertFalse(surveyResultDB.checkIfResponseSubmitted(19,2));
    }

    @Test
    void submitSurveyResponse() {
        assertTrue(surveyResultDB.submitSurveyResponse(22,1,69,"Three"));
        assertFalse(surveyResultDB.submitSurveyResponse(22,1,50,"Java"));
    }
}