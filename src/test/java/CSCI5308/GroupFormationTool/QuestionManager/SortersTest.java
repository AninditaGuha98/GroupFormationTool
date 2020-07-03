package CSCI5308.GroupFormationTool.QuestionManager;

import CSCI5308.GroupFormationTool.QuestionManager.InterfaceSorters;
import CSCI5308.GroupFormationTool.QuestionManager.Sorters;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SortersTest {

    @Test
    void getSortField() {
        InterfaceSorters interfaceSorters = new Sorters();
        interfaceSorters.setSortField("questionID");
        assertTrue(interfaceSorters.getSortField().equals("questionID"));
    }

    @Test
    void setSortField() {
        InterfaceSorters interfaceSorters = new Sorters();
        interfaceSorters.setSortField("questionID");
        assertTrue(interfaceSorters.getSortField().equals("questionID"));
    }

    @Test
    void getSortOrder() {
        InterfaceSorters interfaceSorters = new Sorters();
        interfaceSorters.setSortOrder("ASC");
        assertTrue(interfaceSorters.getSortOrder().equals("ASC"));
    }

    @Test
    void setSortOrder() {
        InterfaceSorters interfaceSorters = new Sorters();
        interfaceSorters.setSortOrder("ASC");
        assertTrue(interfaceSorters.getSortOrder().equals("ASC"));
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