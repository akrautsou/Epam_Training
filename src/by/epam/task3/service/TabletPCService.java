package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.TabletPcDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.TabletPC;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
}
