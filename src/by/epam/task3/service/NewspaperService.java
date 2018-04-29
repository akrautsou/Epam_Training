package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.NewspaperDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Newspaper;

import java.util.List;
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

    @Override
    public void editor() {
        List<Newspaper> newspaperList = newspaperDao.search(new Criteria("Newspaper".toUpperCase()));
        for (int i = 0; i < newspaperList.size(); i++) {
            Viewer.output(i + " - " + newspaperList.get(i) + "");
        }
        Viewer.output("Choice");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("TITLE");
        String title = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("PERIODICITY");
        String periodicity = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("PAID_OR_FREE");
        String paidOrFree = ServiceFactory.getInstance().getScanner().nextLine();
        try {
            if (newspaperList.size() > Integer.parseInt(choice)) {
                Newspaper newspaper = newspaperList.get(Integer.parseInt(choice));
                newspaper.setTitle(title);
                newspaper.setPeriodicity(periodicity);
                newspaper.setPaidOrFree(paidOrFree);
                newspaperDao.update(newspaperList);
            } else {
                Viewer.output("Error");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            Viewer.output("Error");
            System.exit(0);
        }
    }
}
