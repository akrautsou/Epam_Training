package by.epam.task3.entity;

import by.epam.task3.core.Parser;

import java.util.Map;

public class TabletPC implements IGoods{
    public static final String BATTERY_CAPACITY = "BATTERY_CAPACITY";
    public static final String DISPLAY_INCHES = "DISPLAY_INCHES";
    public static final String MEMORY_ROM = "MEMORY_ROM";
    public static final String FLASH_MEMORY_CAPACITY = "FLASH_MEMORY_CAPACITY";
    public static final String COLOR = "COLOR";

    private Double batteryCapacity;
    private Double displayInches;
    private Double memoryRom;
    private Double flashMemoryCapacity;
    private String color;

    public TabletPC() {
    }

    public TabletPC(Double batteryCapacity, Double displayInches, Double memoryRom, Double flashMemoryCapacity, String color) {
        this.batteryCapacity = batteryCapacity;
        this.displayInches = displayInches;
        this.memoryRom = memoryRom;
        this.flashMemoryCapacity = flashMemoryCapacity;
        this.color = color;
    }

    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    private void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Double getDisplayInches() {
        return displayInches;
    }

    private void setDisplayInches(Double displayInches) {
        this.displayInches = displayInches;
    }

    public Double getMemoryRom() {
        return memoryRom;
    }

    private void setMemoryRom(Double memotyRom) {
        this.memoryRom = memotyRom;
    }

    public Double getFlashMemoryCapacity() {
        return flashMemoryCapacity;
    }

    private void setFlashMemoryCapacity(Double flashMemoryCapacity) {
        this.flashMemoryCapacity = flashMemoryCapacity;
    }

    public String getColor() {
        return color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "TabletPC : " +
                "Battery capacity=" + batteryCapacity +
                ", Display inches=" + displayInches +
                ", Memory rom=" + memoryRom +
                ", Flash memory capacity=" + flashMemoryCapacity +
                ", Color=" + color
                + "\n";
    }


    @Override
    public void setValues(Map<String, Object> value) {
        for (Map.Entry<String, Object> aValue: value.entrySet()) {
            if (TabletPC.BATTERY_CAPACITY.equals(aValue.getKey().toUpperCase())) {
                setBatteryCapacity(Double.parseDouble(aValue.getValue().toString()));
            }
            if (TabletPC.DISPLAY_INCHES.equals(aValue.getKey().toUpperCase())) {
                setDisplayInches(Double.parseDouble(aValue.getValue().toString()));
            }
            if (TabletPC.MEMORY_ROM.equals(aValue.getKey().toUpperCase())) {
                setMemoryRom(Double.parseDouble(aValue.getValue().toString()));
            }
            if (TabletPC.FLASH_MEMORY_CAPACITY.equals(aValue.getKey().toUpperCase())) {
                setFlashMemoryCapacity(Double.parseDouble(aValue.getValue().toString()));
            }
            if (TabletPC.COLOR.equals(aValue.getKey().toUpperCase())) {
                setColor(aValue.getValue().toString());
            }
        }
    }

    public boolean isBatteryCapacityContains(String value) {
        return value.isEmpty() || getBatteryCapacity() != null && getBatteryCapacity() >= Double.valueOf(value);
    }

    public boolean isDisplayInchesContains(String value) {
        return value.isEmpty() || getDisplayInches() != null && getDisplayInches() >= Double.valueOf(value);
    }

    public boolean isMemoryRomContains(String value) {
        return value.isEmpty() || getMemoryRom() != null && getMemoryRom() >= Double.valueOf(value);
    }

    public boolean isFlashMemoryCapacityContains(String value) {
        return value.isEmpty() || getFlashMemoryCapacity() != null && getFlashMemoryCapacity() >= Double.valueOf(value);
    }

    public boolean isColorContains(String value) {
        return value.isEmpty() || getColor() != null && getColor().equals(value);
    }

}