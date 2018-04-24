package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.SpeakersDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Speakers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SpeakersService implements IGoodsService<Speakers> {
    private SpeakersDao speakersDao = new SpeakersDao();


    @Override
    public Criteria getSearchCriteria() {
        Scanner scanner = ServiceFactory.getInstance().getScanner();
        Criteria criteria = new Criteria("Speakers".toUpperCase());
        Viewer.output(Speakers.POWER_CONSUMPTION + "= ");
        criteria.add(Speakers.POWER_CONSUMPTION, scanner.nextLine());
        Viewer.output(Speakers.NUMBER_OF_SPEAKERS + "= ");
        criteria.add(Speakers.NUMBER_OF_SPEAKERS, scanner.nextLine());
        Viewer.output(Speakers.FREQUENCY_RANGE + "= ");
        criteria.add(Speakers.FREQUENCY_RANGE, scanner.nextLine());
        Viewer.output(Speakers.CORD_LENGTH + "= ");
        criteria.add(Speakers.CORD_LENGTH, scanner.nextLine());
        return criteria;
    }


    @Override
    public void search(Criteria criteria) {
        List<Speakers> goodsList = speakersDao.search(criteria);
        for (Speakers anGoodsList : goodsList) {
            Viewer.output(anGoodsList);
        }
    }
}
