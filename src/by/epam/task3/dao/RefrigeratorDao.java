package by.epam.task3.dao;


import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Refrigerator;
import by.epam.task3.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RefrigeratorDao implements IGoodsDao<Refrigerator> {

    @Override
    public void update(List<Refrigerator> entity) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Refrigerator anEntity : entity) {
            list.add(anEntity.getValues());
        }
        ServiceFactory.getInstance().getDbEngine().update(list, "Refrigerator".toUpperCase());
    }

    @Override
    public List<Refrigerator> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<Refrigerator> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            Refrigerator goods = new Refrigerator();
            goods.setValues(mapValue);
            if (criteria.getCriteria().isEmpty() || (goods.isPowerConsumptionContains(criteria.getCriteria().get(Refrigerator.POWER_CONSUMPTION).toString())
                    && goods.isFreezerCapacityContains(criteria.getCriteria().get(Refrigerator.FREEZER_CAPACITY).toString())
                    && goods.isOverallCapacityContains(criteria.getCriteria().get(Refrigerator.OVERALL_CAPACITY).toString())
                    && goods.isHeightContains(criteria.getCriteria().get(Refrigerator.HEIGHT).toString())
                    && goods.isWeightContains(criteria.getCriteria().get(Refrigerator.WEIGHT).toString())
                    && goods.isWidthContains(criteria.getCriteria().get(Refrigerator.WIDTH).toString()))) {
                System.out.println(goods.toString());
            }
        }
        return resultList;
    }
}
