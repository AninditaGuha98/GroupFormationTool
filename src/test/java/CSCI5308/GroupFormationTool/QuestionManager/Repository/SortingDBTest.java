package CSCI5308.GroupFormationTool.QuestionManager.Repository;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.Model.*;
import CSCI5308.GroupFormationTool.QuestionManager.Services.SortingDB;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.when;

class SortingDBTest {
    @Mock
    CallStoredProcedure procedure;

    @Mock
    ResultSet rs;

    @Mock
    private SortingDB sortingDB;
    private IQuestionFactory questionFactory;
    private ISortersFactory sortersFactory;
    private Sorters sorters;
    String bannerID;
    List<QuestionModel> questionList = new ArrayList<>();

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        assertNotNull(procedure);

        questionFactory = QuestionModelBuilder.FactorySingleton();
        sortersFactory= SortersBuilder.FactorySingleton();
        sortersFactory.setSortField("question_title");
        sortersFactory.setSortOrder("ASC");
        sorters = sortersFactory.createSorters();
        bannerID = "B999999";
        questionFactory.setQuestionTitle("Skills");
        QuestionModel q1 = questionFactory.createQuestionModel();
        questionFactory.setQuestionTitle("Credits");
        QuestionModel q2 = questionFactory.createQuestionModel();
        questionList.add(q1);
        questionList.add(q2);
        Collections.sort(questionList, Comparator.comparing(QuestionModel::getQuestionTitle));

        when(procedure.executeWithResults()).thenReturn(rs);
        when(sortingDB.sort(bannerID, sorters)).thenReturn(questionList);

        questionFactory.setQuestionTitle("Project");
        QuestionModel q3 = questionFactory.createQuestionModel();
        questionList.add(q3);
        when(sortingDB.clearSort(bannerID)).thenReturn(questionList);

    }

    @AfterEach
    void tearDown() {
        validateMockitoUsage();
    }

    @Test
    void sort() {
        assertEquals(sortingDB.sort(bannerID, sorters),questionList);
        Mockito.verify(sortingDB).sort(bannerID, sorters);
    }

    @Test
    void clearSort() {
        assertEquals(sortingDB.clearSort(bannerID),questionList);
        Mockito.verify(sortingDB).clearSort(bannerID);
    }
}