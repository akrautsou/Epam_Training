package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.TextBookDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.TextBook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TextBookService implements IGoodsService<TextBook>{
    private TextBookDao textBookDao = new TextBookDao();

    @Override
    public Criteria getSearchCriteria() {
        Scanner scanner = ServiceFactory.getInstance().getScanner();
        Criteria criteria = new Criteria("TextBook".toUpperCase());
        Viewer.output(TextBook.TITLE + "= ");
        criteria.add(TextBook.TITLE, scanner.nextLine());
        Viewer.output(TextBook.SUBJECT + "= ");
        criteria.add(TextBook.SUBJECT, scanner.nextLine());
        Viewer.output(TextBook.AUTHOR + "= ");
        criteria.add(TextBook.AUTHOR, scanner.nextLine());
        Viewer.output(TextBook.NUMBER_OF_PAGES + "= ");
        criteria.add(TextBook.NUMBER_OF_PAGES, scanner.nextLine());
        return criteria;
    }

    @Override
    public void search(Criteria criteria) {
        List<TextBook> goodsList = textBookDao.search(criteria);
        for (TextBook anGoodsList : goodsList) {
            Viewer.output(anGoodsList);
        }
    }

}