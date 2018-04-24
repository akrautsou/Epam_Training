package by.epam.task3.dao;

import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Laptop;
import by.epam.task3.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LaptopDao implements IGoodsDao<Laptop> {
    @Override
    public void save(Laptop entity) {

    }

    @Override
    public void update(Laptop entity) {

    }

    @Override
    public void delete(Laptop entity) {

    }

    @Override
    public List<Laptop> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<Laptop> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            Laptop goods = new Laptop();
            goods.setValues(mapValue);
            if (goods.isBatteryCapacityContains( criteria.getCriteria().get(Laptop.BATTERY_CAPACITY).toString())
                    && goods.isCpuContains(criteria.getCriteria().get(Laptop.CPU).toString())
                    && goods.isOsContains(criteria.getCriteria().get(Laptop.OS).toString())
                    && goods.isDisplayInchesContains(criteria.getCriteria().get(Laptop.DISPLAY_INCHES).toString())
                    && goods.isSystemMemoryContains(criteria.getCriteria().get(Laptop.SYSTEM_MEMORY).toString())
                    && goods.isMemoryRomContains(criteria.getCriteria().get(Laptop.MEMORY_ROM).toString())) {
                resultList.add(goods);
            }

        }
        return resultList;
    }
}

