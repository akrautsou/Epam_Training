package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.TabletPcDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.TabletPC;

import java.util.List;
import java.util.Scanner;

public class TabletPCService implements IGoodsService<TabletPC> {
    private TabletPcDao tabletPcDao = new TabletPcDao();


    @Override
    public Criteria getSearchCriteria() {
        Scanner scanner = ServiceFactory.getInstance().getScanner();
        Criteria criteria = new Criteria("TabletPC".toUpperCase());
        Viewer.output(TabletPC.BATTERY_CAPACITY + "= ");
        criteria.add(TabletPC.BATTERY_CAPACITY, scanner.nextLine());
        Viewer.output(TabletPC.DISPLAY_INCHES + "= ");
        criteria.add(TabletPC.DISPLAY_INCHES, scanner.nextLine());
        Viewer.output(TabletPC.MEMORY_ROM + "= ");
        criteria.add(TabletPC.MEMORY_ROM, scanner.nextLine());
        Viewer.output(TabletPC.FLASH_MEMORY_CAPACITY + "= ");
        criteria.add(TabletPC.FLASH_MEMORY_CAPACITY, scanner.nextLine());
        Viewer.output(TabletPC.COLOR + "= ");
        criteria.add(TabletPC.COLOR, scanner.nextLine());
        return criteria;
    }

    @Override
    public void search(Criteria criteria) {
        List<TabletPC> goodsList = tabletPcDao.search(criteria);
        for (TabletPC anGoodsList : goodsList) {
            Viewer.output(anGoodsList);
        }
    }

    @Override
    public void editor() {
        List<TabletPC> tabletPCList = tabletPcDao.search(new Criteria("TabletPC".toUpperCase()));
        for (int i = 0; i < tabletPCList.size(); i++) {
            Viewer.output(i + " - " + tabletPCList.get(i) + "");
        }
        Viewer.output("Choice");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("BATTERY_CAPACITY");
        String batteryCapacity = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("DISPLAY_INCHES");
        String displayInches = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("MEMORY_ROM");
        String memoryRom = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("FLASH_MEMORY_CAPACITY");
        String flashMemoryCapacity = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("COLOR");
        String color = ServiceFactory.getInstance().getScanner().nextLine();
        try {
            if (tabletPCList.size() > Integer.parseInt(choice)) {
                TabletPC tabletPC = tabletPCList.get(Integer.parseInt(choice));
                tabletPC.setBatteryCapacity(Double.valueOf(batteryCapacity));
                tabletPC.setMemoryRom(Double.valueOf(memoryRom));
                tabletPC.setFlashMemoryCapacity(Double.valueOf(flashMemoryCapacity));
                tabletPC.setColor(color);
                tabletPC.setDisplayInches(Double.valueOf(displayInches));
                tabletPcDao.update(tabletPCList);
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
