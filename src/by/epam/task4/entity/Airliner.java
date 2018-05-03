package by.epam.task4.entity;

public class Airliner extends Aircraft {

    private double numberSeats;

    public Airliner() {
    }

    public Airliner(String manufacturer, String model, double totalCapacity, double carryingCapacity, double rangeFlight,
                    double fuelConsumption, double numberSeats) {
        super(manufacturer, model, totalCapacity, carryingCapacity, rangeFlight, fuelConsumption);
        this.numberSeats = numberSeats;
    }

    public double getNumberSeats() {
        return numberSeats;
    }

    public void setNumberSeats(double numberSeats) {
        this.numberSeats = numberSeats;
    }

    @Override
    public String toString() {
        return super.toString() +
                "numberSeats=" + numberSeats +
                " ,type Airline";
    }
}
