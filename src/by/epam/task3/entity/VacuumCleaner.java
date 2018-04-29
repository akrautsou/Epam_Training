package by.epam.task3.entity;

import java.util.HashMap;
import java.util.Map;

public class VacuumCleaner implements IGoods {
    public static final String POWER_CONSUMPTION = "POWER_CONSUMPTION";
    public static final String FILTER_TYPE = "FILTER_TYPE";
    public static final String BAG_TYPE = "BAG_TYPE";
    public static final String WAND_TYPE = "WAND_TYPE";
    public static final String MOTOR_SPEED_REGULATION = "MOTOR_SPEED_REGULATION";
    public static final String CLEANING_WIDTH = "CLEANING_WIDTH";

    private Double powerConsumption;
    private String filterType;
    private String bagType;
    private String wandType;
    private Double motorSpeedRegulation;
    private Double cleaningWidth;

    public VacuumCleaner() {
    }

    public VacuumCleaner(Double powerConsumption, String filterType, String bagType, String wandType, Double motorSpeedRegulation, Double cleaningWidth) {
        this.powerConsumption = powerConsumption;
        this.filterType = filterType;
        this.bagType = bagType;
        this.wandType = wandType;
        this.motorSpeedRegulation = motorSpeedRegulation;
        this.cleaningWidth = cleaningWidth;
    }

    public Double getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(Double powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public String getFilterType() {
        return filterType;
    }

    public void setFilterType(String filterType) {
        this.filterType = filterType;
    }

    public String getBagType() {
        return bagType;
    }

    public void setBagType(String bagType) {
        this.bagType = bagType;
    }

    public String getWandType() {
        return wandType;
    }

    public void setWandType(String wandType) {
        this.wandType = wandType;
    }

    public Double getMotorSpeedRegulation() {
        return motorSpeedRegulation;
    }

    public void setMotorSpeedRegulation(Double motorSpeedRegulation) {
        this.motorSpeedRegulation = motorSpeedRegulation;
    }

    public Double getCleaningWidth() {
        return cleaningWidth;
    }

    public void setCleaningWidth(Double cleaningWidth) {
        this.cleaningWidth = cleaningWidth;
    }

    @Override
    public String toString() {
        return "VacuumCleaner : " +
                "Power Consumption=" + powerConsumption +
                ", Filter type=" + filterType +
                ", Bag type=" + bagType +
                ", Wand type=" + wandType +
                ", Motor speed regulation=" + motorSpeedRegulation +
                ", Cleaning width=" + cleaningWidth
                + "\n";
    }

    @Override
    public void setValues(Map<String, Object> value) {
        for (Map.Entry<String, Object> aValue : value.entrySet()) {
            if (VacuumCleaner.POWER_CONSUMPTION.equals(aValue.getKey().toUpperCase())) {
                setPowerConsumption(Double.parseDouble(aValue.getValue().toString()));
            }
            if (VacuumCleaner.FILTER_TYPE.equals(aValue.getKey().toUpperCase())) {
                setFilterType(aValue.getValue().toString());
            }
            if (VacuumCleaner.BAG_TYPE.equals(aValue.getKey().toUpperCase())) {
                setBagType(aValue.getValue().toString());
            }
            if (VacuumCleaner.WAND_TYPE.equals(aValue.getKey().toUpperCase())) {
                setWandType(aValue.getValue().toString());
            }
            if (VacuumCleaner.MOTOR_SPEED_REGULATION.equals(aValue.getKey().toUpperCase())) {
                setMotorSpeedRegulation(Double.parseDouble(aValue.getValue().toString()));
            }
            if (VacuumCleaner.CLEANING_WIDTH.equals(aValue.getKey().toUpperCase())) {
                setCleaningWidth(Double.parseDouble(aValue.getValue().toString()));
            }
        }
    }

    @Override
    public Map<String, Object> getValues() {
        Map<String, Object> map = new HashMap<>();
        map.put(POWER_CONSUMPTION, getPowerConsumption());
        map.put(FILTER_TYPE, getFilterType());
        map.put(BAG_TYPE, getBagType());
        map.put(WAND_TYPE, getWandType());
        map.put(MOTOR_SPEED_REGULATION, getMotorSpeedRegulation());
        map.put(CLEANING_WIDTH, getCleaningWidth());
        return map;
    }

    public boolean isPowerConsumptionContains(String value) {
        return value.isEmpty() || getPowerConsumption() != null && getPowerConsumption() >= Double.valueOf(value);
    }

    public boolean isFilterTypeContains(String value) {
        return value.isEmpty() || getFilterType() != null && getFilterType().equals(value);
    }

    public boolean isBagTypeContains(String value) {
        return value.isEmpty() || getBagType() != null && getBagType().equals(value);
    }

    public boolean isWandTypeContains(String value) {
        return value.isEmpty() || getWandType() != null && getWandType().equals(value);
    }

    public boolean isMotorSpeedRegulationContains(String value) {
        return value.isEmpty() || getMotorSpeedRegulation() != null && getMotorSpeedRegulation() >= Double.valueOf(value);
    }

    public boolean isCleaningWidthContains(String value) {
        return value.isEmpty() || getCleaningWidth() != null && getCleaningWidth() >= Double.valueOf(value);
    }

}