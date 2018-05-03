package by.epam.task4.creator;


import by.epam.task4.entity.Airliner;
import by.epam.task4.entity.CargoPlane;

public class Creator {
    private static Creator instance;

    private Creator() {

    }

    public static Creator getInstance() {
        if (instance == null) {
            instance = new Creator();
        }
        return instance;
    }

    public Airliner createAirliner(String manufacturer, String model, double totalCapacity,
                                   double carryingCapacity, double rangeFlight, double fuelConsumption, double numberSeats) {
        return new Airliner(manufacturer, model, totalCapacity, carryingCapacity, rangeFlight, fuelConsumption, numberSeats);
    }

    public CargoPlane createCargoPlane(String manufacturer, String model, double totalCapacity,
                                       double carryingCapacity, double rangeFlight, double fuelConsumption, double wingspan) {
        return new CargoPlane(manufacturer, model, totalCapacity, carryingCapacity, rangeFlight, fuelConsumption, wingspan);
    }
}
