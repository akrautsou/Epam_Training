package by.epam.task3.dao;

import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Newspaper;
import by.epam.task3.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NewspaperDao implements IGoodsDao<Newspaper> {
    @Override
    public void save(Newspaper entity) {

    }

    @Override
    public void update(List<Newspaper> entity) {
        List<Map<String, Object>> list = new ArrayList<>();
        for(Newspaper anEntity: entity){
            list.add(anEntity.getValues());
        }
        ServiceFactory.getInstance().getDbEngine().update(list, "Newspaper".toUpperCase());
    }

    @Override
    public void delete(Newspaper entity) {

    }

    @Override
    public List<Newspaper> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<Newspaper> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            Newspaper goods = new Newspaper();
            goods.setValues(mapValue);
            if (criteria.getCriteria().isEmpty() || (goods.isTitleContains(criteria.getCriteria().get(Newspaper.TITLE).toString())
                    && goods.isPeriodicityContains(criteria.getCriteria().get(Newspaper.PERIODICITY).toString())
                    && goods.isPaidOrFreeContains(criteria.getCriteria().get(Newspaper.PAID_OR_FREE).toString()))) {
                resultList.add(goods);
            }

        }
        return resultList;
    }

}

