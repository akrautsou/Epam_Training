package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.VacuumCleanerDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.VacuumCleaner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class VacuumCleanerService implements IGoodsService<VacuumCleaner> {
    private VacuumCleanerDao vacuumCleanerDao = new VacuumCleanerDao();

    @Override
    public Criteria getSearchCriteria() {
        Scanner scanner = ServiceFactory.getInstance().getScanner();
        Criteria criteria = new Criteria("VacuumCleaner".toUpperCase());
        Viewer.output(VacuumCleaner.POWER_CONSUMPTION + "= ");
        criteria.add(VacuumCleaner.POWER_CONSUMPTION, scanner.nextLine());
        Viewer.output(VacuumCleaner.FILTER_TYPE + "= ");
        criteria.add(VacuumCleaner.FILTER_TYPE, scanner.nextLine());
        Viewer.output(VacuumCleaner.BAG_TYPE + "= ");
        criteria.add(VacuumCleaner.BAG_TYPE, scanner.nextLine());
        Viewer.output(VacuumCleaner.WAND_TYPE + "= ");
        criteria.add(VacuumCleaner.WAND_TYPE, scanner.nextLine());
        Viewer.output(VacuumCleaner.MOTOR_SPEED_REGULATION + "= ");
        criteria.add(VacuumCleaner.MOTOR_SPEED_REGULATION, scanner.nextLine());
        Viewer.output(VacuumCleaner.CLEANING_WIDTH + "= ");
        criteria.add(VacuumCleaner.CLEANING_WIDTH, scanner.nextLine());
        return criteria;
    }

    @Override
    public void search(Criteria criteria) {
        List<VacuumCleaner> goodsList = vacuumCleanerDao.search(criteria);
        for (VacuumCleaner anGoodsList : goodsList) {
            Viewer.output(anGoodsList);
        }
    }

}