package by.epam.task1.service;

import by.epam.task1.entity.Laptop;
import by.epam.task1.core.Viewer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LaptopService implements IGoodsService<Laptop> {
    private Scanner scanner = new Scanner(System.in);
    @Override
    public Map<String, String> getSearchDataMap() {
        Map<String, String> valueMap = new HashMap<>();
        Viewer.output(Laptop.BATTERY_CAPACITY + "= ");
        valueMap.put(Laptop.BATTERY_CAPACITY, scanner.nextLine());
        Viewer.output(Laptop.OS + "= ");
        valueMap.put(Laptop.OS, scanner.nextLine());
        Viewer.output(Laptop.MEMORY_ROM + "= ");
        valueMap.put(Laptop.MEMORY_ROM, scanner.nextLine());
        Viewer.output(Laptop.SYSTEM_MEMORY + "= ");
        valueMap.put(Laptop.SYSTEM_MEMORY, scanner.nextLine());
        Viewer.output(Laptop.CPU + "= ");
        valueMap.put(Laptop.CPU, scanner.nextLine());
        Viewer.output(Laptop.DISPLAY_INCHES + "= ");
        valueMap.put(Laptop.DISPLAY_INCHES, scanner.nextLine());
        return valueMap;
    }

    @Override
    public void search(Map<String, String> map, List<Laptop> laptopList) {
        for (Laptop anLaptopList : laptopList) {
            if(anLaptopList.isBatteryCapacityContains(map.get(Laptop.BATTERY_CAPACITY))
                    && anLaptopList.isCpuContains(map.get(Laptop.CPU))
                    && anLaptopList.isOsContains(map.get(Laptop.OS))
                    && anLaptopList.isDisplayInchesContains(map.get(Laptop.DISPLAY_INCHES))
                    && anLaptopList.isSystemMemoryContains(map.get(Laptop.SYSTEM_MEMORY))
                    && anLaptopList.isMemoryRomContains(map.get(Laptop.MEMORY_ROM))){
                System.out.println(anLaptopList.toString());
            }

        }
    }
}
