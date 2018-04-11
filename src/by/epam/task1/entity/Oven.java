package by.epam.task1.entity;

import by.epam.task1.core.Parser;

public class Oven implements IGoods {
    public static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    public static final String WEIGHT = "WEIGHT";
    public static final String CAPACITY = "CAPACITY";
    public static final String DEPTH = "DEPTH";
    public static final String HEIGHT = "HEIGHT";
    public static final String WIDTH = "WIDTH";

    private Double powerConsumption;
    private Double weight;
    private Double capacity;
    private Double depth;
    private Double height;
    private Double width;

    public Oven() {
    }

    public Oven(Double powerConsumption, Double weight, Double capacity, Double depth, Double height, Double width) {
        this.powerConsumption = powerConsumption;
        this.weight = weight;
        this.capacity = capacity;
        this.depth = depth;
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

    public Double getCapacity() {
        return capacity;
    }

    private void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getDepth() {
        return depth;
    }

    private void setDepth(Double depth) {
        this.depth = depth;
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
        return "Oven : " +
                "powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", depth=" + depth +
                ", height=" + height +
                ", width=" + width
                + "\n";
    }

    @Override
    public void setValues(String[] value) {
        for (String aValue : value) {
            String[] array = Parser.parseEqually(aValue);
            if (Oven.POWER_CONSUMPTION.equals(array[0].toUpperCase())) {
                setPowerConsumption(Double.parseDouble(array[1]));
            }
            if (Oven.WEIGHT.equals(array[0].toUpperCase())) {
                setWeight(Double.parseDouble(array[1]));
            }
            if (Oven.CAPACITY.equals(array[0].toUpperCase())) {
                setCapacity(Double.parseDouble(array[1]));
            }
            if (Oven.DEPTH.equals(array[0].toUpperCase())) {
                setDepth(Double.parseDouble(array[1]));
            }
            if (Oven.HEIGHT.equals(array[0].toUpperCase())) {
                setHeight(Double.parseDouble(array[1]));
            }
            if (Oven.WIDTH.equals(array[0].toUpperCase())) {
                setWidth(Double.parseDouble(array[1]));
            }
        }
    }
    public boolean isPowerConsumptionContains(String value) {
        return value.isEmpty() || getPowerConsumption() != null && getPowerConsumption() >= Double.valueOf(value);
    }

    public boolean isCapacityContains(String value) {
        return value.isEmpty() || getCapacity() != null && getCapacity() >= Double.valueOf(value);
    }

    public boolean isWeightContains(String value) {
        return value.isEmpty() || getWeight() != null && getWeight() <= Double.valueOf(value);
    }

    public boolean isDepthContains(String value) {
        return value.isEmpty() || getDepth() != null && getDepth() <= Double.valueOf(value);
    }

    public boolean isHeightContains(String value) {
        return value.isEmpty() || getHeight() != null && getHeight() <= Double.valueOf(value);
    }

    public boolean isWidthContains(String value) {
        return value.isEmpty() || getWidth() != null && getWidth() <= Double.valueOf(value);
    }


}
