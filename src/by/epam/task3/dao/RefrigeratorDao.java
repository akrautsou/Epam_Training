package by.epam.task3.dao;


import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Refrigerator;
import by.epam.task3.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RefrigeratorDao implements IGoodsDao<Refrigerator> {
    @Override
    public void save(Refrigerator entity) {

    }

    @Override
    public void update(Refrigerator entity) {

    }

    @Override
    public void delete(Refrigerator entity) {

    }

    @Override
    public List<Refrigerator> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<Refrigerator> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            Refrigerator goods = new Refrigerator();
            goods.setValues(mapValue);
            if (goods.isPowerConsumptionContains(criteria.getCriteria().get(Refrigerator.POWER_CONSUMPTION).toString())
                    && goods.isFreezerCapacityContains(criteria.getCriteria().get(Refrigerator.FREEZER_CAPACITY).toString())
                    && goods.isOverallCapacityContains(criteria.getCriteria().get(Refrigerator.OVERALL_CAPACITY).toString())
                    && goods.isHeightContains(criteria.getCriteria().get(Refrigerator.HEIGHT).toString())
                    && goods.isWeightContains(criteria.getCriteria().get(Refrigerator.WEIGHT).toString())
                    && goods.isWidthContains(criteria.getCriteria().get(Refrigerator.WIDTH).toString())) {
                System.out.println(goods.toString());
            }
        }
        return resultList;
    }
}
