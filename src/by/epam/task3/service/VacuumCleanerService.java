package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.VacuumCleanerDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.VacuumCleaner;

import java.util.List;
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

    @Override
    public void editor() {
        List<VacuumCleaner> vacuumCleanerList = vacuumCleanerDao.search(new Criteria("Oven".toUpperCase()));
        for (int i = 0; i < vacuumCleanerList.size(); i++) {
            Viewer.output(i + " - " + vacuumCleanerList.get(i) + "");
        }
        Viewer.output("Choice");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("POWER_CONSUMPTION");
        String powerConsumption = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("FILTER_TYPE");
        String filterType = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("BAG_TYPE");
        String bagType = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("WAND_TYPE");
        String wandType = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("MOTOR_SPEED_REGULATION");
        String motorSpeedRegulation = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("CLEANING_WIDTH");
        String cleaningWidth = ServiceFactory.getInstance().getScanner().nextLine();
        try {
            if (vacuumCleanerList.size() > Integer.parseInt(choice)) {
                VacuumCleaner vacuumCleaner = vacuumCleanerList.get(Integer.parseInt(choice));
                vacuumCleaner.setPowerConsumption(Double.valueOf(powerConsumption));
                vacuumCleaner.setFilterType(filterType);
                vacuumCleaner.setBagType(bagType);
                vacuumCleaner.setWandType(wandType);
                vacuumCleaner.setMotorSpeedRegulation(Double.valueOf(motorSpeedRegulation));
                vacuumCleaner.setCleaningWidth(Double.valueOf(cleaningWidth));
                vacuumCleanerDao.update(vacuumCleanerList);
            }else{
                Viewer.output("Error");
                System.exit(0);
            }
        }catch (NumberFormatException e){
            Viewer.output("Error");
            System.exit(0);
        }
    }

}