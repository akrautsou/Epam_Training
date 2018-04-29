package by.epam.task3.dao;

import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Oven;
import by.epam.task3.entity.TextBook;
import by.epam.task3.service.ServiceFactory;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TextBookDao implements IGoodsDao<TextBook> {
    @Override
    public void save(TextBook entity) {

    }

    @Override
    public void update(List<TextBook> entity) {
        List<Map<String, Object>> list = new ArrayList<>();
        for(TextBook anEntity: entity){
            list.add(anEntity.getValues());
        }
        ServiceFactory.getInstance().getDbEngine().update(list, "TextBook".toUpperCase());
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
            if (criteria.getCriteria().isEmpty() || (goods.isTitleContains(criteria.getCriteria().get(TextBook.TITLE).toString())
                    && goods.isSubjectContains(criteria.getCriteria().get(TextBook.SUBJECT).toString())
                    && goods.isAuthorContains(criteria.getCriteria().get(TextBook.AUTHOR).toString())
                    && goods.isNumberOfPagesContains(criteria.getCriteria().get(TextBook.NUMBER_OF_PAGES).toString()))) {
                resultList.add(goods);
            }

        }
        return resultList;
    }
}
