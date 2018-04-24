package by.epam.task3.dao;

import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.TabletPC;
import by.epam.task3.service.ServiceFactory;
import javafx.scene.control.Tab;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TabletPcDao implements IGoodsDao<TabletPC> {
    @Override
    public void save(TabletPC entity) {

    }

    @Override
    public void update(TabletPC entity) {

    }

    @Override
    public void delete(TabletPC entity) {

    }

    @Override
    public List<TabletPC> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<TabletPC> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            TabletPC goods = new TabletPC();
            goods.setValues(mapValue);
            if (goods.isBatteryCapacityContains(criteria.getCriteria().get(TabletPC.BATTERY_CAPACITY).toString())
                    && goods.isDisplayInchesContains(criteria.getCriteria().get(TabletPC.DISPLAY_INCHES).toString())
                    && goods.isMemoryRomContains(criteria.getCriteria().get(TabletPC.MEMORY_ROM).toString())
                    && goods.isFlashMemoryCapacityContains(criteria.getCriteria().get(TabletPC.FLASH_MEMORY_CAPACITY).toString())
                    && goods.isColorContains(criteria.getCriteria().get(TabletPC.COLOR).toString())) {
                resultList.add(goods);
            }

        }
        return resultList;
    }
}
