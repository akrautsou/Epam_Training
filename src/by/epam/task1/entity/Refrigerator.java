package by.epam.task1.entity;

import by.epam.task1.core.Parser;

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
    public void setValues(String[] value) {
        for (String aValue : value) {
            String[] array = Parser.parseEqually(aValue);
            if (Refrigerator.POWER_CONSUMPTION.equals(array[0].toUpperCase())) {
                setPowerConsumption(Double.parseDouble(array[1]));
            }
            if (Refrigerator.WEIGHT.equals(array[0].toUpperCase())) {
                setWeight(Double.parseDouble(array[1]));
            }
            if (Refrigerator.FREEZER_CAPACITY.equals(array[0].toUpperCase())) {
                setFreezerCapacity(Double.parseDouble(array[1]));
            }
            if (Refrigerator.OVERALL_CAPACITY.equals(array[0].toUpperCase())) {
                setOverallCapacity(Double.parseDouble(array[1]));
            }
            if (Refrigerator.HEIGHT.equals(array[0].toUpperCase())) {
                setHeight(Double.parseDouble(array[1]));
            }
            if (Refrigerator.WIDTH.equals(array[0].toUpperCase())) {
                setWidth(Double.parseDouble(array[1]));
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
