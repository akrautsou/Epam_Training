package by.epam.task3;

import by.epam.task3.service.ServiceFactory;

import java.io.IOException;

public class MainThirdTask {


    public static void main(String[] args) throws IOException {
        ServiceFactory.getInstance().getDbEngine().loadDB();
        ServiceFactory.getInstance().getMenu().mainMenu();
    }
}
