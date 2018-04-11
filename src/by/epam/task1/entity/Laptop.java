package by.epam.task1.entity;

import by.epam.task1.core.Parser;

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
    public void setValues(String[] value) {
        for (String aValue : value) {
            String[] array = Parser.parseEqually(aValue);
            if (Laptop.BATTERY_CAPACITY.equals(array[0].toUpperCase())) {
                setBatteryCapacity(Double.parseDouble(array[1]));
            }
            if (Laptop.OS.equals(array[0].toUpperCase())) {
                setOs(Os.valueOf(array[1].toUpperCase()));
            }
            if (Laptop.MEMORY_ROM.equals(array[0].toUpperCase())) {
                setMemoryRom(Double.parseDouble(array[1]));
            }
            if (Laptop.SYSTEM_MEMORY.equals(array[0].toUpperCase())) {
                setSystemMemory(Double.parseDouble(array[1]));
            }
            if (Laptop.CPU.equals(array[0].toUpperCase())) {
                setCpu(Double.parseDouble(array[1]));
            }
            if (Laptop.DISPLAY_INCHES.equals(array[0].toUpperCase())) {
                setDisplayInches(Double.parseDouble(array[1]));
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
