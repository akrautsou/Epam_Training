package by.epam.task1.core;

import by.epam.task1.entity.*;
import by.epam.task1.service.LaptopService;
import by.epam.task1.service.OvenService;
import by.epam.task1.service.RefrigeratorService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private OvenService ovenService;
    private LaptopService laptopService;
    private RefrigeratorService refrigeratorService;
    private Worker worker;

    public LaptopService getLaptopService() {
        return laptopService;
    }

    public void setLaptopService(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    public RefrigeratorService getRefrigeratorService() {
        return refrigeratorService;
    }

    public void setRefrigeratorService(RefrigeratorService refrigeratorService) {
        this.refrigeratorService = refrigeratorService;
    }

    public OvenService getOvenService() {
        return ovenService;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public void setOvenService(OvenService ovenService) {
        this.ovenService = ovenService;
    }

    private Scanner scanner = new Scanner(System.in);
    private String string = "";

    public void menuFirst() {
        Viewer.output("What do you want " + "\n");
        Viewer.output("1 " + GoodsType.OVEN + "\n");
        Viewer.output("2 " + GoodsType.REFRIGERATOR + "\n");
        Viewer.output("3 " + GoodsType.LAPTOP + "\n");
        String choice = scanner.nextLine();
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
            default:
                menuFirst();
                break;
        }
        menu(string);

    }

    private void menu(String goodsType) {
        IGoods iGoods = GoodsFactory.getGoods(GoodsType.valueOf(goodsType.toUpperCase()));
        Map<String, String> valueMap = new HashMap<>();
        Viewer.output("Select options to search" + "\n");
        if (iGoods instanceof Refrigerator) {
            valueMap = refrigeratorService.getSearchDataMap();
        }
        if (iGoods instanceof Laptop) {
            valueMap = laptopService.getSearchDataMap();
        }
        if (iGoods instanceof Oven) {
            valueMap = ovenService.getSearchDataMap();
        }
        worker.search(goodsType, valueMap);
    }
}
