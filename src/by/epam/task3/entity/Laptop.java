package by.epam.task3.entity;

import by.epam.task3.core.Parser;

import java.util.Map;

public class Laptop implements IGoods {
    public static final String BATTERY_CAPACITY = "BATTERY_CAPACITY";
    public static final String OS = "OS";
    public static final String MEMORY_ROM = "MEMORY_ROM";
    public static final String SYSTEM_MEMORY = "SYSTEM_MEMORY";
    public static final String CPU = "CPU";
    public static final String DISPLAY_INCHES = "DISPLAY_INCHES";
    private Double batteryCapacity;
    private Os os;
    private Double memoryRom;
    private Double systemMemory;
    private Double cpu;
    private Double displayInches;

    public Laptop() {
    }

    public Laptop(Double batteryCapacity, Os os, Double memoryRom, Double systemMemory, Double cpu, Double displayInchs) {
        this.batteryCapacity = batteryCapacity;
        this.os = os;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInchs;
    }

    public Double getBatteryCapacity() {
        return batteryCapacity;
    }

    private void setBatteryCapacity(Double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public Os getOs() {
        return os;
    }

    private void setOs(Os os) {
        this.os = os;
    }

    public Double getMemoryRom() {
        return memoryRom;
    }

    private void setMemoryRom(Double memoryRom) {
        this.memoryRom = memoryRom;
    }

    public Double getSystemMemory() {
        return systemMemory;
    }

    private void setSystemMemory(Double systemMemory) {
        this.systemMemory = systemMemory;
    }

    public Double getCpu() {
        return cpu;
    }

    private void setCpu(Double cpu) {
        this.cpu = cpu;
    }

    public Double getDisplayInches() {
        return displayInches;
    }

    private void setDisplayInches(Double displayInches) {
        this.displayInches = displayInches;
    }

    @Override
    public String toString() {
        return "Laptop : " +
                "batteryCapacity=" + batteryCapacity +
                ", os=" + os +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", CPU=" + cpu +
                ", displayInches=" + displayInches
                + "\n";
    }

    @Override
    public void setValues(Map<String, Object> value) {
        for (Map.Entry<String, Object> aValue: value.entrySet()) {
            if (Laptop.BATTERY_CAPACITY.equals(aValue.getKey().toUpperCase())) {
                setBatteryCapacity(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Laptop.OS.equals(aValue.getKey().toUpperCase())) {
                setOs(Os.valueOf(aValue.getValue().toString().toUpperCase()));
            }
            if (Laptop.MEMORY_ROM.equals(aValue.getKey().toUpperCase())) {
                setMemoryRom(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Laptop.SYSTEM_MEMORY.equals(aValue.getKey().toUpperCase())) {
                setSystemMemory(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Laptop.CPU.equals(aValue.getKey().toUpperCase())) {
                setCpu(Double.parseDouble(aValue.getValue().toString()));
            }
            if (Laptop.DISPLAY_INCHES.equals(aValue.getKey().toUpperCase())) {
                setDisplayInches(Double.parseDouble(aValue.getValue().toString()));
            }
        }

    }

    public boolean isOsContains(String value) {
        return value.isEmpty() || getOs() != null && getOs().name().equals(value.toUpperCase());
    }

    public boolean isBatteryCapacityContains(String value) {
        return value.isEmpty() || getBatteryCapacity() != null && getBatteryCapacity() >= Double.valueOf(value);
    }

    public boolean isMemoryRomContains(String value) {
        return value.isEmpty() || getMemoryRom() != null && getMemoryRom() >= Double.valueOf(value);
    }

    public boolean isSystemMemoryContains(String value) {
        return value.isEmpty() || getSystemMemory() != null && getSystemMemory() >= Double.valueOf(value);
    }

    public boolean isDisplayInchesContains(String value) {
        return value.isEmpty() || getDisplayInches() != null && getDisplayInches() >= Double.valueOf(value);
    }

    public boolean isCpuContains(String value) {
        return value.isEmpty() || getCpu() != null && getCpu() >= Double.valueOf(value);
    }
}
