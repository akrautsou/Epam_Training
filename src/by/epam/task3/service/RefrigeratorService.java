package by.epam.task3.service;

import by.epam.task3.dao.RefrigeratorDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Refrigerator;
import by.epam.task3.core.Viewer;

import java.util.List;
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

    @Override
    public void editor() {
        List<Refrigerator> refrigeratorList = refrigeratorDao.search(new Criteria("Refrigerator".toUpperCase()));
        for (int i = 0; i < refrigeratorList.size(); i++) {
            Viewer.output(i + " - " + refrigeratorList.get(i) + "");
        }
        Viewer.output("Choice");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("POWER_CONSUMPTION");
        String powerConsumption = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("WEIGHT");
        String weight = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("FREEZER_CAPACITY");
        String freezer_capacity = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("OVERALL_CAPACITY");
        String overallCapacity = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("HEIGHT");
        String height = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("WIDTH");
        String width = ServiceFactory.getInstance().getScanner().nextLine();
        try {
            if (refrigeratorList.size() > Integer.parseInt(choice)) {
                Refrigerator refrigerator = refrigeratorList.get(Integer.parseInt(choice));
                refrigerator.setPowerConsumption(Double.valueOf(powerConsumption));
                refrigerator.setWeight(Double.valueOf(weight));
                refrigerator.setFreezerCapacity(Double.valueOf(freezer_capacity));
                refrigerator.setOverallCapacity(Double.valueOf(overallCapacity));
                refrigerator.setHeight(Double.valueOf(height));
                refrigerator.setWidth(Double.valueOf(width));
                refrigeratorDao.update(refrigeratorList);
            } else {
                Viewer.output("Error");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            Viewer.output("Error");
            System.exit(0);
        }
    }
}
