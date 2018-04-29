package by.epam.task3.entity;

import java.util.HashMap;
import java.util.Map;

public class Newspaper implements IGoods {
    public static final String TITLE = "TITLE";
    public static final String PERIODICITY = "PERIODICITY";
    public static final String PAID_OR_FREE = "PAID_OR_FREE";

    private String title;
    private String periodicity;
    private String paidOrFree;

    public Newspaper() {
    }

    public Newspaper(String title, String periodicity, String paidOrFree) {
        this.title = title;
        this.periodicity = periodicity;
        this.paidOrFree = paidOrFree;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getPaidOrFree() {
        return paidOrFree;
    }

    public void setPaidOrFree(String paidOrFree) {
        this.paidOrFree = paidOrFree;
    }

    @Override
    public String toString() {
        return "Newspaper : " +
                "Title=" + title +
                ", Periodicity=" + periodicity +
                ", Paid or free=" + paidOrFree
                + "\n";
    }

    @Override
    public void setValues(Map<String, Object> value) {
        for (Map.Entry<String, Object> aValue : value.entrySet()) {
            if (Newspaper.TITLE.equals(aValue.getKey().toUpperCase())) {
                setTitle(aValue.getValue().toString());
            }
            if (Newspaper.PERIODICITY.equals(aValue.getKey().toUpperCase())) {
                setPeriodicity(aValue.getValue().toString());
            }
            if (Newspaper.PAID_OR_FREE.equals(aValue.getKey().toUpperCase())) {
                setPaidOrFree(aValue.getValue().toString());
            }
        }
    }

    @Override
    public Map<String, Object> getValues() {
        Map<String, Object> map = new HashMap<>();
        map.put(TITLE, getTitle());
        map.put(PERIODICITY, getPeriodicity());
        map.put(PAID_OR_FREE, getPaidOrFree());
        return map;
    }


    public boolean isTitleContains(String value) {
        return value.isEmpty() || getTitle() != null && getTitle().equals(value);
    }

    public boolean isPeriodicityContains(String value) {
        return value.isEmpty() || getPeriodicity() != null && getPeriodicity().equals(value);
    }

    public boolean isPaidOrFreeContains(String value) {
        return value.isEmpty() || getPaidOrFree() != null && getPaidOrFree().equals(value);
    }

}