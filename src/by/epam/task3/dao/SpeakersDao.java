package by.epam.task3.dao;

import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Speakers;
import by.epam.task3.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpeakersDao implements IGoodsDao<Speakers> {

    @Override
    public void update(List<Speakers> entity) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (Speakers anEntity : entity) {
            list.add(anEntity.getValues());
        }
        ServiceFactory.getInstance().getDbEngine().update(list, "Speakers".toUpperCase());
    }

    @Override
    public List<Speakers> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<Speakers> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            Speakers goods = new Speakers();
            goods.setValues(mapValue);
            if (criteria.getCriteria().isEmpty() || (goods.isPowerConsumptionContains(criteria.getCriteria().get(Speakers.POWER_CONSUMPTION).toString())
                    && goods.isNumberOfSpeakersContains(criteria.getCriteria().get(Speakers.NUMBER_OF_SPEAKERS).toString())
                    && goods.isFrequencyRangeContains(criteria.getCriteria().get(Speakers.FREQUENCY_RANGE).toString())
                    && goods.isCordLengthContains(criteria.getCriteria().get(Speakers.CORD_LENGTH).toString()))) {
                resultList.add(goods);
            }

        }
        return resultList;
    }
}
