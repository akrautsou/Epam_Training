package by.epam.task1.service;

import by.epam.task1.entity.Oven;
import by.epam.task1.core.Viewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class OvenService implements IGoodsService<Oven> {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public Map<String, String> getSearchDataMap() {
        Map<String, String> valueMap = new HashMap<>();
        Viewer.output(Oven.POWER_CONSUMPTION + "= ");
        valueMap.put(Oven.POWER_CONSUMPTION, scanner.nextLine());
        Viewer.output(Oven.WEIGHT + "= ");
        valueMap.put(Oven.WEIGHT, scanner.nextLine());
        Viewer.output(Oven.CAPACITY + "= ");
        valueMap.put(Oven.CAPACITY, scanner.nextLine());
        Viewer.output(Oven.DEPTH + "= ");
        valueMap.put(Oven.DEPTH, scanner.nextLine());
        Viewer.output(Oven.HEIGHT + "= ");
        valueMap.put(Oven.HEIGHT, scanner.nextLine());
        Viewer.output(Oven.WIDTH + "= ");
        valueMap.put(Oven.WIDTH, scanner.nextLine());
        return valueMap;
    }

    @Override
    public void search(Map<String, String> map, List<Oven> ovenList) {
        for (Oven anOvenList : ovenList) {
            if(anOvenList.isPowerConsumptionContains(map.get(Oven.POWER_CONSUMPTION))
                    && anOvenList.isCapacityContains(map.get(Oven.CAPACITY))
                    && anOvenList.isDepthContains(map.get(Oven.DEPTH))
                    && anOvenList.isHeightContains(map.get(Oven.HEIGHT))
                    && anOvenList.isWeightContains(map.get(Oven.WEIGHT))
                    && anOvenList.isWidthContains(map.get(Oven.WIDTH))){
                System.out.println(anOvenList.toString());
            }

        }
    }
}
