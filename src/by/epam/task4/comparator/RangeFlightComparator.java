package by.epam.task4.comparator;

import by.epam.task4.entity.Aircraft;

import java.util.Comparator;

public class RangeFlightComparator implements Comparator<Aircraft> {
    @Override
    public int compare(Aircraft o1, Aircraft o2) {
        if (o1 != null && o2 != null) {
            return Double.compare(o1.getRangeFlight(), o2.getRangeFlight());
        }
        return 0;
    }
}
