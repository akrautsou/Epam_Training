package by.epam.task3.dao;

import by.epam.task3.entity.Oven;
import by.epam.task3.entity.Criteria;
import by.epam.task3.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OvenDao implements IGoodsDao<Oven> {

    @Override
    public void update(List<Oven> entity) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Oven anEntity : entity) {
            list.add(anEntity.getValues());
        }
        ServiceFactory.getInstance().getDbEngine().update(list, "Oven".toUpperCase());
    }

    @Override
    public List<Oven> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<Oven> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            Oven goods = new Oven();
            goods.setValues(mapValue);
            if (criteria.getCriteria().isEmpty() || (goods.isPowerConsumptionContains(criteria.getCriteria().get(by.epam.task3.entity.Oven.POWER_CONSUMPTION).toString())
                    && goods.isCapacityContains(criteria.getCriteria().get(Oven.CAPACITY).toString())
                    && goods.isDepthContains(criteria.getCriteria().get(Oven.DEPTH).toString())
                    && goods.isHeightContains(criteria.getCriteria().get(Oven.HEIGHT).toString())
                    && goods.isWeightContains(criteria.getCriteria().get(Oven.WEIGHT).toString())
                    && goods.isWidthContains(criteria.getCriteria().get(Oven.WIDTH).toString()))
                    ) {
                resultList.add(goods);
            }
        }

        return resultList;
    }
}
