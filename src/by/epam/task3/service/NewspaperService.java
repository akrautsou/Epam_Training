package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.NewspaperDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Newspaper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NewspaperService implements IGoodsService<Newspaper> {
    private NewspaperDao newspaperDao = new NewspaperDao();

    @Override
    public Criteria getSearchCriteria() {
        Scanner scanner = ServiceFactory.getInstance().getScanner();
        Criteria criteria = new Criteria("Newspaper".toUpperCase());
        Viewer.output(Newspaper.TITLE + "= ");
        criteria.add(Newspaper.TITLE, scanner.nextLine());
        Viewer.output(Newspaper.PERIODICITY + "= ");
        criteria.add(Newspaper.PERIODICITY, scanner.nextLine());
        Viewer.output(Newspaper.PAID_OR_FREE + "= ");
        criteria.add(Newspaper.PAID_OR_FREE, scanner.nextLine());
        return criteria;
    }
    @Override
    public void search(Criteria criteria) {
        List<Newspaper> goodsList = newspaperDao.search(criteria);
        for (Newspaper anGoodsList : goodsList) {
            Viewer.output(anGoodsList);
        }
    }
}
