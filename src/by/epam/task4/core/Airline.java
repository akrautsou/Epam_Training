package by.epam.task4.core;

import by.epam.task4.entity.Aircraft;

import java.util.Arrays;
import java.util.Objects;

public class Airline implements IAirline {
    private String name;
    private Aircraft[] aircrafts;
    private int quantity = 0;

    public Airline() {
        aircrafts = new Aircraft[5];
    }

    public Airline(String name, Aircraft[] aircrafts) {
        this.name = name;
        this.aircrafts = aircrafts;
    }

    public Airline(String name) {
        aircrafts = new Aircraft[5];
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Aircraft[] getAircrafts() {
        return aircrafts;
    }

    public void setAircrafts(Aircraft[] aircrafts) {
        this.aircrafts = aircrafts;
    }

    @Override
    public String toString() {
        return "Airline \n" +
                "name='" + name + '\'' +
                ", aircrafts: \n" + Arrays.toString(aircrafts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airline showRoom = (Airline) o;
        return quantity == showRoom.quantity && (Objects.equals(name, showRoom.name) || (name != null && name.equals(showRoom.getName())))
                && (Arrays.equals(aircrafts, showRoom.aircrafts));
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = result + (Arrays.hashCode(aircrafts) + quantity) * 5;
        return result;
    }

    public boolean isEmpty() {
        return 0 == this.getQuantity();
    }

    public Aircraft outputIndex(int index) {
        return (this.getAircrafts()[index]);
    }

    public Object getInfoAboutCollection() {
        return "quantity = " + this.getQuantity() + "\n" +
                "Collections is empty?" + this.isEmpty();
    }

    public String searchFuelConsumption(double firstValue, double secondValue) {
        for (int i = 0; i < this.getQuantity(); i++) {
            if (this.getAircrafts()[i] != null) {
                if ((this.getAircrafts()[i].getFuelConsumption() >= firstValue)
                        && (this.getAircrafts()[i].getFuelConsumption() <= secondValue)) {
                    return "Find N " + i + "\n" + this.getAircrafts()[i];
                }
            }
        }
        return "Not Found";
    }

    public String searchModel(String model) {
        for (int i = 0; i < this.getQuantity(); i++) {
            if (this.getAircrafts()[i] != null) {
                if (Objects.equals(this.getAircrafts()[i].getModel(), model)) {
                    return "Find N " + i + "\n" + this.getAircrafts()[i];
                }
            }
        }
        return "Not Found";
    }

    public Double findTotalCapacityAirline() {
        Double totalValue = 0d;
        for (int i = 0; i < this.getQuantity(); i++) {
            totalValue += this.getAircrafts()[i].getTotalCapacity();
        }
        return totalValue;
    }

    public Double findTotalCarryingCapacityAirline() {
        Double totalValue = 0d;
        for (int i = 0; i < this.getQuantity(); i++) {
            totalValue += this.getAircrafts()[i].getCarryingCapacity();
        }
        return totalValue;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void extendsIfFull() {
        if (quantity == aircrafts.length) {
            Aircraft[] temp = new Aircraft[(aircrafts.length + 5)];
            System.arraycopy(aircrafts, 0, temp, 0, aircrafts.length);
            aircrafts = temp;
        }
    }
}
