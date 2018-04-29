package by.epam.task3.service;

import by.epam.task3.dao.LaptopDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Laptop;
import by.epam.task3.core.Viewer;
import by.epam.task3.entity.Os;

import java.util.List;
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

    @Override
    public void editor() {
        List<Laptop> laptopList = laptopDao.search(new Criteria("Oven".toUpperCase()));
        for (int i = 0; i < laptopList.size(); i++) {
            Viewer.output(i + " - " + laptopList.get(i) + "");
        }
        Viewer.output("Choice");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("BATTERY_CAPACITY");
        String batteryCapacity = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("OS");
        String os = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("MEMORY_ROM");
        String memoryRom = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("SYSTEM_MEMORY");
        String systemMemory = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("CPU");
        String cpu = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("DISPLAY_INCHES");
        String displayInches = ServiceFactory.getInstance().getScanner().nextLine();
        try {
            if (laptopList.size() > Integer.parseInt(choice)) {
                Laptop laptop = laptopList.get(Integer.parseInt(choice));
                laptop.setBatteryCapacity(Double.valueOf(batteryCapacity));
                laptop.setOs(Os.valueOf(os));
                laptop.setMemoryRom(Double.valueOf(memoryRom));
                laptop.setSystemMemory(Double.valueOf(systemMemory));
                laptop.setCpu(Double.valueOf(cpu));
                laptop.setDisplayInches(Double.valueOf(displayInches));
                laptopDao.update(laptopList);
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
