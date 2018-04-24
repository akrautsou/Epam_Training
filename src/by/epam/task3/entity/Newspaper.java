package by.epam.task3.entity;

import by.epam.task3.core.Parser;

import java.util.Map;

public class Newspaper implements IGoods {
    public static final String TITLE = "TITLE";
    public static final String PERIODICITY = "PERIODICITY";
    public static final String PAID_OR_FREE = "PAIDORFREE";

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

    private void setTitle(String title) {
        this.title = title;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    private void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    public String getPaidOrFree() {
        return paidOrFree;
    }

    private void setPaidOrFree(String paidOrFree) {
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
        for (Map.Entry<String, Object> aValue: value.entrySet()) {
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