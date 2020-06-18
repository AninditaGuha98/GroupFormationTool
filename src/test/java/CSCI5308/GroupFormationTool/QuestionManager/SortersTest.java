package CSCI5308.GroupFormationTool.QuestionManager;

import CSCI5308.GroupFormationTool.QuestionManager.Model.Sorters;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SortersTest {

    @Test
    void getSortField() {
        Sorters sorters = new Sorters();
        sorters.setSortField("questionID");
        assertTrue(sorters.getSortField().equals("questionID"));
    }

    @Test
    void setSortField() {
        Sorters sorters = new Sorters();
        sorters.setSortField("questionID");
        assertTrue(sorters.getSortField().equals("questionID"));
    }

    @Test
    void getSortOrder() {
        Sorters sorters = new Sorters();
        sorters.setSortOrder("ASC");
        assertTrue(sorters.getSortOrder().equals("ASC"));
    }

    @Test
    void setSortOrder() {
        Sorters sorters = new Sorters();
        sorters.setSortOrder("ASC");
        assertTrue(sorters.getSortOrder().equals("ASC"));
    }

    @Test
    void sortingFieldList() {
        Map<String,String> sortingFields = new LinkedHashMap<>();
        sortingFields.put("question_title","Question title");
        assertTrue(sortingFields.get("question_title").equals("Question title"));
    }

    @Test
    void sortingOrderList() {
        Map<String,String> sortingOrders = new LinkedHashMap<>();
        sortingOrders.put("ASC","Ascending");
        assertTrue(sortingOrders.get("ASC").equals("Ascending"));
    }

}