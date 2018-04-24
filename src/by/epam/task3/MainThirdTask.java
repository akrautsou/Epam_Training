package by.epam.task3;

import by.epam.task3.core.*;
import by.epam.task3.dao.DataEngine;
import by.epam.task3.service.*;

import java.io.IOException;

public class MainThirdTask {


    public static void main(String[] args) throws IOException {
        ServiceFactory.getInstance().getDbEngine().loadDB();
        ServiceFactory.getInstance().getMenu().menuFirst();





       /* OvenService ovenService = new OvenService();
        LaptopService laptopService = new LaptopService();
        RefrigeratorService refrigeratorService = new RefrigeratorService();
        VacuumCleanerService vacuumCleanerService = new VacuumCleanerService();
        TabletPCService tabletPCService = new TabletPCService();
        SpeakersService speakersService = new SpeakersService();
        TextBookService textBookService = new TextBookService();
        NewspaperService newspaperService = new NewspaperService();

        Worker worker = new Worker();
        worker.setOvenService(ovenService);
        worker.setLaptopService(laptopService);
        worker.setRefrigeratorService(refrigeratorService);
        worker.setVacuumCleanerService(vacuumCleanerService);
        worker.setTabletPCService(tabletPCService);
        worker.setSpeakersService(speakersService);
        worker.setTextBookService(textBookService);
        worker.setNewspaperService(newspaperService);

        Menu menu = new Menu();
        menu.setOvenService(ovenService);
        menu.setLaptopService(laptopService);
        menu.setRefrigeratorService(refrigeratorService);
        menu.setVacuumCleanerService(vacuumCleanerService);
        menu.setTabletPCService(tabletPCService);
        menu.setSpeakersService(speakersService);
        menu.setTextBookService(textBookService);
        menu.setNewspaperService(newspaperService);
        menu.setWorker(worker);
        DataEngine dbEngine = new DataEngine();*/


    }
}
