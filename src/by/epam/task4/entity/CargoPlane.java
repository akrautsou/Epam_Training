package by.epam.task4.entity;

public class CargoPlane extends Aircraft {

    private double wingspan;

    public CargoPlane() {
    }

    public CargoPlane(String manufacturer, String model, double totalCapacity, double carryingCapacity, double rangeFlight,
                      double fuelConsumption, double wingspan) {
        super(manufacturer, model, totalCapacity, carryingCapacity, rangeFlight, fuelConsumption);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", wingspan=" + wingspan +
                " ,type CargoPlane";
    }
}