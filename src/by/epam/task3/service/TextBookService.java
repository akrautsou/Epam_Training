package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.TextBookDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.TextBook;

import java.util.List;
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

    @Override
    public void editor() {
        List<TextBook> textBookList = textBookDao.search(new Criteria("Oven".toUpperCase()));
        for (int i = 0; i < textBookList.size(); i++) {
            Viewer.output(i + " - " + textBookList.get(i) + "");
        }
        Viewer.output("Choice");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("TITLE");
        String title = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("SUBJECT");
        String subject = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("AUTHOR");
        String author = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("NUMBER_OF_PAGES");
        String numberOfPages = ServiceFactory.getInstance().getScanner().nextLine();
        try {
            if (textBookList.size() > Integer.parseInt(choice)) {
                TextBook textBook = textBookList.get(Integer.parseInt(choice));
                textBook.setTitle(title);
                textBook.setSubject(subject);
                textBook.setAuthor(author);
                textBook.setNumberOfPages(Integer.valueOf(numberOfPages));
                textBookDao.update(textBookList);
            }else{
                Viewer.output("Error");
                System.exit(0);
            }
        }catch (NumberFormatException e){
            Viewer.output("Error");
            System.exit(0);
        }
    }

}