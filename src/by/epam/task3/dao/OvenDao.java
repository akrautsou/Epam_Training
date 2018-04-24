package by.epam.task3.dao;

import by.epam.task3.entity.Oven;
import by.epam.task3.entity.Criteria;
import by.epam.task3.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class OvenDao implements IGoodsDao<by.epam.task3.entity.Oven> {
    @Override
    public void save(by.epam.task3.entity.Oven entity) {

    }

    @Override
    public void update(by.epam.task3.entity.Oven entity) {

    }

    @Override
    public void delete(by.epam.task3.entity.Oven entity) {

    }

    @Override
    public List<by.epam.task3.entity.Oven> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<Oven> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            Oven goods = new Oven();
            goods.setValues(mapValue);
            if (goods.isPowerConsumptionContains(criteria.getCriteria().get(by.epam.task3.entity.Oven.POWER_CONSUMPTION).toString())
                    && goods.isCapacityContains(criteria.getCriteria().get(by.epam.task3.entity.Oven.CAPACITY).toString())
                    && goods.isDepthContains(criteria.getCriteria().get(by.epam.task3.entity.Oven.DEPTH).toString())
                    && goods.isHeightContains(criteria.getCriteria().get(by.epam.task3.entity.Oven.HEIGHT).toString())
                    && goods.isWeightContains(criteria.getCriteria().get(by.epam.task3.entity.Oven.WEIGHT).toString())
                    && goods.isWidthContains(criteria.getCriteria().get(by.epam.task3.entity.Oven.WIDTH).toString())) {
                resultList.add(goods);
            }
        }

        return resultList;
    }
}
