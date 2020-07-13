package CSCI5308.GroupFormationTool.QuestionManager.Model;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SortersTest {
    ISortersFactory sortersFactory = SortersBuilder.FactorySingleton();
    Sorters sorters;

    @Test
    void getSortField() {
        sortersFactory.setSortField("questionID");
        sorters = sortersFactory.createSorters();
        assertTrue(sorters.getSortField().equals("questionID"));
    }

    @Test
    void setSortField() {
        sortersFactory.setSortField("questionID");
        sorters = sortersFactory.createSorters();
        assertTrue(sorters.getSortField().equals("questionID"));
    }

    @Test
    void getSortOrder() {
        sortersFactory.setSortOrder("ASC");
        sorters = sortersFactory.createSorters();
        assertTrue(sorters.getSortOrder().equals("ASC"));
    }

    @Test
    void setSortOrder() {
        sortersFactory.setSortOrder("ASC");
        sorters = sortersFactory.createSorters();
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