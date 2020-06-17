package CSCI5308.GroupFormationTool.QuestionManager.Model;

import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class Sorters {
    private String sortField;
    private String sortOrder;

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Map<String,String> sortingFieldList(){
        Map<String,String> sortingFields = new LinkedHashMap<>();
        sortingFields.put("question_title","Question title");
        sortingFields.put("date_created","Date created");
        return sortingFields;
    }

    public Map<String,String> sortingOrderList(){
        Map<String,String> sortingOrders = new LinkedHashMap<>();
        sortingOrders.put("ASC","Ascending");
        sortingOrders.put("DESC","Desceding");
        return sortingOrders;
    }

}
