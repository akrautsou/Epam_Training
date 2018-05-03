package by.epam.task4.core;

import by.epam.task4.entity.Aircraft;

public class Worker implements IWorker {

    private Airline airline;

    public Worker(Airline airline) {
        this.airline = airline;
    }

    public void addAircraft(Aircraft aircraft) {
        airline.extendsIfFull();
        airline.getAircrafts()[airline.getQuantity()] = aircraft;
        airline.setQuantity(airline.getQuantity() + 1);
    }

    public void remove(int index) {
        if (airline.getQuantity() >= index) {
            for (int i = index; i < airline.getAircrafts().length; i++) {
                if (i < airline.getAircrafts().length - 1) {
                    airline.getAircrafts()[i] = airline.getAircrafts()[i + 1];
                } else {
                    airline.getAircrafts()[i] = null;
                }
            }
        }
    }

    public void clear() {
        for (int i = 0; i < airline.getQuantity(); i++) {
            airline.getAircrafts()[i] = null;
        }
    }

    public void editIndex(int index) {
        if (index > airline.getQuantity()) {
            return;
        }
        if (!(airline.getAircrafts()[index] == null)) {
            airline.getAircrafts()[index].setCarryingCapacity(5);
            airline.getAircrafts()[index].setManufacturer("Empty");
        }
    }
}

