package by.epam.task4.entity;

public class Aircraft {
    private String manufacturer;
    private String model;
    private double totalCapacity;
    private double carryingCapacity;
    private double rangeFlight;
    private double fuelConsumption;

    public Aircraft() {
    }

    public Aircraft(String manufacturer, String model, double totalCapacity, double carryingCapacity, double rangeFlight, double fuelConsumption) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.totalCapacity = totalCapacity;
        this.carryingCapacity = carryingCapacity;
        this.rangeFlight = rangeFlight;
        this.fuelConsumption = fuelConsumption;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(double totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getRangeFlight() {
        return rangeFlight;
    }

    public void setRangeFlight(double rangeFlight) {
        this.rangeFlight = rangeFlight;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String toString() {
        return "Aircraft:" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", totalCapacity=" + totalCapacity +
                ", carryingCapacity=" + carryingCapacity +
                ", rangeFlight=" + rangeFlight +
                ", fuelConsumption=" + fuelConsumption;
    }
}
