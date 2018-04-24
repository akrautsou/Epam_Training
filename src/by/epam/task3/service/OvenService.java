package by.epam.task3.service;

import by.epam.task3.dao.OvenDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Oven;
import by.epam.task3.core.Viewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OvenService implements IGoodsService<Oven> {
    private OvenDao ovenDao = new OvenDao();

    @Override
    public Criteria getSearchCriteria() {
        Scanner scanner = ServiceFactory.getInstance().getScanner();
        Criteria criteria = new Criteria("Oven".toUpperCase());
        Viewer.output(Oven.POWER_CONSUMPTION + "= ");
        criteria.add(Oven.POWER_CONSUMPTION, scanner.nextLine());
        Viewer.output(Oven.WEIGHT + "= ");
        criteria.add(Oven.WEIGHT, scanner.nextLine());
        Viewer.output(Oven.CAPACITY + "= ");
        criteria.add(Oven.CAPACITY, scanner.nextLine());
        Viewer.output(Oven.DEPTH + "= ");
        criteria.add(Oven.DEPTH, scanner.nextLine());
        Viewer.output(Oven.HEIGHT + "= ");
        criteria.add(Oven.HEIGHT, scanner.nextLine());
        Viewer.output(Oven.WIDTH + "= ");
        criteria.add(Oven.WIDTH, scanner.nextLine());
        return criteria;
    }

    @Override
    public void search(Criteria criteria) {
        List<Oven> goodsList = ovenDao.search(criteria);
        for (Oven anGoodsList : goodsList) {
            Viewer.output(anGoodsList);
        }
    }
}