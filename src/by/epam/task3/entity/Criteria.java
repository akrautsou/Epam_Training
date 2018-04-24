package by.epam.task3.entity;

import java.util.HashMap;
import java.util.Map;

public class Criteria {

    private String type;
    private Map<String, Object> criteria = new HashMap<>();

    public Criteria(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public Map<String, Object> getCriteria() {
        return criteria;
    }

    public void add(String searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

}