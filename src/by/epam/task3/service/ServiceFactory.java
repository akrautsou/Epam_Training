package by.epam.task3.service;

import by.epam.task3.core.Menu;
import by.epam.task3.dao.DataEngine;

import java.util.Scanner;

public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();
    private OvenService ovenService = new OvenService();
    private LaptopService laptopService = new LaptopService();
    private RefrigeratorService refrigeratorService = new RefrigeratorService();
    private VacuumCleanerService vacuumCleanerService = new VacuumCleanerService();
    private TabletPCService tabletPCService = new TabletPCService();
    private SpeakersService speakersService = new SpeakersService();
    private TextBookService textBookService = new TextBookService();
    private NewspaperService newspaperService = new NewspaperService();
    private Menu menu = new Menu();
    private DataEngine dbEngine = new DataEngine();
    private Scanner scanner = new Scanner(System.in);

    private ServiceFactory() {

    }

    public Scanner getScanner() {
        return scanner;
    }

    public OvenService getOvenService() {
        return ovenService;
    }

    public LaptopService getLaptopService() {
        return laptopService;
    }

    public RefrigeratorService getRefrigeratorService() {
        return refrigeratorService;
    }

    public VacuumCleanerService getVacuumCleanerService() {
        return vacuumCleanerService;
    }

    public TabletPCService getTabletPCService() {
        return tabletPCService;
    }

    public SpeakersService getSpeakersService() {
        return speakersService;
    }

    public TextBookService getTextBookService() {
        return textBookService;
    }

    public NewspaperService getNewspaperService() {
        return newspaperService;
    }

    public Menu getMenu() {
        return menu;
    }

    public DataEngine getDbEngine() {
        return dbEngine;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
