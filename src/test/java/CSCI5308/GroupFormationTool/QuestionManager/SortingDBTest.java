package CSCI5308.GroupFormationTool.QuestionManager;

import CSCI5308.GroupFormationTool.Database.CallStoredProcedure;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Question;
import CSCI5308.GroupFormationTool.QuestionManager.Model.Sorters;
import CSCI5308.GroupFormationTool.QuestionManager.Repository.SortingDB;
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
    private ResultSet rs;

    @Mock
    private SortingDB sortingDB;

    private Sorters sorters;
    String bannerID;
    List<Question> questionList = new ArrayList<>();

    @BeforeEach
    void setUp() throws SQLException {
        MockitoAnnotations.initMocks(this);
        assertNotNull(procedure);

        sorters = new Sorters();
        sorters.setSortField("question_title");
        sorters.setSortOrder("ASC");
        bannerID = "B999999";
        Question q1 = new Question();
        Question q2 = new Question();
        q1.setQuestionTitle("Skills");
        q2.setQuestionTitle("Credits");
        questionList.add(q1);
        questionList.add(q2);
        Collections.sort(questionList, Comparator.comparing(Question::getQuestionTitle));

        when(procedure.executeWithResults()).thenReturn(rs);
        when(sortingDB.sort(bannerID,sorters)).thenReturn(questionList);

        Question q3 = new Question();
        q3.setQuestionTitle("Project");
        questionList.add(q3);
        when(sortingDB.clearSort(bannerID)).thenReturn(questionList);

    }

    @AfterEach
    void tearDown() {
        validateMockitoUsage();
    }

    @Test
    void sort() {
        assertEquals(sortingDB.sort(bannerID,sorters),questionList);
        Mockito.verify(sortingDB).sort(bannerID,sorters);
    }

    @Test
    void clearSort() {
        assertEquals(sortingDB.clearSort(bannerID),questionList);
        Mockito.verify(sortingDB).clearSort(bannerID);
    }
}