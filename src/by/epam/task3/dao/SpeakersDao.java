package by.epam.task3.dao;

import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Speakers;
import by.epam.task3.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpeakersDao implements IGoodsDao<Speakers> {
    @Override
    public void save(Speakers entity) {

    }

    @Override
    public void update(Speakers entity) {

    }

    @Override
    public void delete(Speakers entity) {

    }

    @Override
    public List<Speakers> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<Speakers> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            Speakers goods = new Speakers();
            goods.setValues(mapValue);
            if (goods.isPowerConsumptionContains( criteria.getCriteria().get(Speakers.POWER_CONSUMPTION).toString())
                    && goods.isNumberOfSpeakersContains( criteria.getCriteria().get(Speakers.NUMBER_OF_SPEAKERS).toString())
                    && goods.isFrequencyRangeContains( criteria.getCriteria().get(Speakers.FREQUENCY_RANGE).toString())
                    && goods.isCordLengthContains( criteria.getCriteria().get(Speakers.CORD_LENGTH).toString())) {
                resultList.add(goods);
            }

        }
        return resultList;
    }
}
