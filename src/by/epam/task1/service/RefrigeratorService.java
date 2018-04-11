package by.epam.task1.service;

import by.epam.task1.entity.Refrigerator;
import by.epam.task1.core.Viewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RefrigeratorService implements IGoodsService<Refrigerator> {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public Map<String, String> getSearchDataMap() {
        Map<String, String> valueMap = new HashMap<>();
        Viewer.output(Refrigerator.POWER_CONSUMPTION + "= ");
        valueMap.put(Refrigerator.POWER_CONSUMPTION, scanner.nextLine());
        Viewer.output(Refrigerator.WEIGHT + "= ");
        valueMap.put(Refrigerator.WEIGHT, scanner.nextLine());
        Viewer.output(Refrigerator.FREEZER_CAPACITY + "= ");
        valueMap.put(Refrigerator.FREEZER_CAPACITY, scanner.nextLine());
        Viewer.output(Refrigerator.OVERALL_CAPACITY + "= ");
        valueMap.put(Refrigerator.OVERALL_CAPACITY, scanner.nextLine());
        Viewer.output(Refrigerator.HEIGHT + "= ");
        valueMap.put(Refrigerator.HEIGHT, scanner.nextLine());
        Viewer.output(Refrigerator.WIDTH + "= ");
        valueMap.put(Refrigerator.WIDTH, scanner.nextLine());
        return valueMap;
    }

    @Override
    public void search(Map<String, String> map, List<Refrigerator> refrigeratorList) {
        for (Refrigerator anRefrigeratorList : refrigeratorList) {
            if(anRefrigeratorList.isPowerConsumptionContains(map.get(Refrigerator.POWER_CONSUMPTION))
                    && anRefrigeratorList.isFreezerCapacityContains(map.get(Refrigerator.FREEZER_CAPACITY))
                    && anRefrigeratorList.isOverallCapacityContains(map.get(Refrigerator.OVERALL_CAPACITY))
                    && anRefrigeratorList.isHeightContains(map.get(Refrigerator.HEIGHT))
                    && anRefrigeratorList.isWeightContains(map.get(Refrigerator.WEIGHT))
                    && anRefrigeratorList.isWidthContains(map.get(Refrigerator.WIDTH))){
                System.out.println(anRefrigeratorList.toString());
            }

        }
    }
}
