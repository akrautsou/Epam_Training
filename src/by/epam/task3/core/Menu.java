package by.epam.task3.core;

import by.epam.task3.entity.*;
import by.epam.task3.service.*;

import java.util.HashMap;
import java.util.Map;

public class Menu {

    private String string = "";

    public void mainMenu() {
        Viewer.output("Do you want edit?(yes/no)");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        if (choice.equals("yes")) {
            editDb();
        } else {
            menuFirst();
        }
    }

    public void menuFirst() {
        Viewer.output("What do you want searching" + "\n");
        Viewer.output("1 " + GoodsType.OVEN + "\n");
        Viewer.output("2 " + GoodsType.REFRIGERATOR + "\n");
        Viewer.output("3 " + GoodsType.LAPTOP + "\n");
        Viewer.output("4 " + GoodsType.VACUUMCLEANER + "\n");
        Viewer.output("5 " + GoodsType.TABLETPC + "\n");
        Viewer.output("6 " + GoodsType.SPEAKERS + "\n");
        Viewer.output("7 " + GoodsType.TEXTBOOK + "\n");
        Viewer.output("8 " + GoodsType.NEWSPAPER + "\n");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        switch (choice) {
            case "1":
                string += GoodsType.OVEN;
                break;
            case "2":
                string += GoodsType.REFRIGERATOR;
                break;
            case "3":
                string += GoodsType.LAPTOP;
                break;
            case "4":
                string += GoodsType.VACUUMCLEANER;
                break;
            case "5":
                string += GoodsType.TABLETPC;
                break;
            case "6":
                string += GoodsType.SPEAKERS;
                break;
            case "7":
                string += GoodsType.TEXTBOOK;
                break;
            case "8":
                string += GoodsType.NEWSPAPER;
                break;
            default:
                menuFirst();
                break;
        }
        menu(string);
    }

    private void editDb() {
        Viewer.output("What do you want edit" + "\n");
        Viewer.output("1 " + GoodsType.OVEN + "\n");
        Viewer.output("2 " + GoodsType.REFRIGERATOR + "\n");
        Viewer.output("3 " + GoodsType.LAPTOP + "\n");
        Viewer.output("4 " + GoodsType.VACUUMCLEANER + "\n");
        Viewer.output("5 " + GoodsType.TABLETPC + "\n");
        Viewer.output("6 " + GoodsType.SPEAKERS + "\n");
        Viewer.output("7 " + GoodsType.TEXTBOOK + "\n");
        Viewer.output("8 " + GoodsType.NEWSPAPER + "\n");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        switch (choice) {
            case "1":
                string += GoodsType.OVEN;
                break;
            case "2":
                string += GoodsType.REFRIGERATOR;
                break;
            case "3":
                string += GoodsType.LAPTOP;
                break;
            case "4":
                string += GoodsType.VACUUMCLEANER;
                break;
            case "5":
                string += GoodsType.TABLETPC;
                break;
            case "6":
                string += GoodsType.SPEAKERS;
                break;
            case "7":
                string += GoodsType.TEXTBOOK;
                break;
            case "8":
                string += GoodsType.NEWSPAPER;
                break;
            default:
                editDb();
                break;
        }
        editType(string);
    }

    private void editType(String string) {
        IGoods iGoods = GoodsFactory.getGoods(GoodsType.valueOf(string.toUpperCase()));
        Map<String, String> valueMap = new HashMap<>();
        Viewer.output("Select number to edit" + "\n");
        IGoodsService service = null;
        if (iGoods instanceof Refrigerator) {
            service = ServiceFactory.getInstance().getRefrigeratorService();
        }
        if (iGoods instanceof Laptop) {
            service = ServiceFactory.getInstance().getLaptopService();
        }
        if (iGoods instanceof Oven) {
            service = ServiceFactory.getInstance().getOvenService();
        }
        if (iGoods instanceof VacuumCleaner) {
            service = ServiceFactory.getInstance().getVacuumCleanerService();
        }
        if (iGoods instanceof TabletPC) {
            service = ServiceFactory.getInstance().getTabletPCService();
        }
        if (iGoods instanceof Speakers) {
            service = ServiceFactory.getInstance().getSpeakersService();
        }
        if (iGoods instanceof TextBook) {
            service = ServiceFactory.getInstance().getTextBookService();
        }
        if (iGoods instanceof Newspaper) {
            service = ServiceFactory.getInstance().getNewspaperService();
        }
        if (service != null) {
            service.editor();
        }
    }

    private void menu(String goodsType) {
        IGoods iGoods = GoodsFactory.getGoods(GoodsType.valueOf(goodsType.toUpperCase()));
        Map<String, String> valueMap = new HashMap<>();
        Viewer.output("Select options to search" + "\n");
        IGoodsService service = null;
        if (iGoods instanceof Refrigerator) {
            service = ServiceFactory.getInstance().getRefrigeratorService();
        }
        if (iGoods instanceof Laptop) {
            service = ServiceFactory.getInstance().getLaptopService();
        }
        if (iGoods instanceof Oven) {
            service = ServiceFactory.getInstance().getOvenService();
        }
        if (iGoods instanceof VacuumCleaner) {
            service = ServiceFactory.getInstance().getVacuumCleanerService();
        }
        if (iGoods instanceof TabletPC) {
            service = ServiceFactory.getInstance().getTabletPCService();
        }
        if (iGoods instanceof Speakers) {
            service = ServiceFactory.getInstance().getSpeakersService();
        }
        if (iGoods instanceof TextBook) {
            service = ServiceFactory.getInstance().getTextBookService();
        }
        if (iGoods instanceof Newspaper) {
            service = ServiceFactory.getInstance().getNewspaperService();
        }
        if (service != null) {
            service.search(service.getSearchCriteria());
        }
    }
}
