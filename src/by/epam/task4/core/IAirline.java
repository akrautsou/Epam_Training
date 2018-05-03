package by.epam.task4.core;

import by.epam.task4.entity.Aircraft;

public interface IAirline {

    Object getInfoAboutCollection();

    boolean isEmpty();

    Aircraft outputIndex(int index);

    String searchModel(String model);

}

