package by.epam.task4;

import by.epam.task4.core.Airline;
import by.epam.task4.comparator.RangeFlightComparator;
import by.epam.task4.core.Worker;
import by.epam.task4.creator.Creator;
import by.epam.task4.entity.Aircraft;
import by.epam.task4.viewer.Viewer;

import java.util.*;

public class MainFifthTask {

    public static void main(String[] args) {
        //=================================initz=====================================
        Viewer viewer = new Viewer();
        List<Airline> airlineList = new ArrayList<>();
        airlineList.add(new Airline("Emirates"));
        Creator creator = Creator.getInstance();
        Worker workerEmirates1 = new Worker(airlineList.get(0));
        Worker workerEmirates2 = new Worker(airlineList.get(0));
        workerEmirates1.addAircraft(creator.createAirliner("Boing", "747", 1150, 235,
                40, 6, 5));
        workerEmirates2.addAircraft(creator.createCargoPlane("Airbus", "A380", 1150, 235,
                4, 8, 6));
        workerEmirates2.addAircraft(creator.createCargoPlane("Boing", "911", 1150, 235,
                35, 8, 6));
        airlineList.add(new Airline("British Airlines"));
        Worker workerAirline = new Worker(airlineList.get(1));
        workerAirline.addAircraft(creator.createCargoPlane("Boing", "747", 1150, 235,
                4, 4, 5));
        //=================================search and findValue=====================================
        viewer.output(airlineList.get(0).searchModel("747"));
        viewer.output(airlineList.get(0).searchFuelConsumption(4, 7));
        viewer.output(airlineList.get(0).findTotalCapacityAirline());
        viewer.output(airlineList.get(0).findTotalCarryingCapacityAirline());
        //=================================output=====================================
        viewer.output(airlineList.get(0).getName());
        for (int i = 0; i < airlineList.get(0).getQuantity(); i++) {
            viewer.output(airlineList.get(0).outputIndex(i));
        }
        //=================================proof of sorting=====================================
        viewer.output(airlineList.get(0).getInfoAboutCollection());
        List<Aircraft> list = Arrays.asList(airlineList.get(0).getAircrafts());
        list.sort(new RangeFlightComparator());
        viewer.output(list);
        //=================================out=====================================
        viewer.output(airlineList.get(0).getInfoAboutCollection());
        workerEmirates1.editIndex(0);
        workerEmirates1.remove(1);
        workerEmirates1.clear();
    }

}
