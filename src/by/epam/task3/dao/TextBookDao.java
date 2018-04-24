package by.epam.task3.dao;

import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.TextBook;
import by.epam.task3.service.ServiceFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextBookDao implements IGoodsDao<TextBook> {
    @Override
    public void save(TextBook entity) {

    }

    @Override
    public void update(TextBook entity) {

    }

    @Override
    public void delete(TextBook entity) {

    }

    @Override
    public List<TextBook> search(Criteria criteria) {
        List<Map<String, Object>> list = ServiceFactory.getInstance().getDbEngine().
                getRecords(criteria.getType());
        List<TextBook> resultList = new ArrayList<>();
        for (Map<String, Object> mapValue : list) {
            TextBook goods = new TextBook();
            goods.setValues(mapValue);
            if (goods.isTitleContains(criteria.getCriteria().get(TextBook.TITLE).toString())
                    && goods.isSubjectContains(criteria.getCriteria().get(TextBook.SUBJECT).toString())
                    && goods.isAuthorContains(criteria.getCriteria().get(TextBook.AUTHOR).toString())
                    && goods.isNumberOfPagesContains(criteria.getCriteria().get(TextBook.NUMBER_OF_PAGES).toString())) {
                resultList.add(goods);
            }

        }
        return resultList;
    }
}
