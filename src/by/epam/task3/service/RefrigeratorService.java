package by.epam.task3.service;

import by.epam.task3.dao.RefrigeratorDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Refrigerator;
import by.epam.task3.core.Viewer;
import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RefrigeratorService implements IGoodsService<Refrigerator> {
    private RefrigeratorDao refrigeratorDao = new RefrigeratorDao();

    @Override
    public Criteria getSearchCriteria() {
        Scanner scanner = ServiceFactory.getInstance().getScanner();
        Criteria criteria = new Criteria("Refrigerator".toUpperCase());
        Viewer.output(Refrigerator.POWER_CONSUMPTION + "= ");
        criteria.add(Refrigerator.POWER_CONSUMPTION, scanner.nextLine());
        Viewer.output(Refrigerator.WEIGHT + "= ");
        criteria.add(Refrigerator.WEIGHT, scanner.nextLine());
        Viewer.output(Refrigerator.FREEZER_CAPACITY + "= ");
        criteria.add(Refrigerator.FREEZER_CAPACITY, scanner.nextLine());
        Viewer.output(Refrigerator.OVERALL_CAPACITY + "= ");
        criteria.add(Refrigerator.OVERALL_CAPACITY, scanner.nextLine());
        Viewer.output(Refrigerator.HEIGHT + "= ");
        criteria.add(Refrigerator.HEIGHT, scanner.nextLine());
        Viewer.output(Refrigerator.WIDTH + "= ");
        criteria.add(Refrigerator.WIDTH, scanner.nextLine());
        return criteria;
    }

    @Override
    public void search(Criteria criteria) {
        List<Refrigerator> goodsList = refrigeratorDao.search(criteria);
        for (Refrigerator anGoodsList : goodsList) {
            Viewer.output(anGoodsList);
        }
    }
}
