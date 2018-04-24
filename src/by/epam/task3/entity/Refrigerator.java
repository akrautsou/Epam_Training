package by.epam.task3.entity;

import by.epam.task3.core.Parser;

import java.util.Map;

public class Refrigerator implements IGoods {
    public static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    public static final String WEIGHT = "WEIGHT";
    public static final String FREEZER_CAPACITY = "FREEZER_CAPACITY";
    public static final String OVERALL_CAPACITY = "OVERALL_CAPACITY";
    public static final String HEIGHT = "HEIGHT";
    public static final String WIDTH = "WIDTH";
    private Double powerConsumption;
    private Double weight;
    private Double freezerCapacity;
    private Double overallCapacity;
    private Double height;
    private Double width;

    public Refrigerator() {
    }

    public Refrigerator(Double powerConsumption, Double weight, Double freezerCapacity, Double overallCapacity, Double height, Double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.freezerCapacity = freezerCapacity;
        this.overallCapacity = overallCapacity;
        this.height = height;
        this.width = width;
    }

    public Double getPowerConsumption() {
        return powerConsumption;
    }

    private void setPowerConsumption(Double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Double getWeight() {
        return weight;
    }

    private void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getFreezerCapacity() {
        return freezerCapacity;
    }

    private void setFreezerCapacity(Double freezerCapacity) {
        this.freezerCapacity = freezerCapacity;
    }

    public Double getOverallCapacity() {
        return overallCapacity;
    }

    private void setOverallCapacity(Double overallCapacity) {
        this.overallCapacity = overallCapacity;
    }

    public Double getHeight() {
        return height;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    private void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Refrigerator : " +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width
                + "\n";
    }

    @Override
    public void setValues(Map<String, Object> value) {
        for (Map.Entry<String, Object> aValue: value.entrySet()) {
            if (Refrigerator.POWER_CONSUMPTION.equals(aValue.getKey().toUpperCase())) {
                setPowerConsumption(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Refrigerator.WEIGHT.equals(aValue.getKey().toUpperCase())) {
                setWeight(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Refrigerator.FREEZER_CAPACITY.equals(aValue.getKey().toUpperCase())) {
                setFreezerCapacity(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Refrigerator.OVERALL_CAPACITY.equals(aValue.getKey().toUpperCase())) {
                setOverallCapacity(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Refrigerator.HEIGHT.equals(aValue.getKey().toUpperCase())) {
                setHeight(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Refrigerator.WIDTH.equals(aValue.getKey().toUpperCase())) {
                setWidth(Double.parseDouble(aValue.getValue().toString()));
            }
        }
    }

    public boolean isPowerConsumptionContains(String value) {
        return value.isEmpty() || getPowerConsumption() != null && getPowerConsumption() >= Double.valueOf(value);
    }

    public boolean isFreezerCapacityContains(String value) {
        return value.isEmpty() || getFreezerCapacity() != null && getFreezerCapacity() >= Double.valueOf(value);
    }

    public boolean isWeightContains(String value) {
        return value.isEmpty() || getWeight() != null && getWeight() <= Double.valueOf(value);
    }

    public boolean isOverallCapacityContains(String value) {
        return value.isEmpty() || getOverallCapacity() != null && getOverallCapacity() >= Double.valueOf(value);
    }

    public boolean isHeightContains(String value) {
        return value.isEmpty() || getHeight() != null && getHeight() <= Double.valueOf(value);
    }

    public boolean isWidthContains(String value) {
        return value.isEmpty() || getWidth() != null && getWidth() <= Double.valueOf(value);
    }
}
