package by.epam.task3.entity;

import by.epam.task3.core.Parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public void setPowerConsumption(Double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
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
    public void setValues(Map<String, Object> value) {
        for (Map.Entry<String, Object> aValue: value.entrySet()) {
            if (Oven.POWER_CONSUMPTION.equals(aValue.getKey().toUpperCase())) {
                setPowerConsumption(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Oven.WEIGHT.equals(aValue.getKey().toUpperCase())) {
                setWeight(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Oven.CAPACITY.equals(aValue.getKey().toUpperCase())) {
                setCapacity(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Oven.DEPTH.equals(aValue.getKey().toUpperCase())) {
                setDepth(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Oven.HEIGHT.equals(aValue.getKey().toUpperCase())) {
                setHeight(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Oven.WIDTH.equals(aValue.getKey().toUpperCase())) {
                setWidth(Double.parseDouble(aValue.getValue().toString()));
            }
        }
    }

    @Override
    public Map<String, Object> getValues(){
        Map<String, Object> map = new HashMap<>();
        map.put(POWER_CONSUMPTION, getPowerConsumption());
        map.put(WEIGHT, getWeight());
        map.put(CAPACITY, getCapacity());
        map.put(DEPTH, getDepth());
        map.put(HEIGHT, getHeight());
        map.put(WIDTH, getWidth());
        return map;
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