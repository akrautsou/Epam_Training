package by.epam.task3.service;

import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.IGoods;

public interface IGoodsService<G extends IGoods> {
    Criteria getSearchCriteria();

    void search(Criteria criteria);

    void editor();
}
