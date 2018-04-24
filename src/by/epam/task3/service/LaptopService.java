package by.epam.task3.service;

import by.epam.task3.dao.LaptopDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Laptop;
import by.epam.task3.core.Viewer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LaptopService implements IGoodsService<Laptop> {
    private LaptopDao laptopDao = new LaptopDao();

    @Override
    public Criteria getSearchCriteria() {
        Scanner scanner = ServiceFactory.getInstance().getScanner();
        Criteria criteria = new Criteria("Laptop".toUpperCase());
        Viewer.output(Laptop.BATTERY_CAPACITY + "= ");
        criteria.add(Laptop.BATTERY_CAPACITY, scanner.nextLine());
        Viewer.output(Laptop.OS + "= ");
        criteria.add(Laptop.OS, scanner.nextLine());
        Viewer.output(Laptop.MEMORY_ROM + "= ");
        criteria.add(Laptop.MEMORY_ROM, scanner.nextLine());
        Viewer.output(Laptop.SYSTEM_MEMORY + "= ");
        criteria.add(Laptop.SYSTEM_MEMORY, scanner.nextLine());
        Viewer.output(Laptop.CPU + "= ");
        criteria.add(Laptop.CPU, scanner.nextLine());
        Viewer.output(Laptop.DISPLAY_INCHES + "= ");
        criteria.add(Laptop.DISPLAY_INCHES, scanner.nextLine());
        return criteria;
    }

    @Override
    public void search(Criteria criteria) {
        List<Laptop> goodsList = laptopDao.search(criteria);
        for (Laptop anGoodsList : goodsList) {
            Viewer.output(anGoodsList);
        }
    }
}
