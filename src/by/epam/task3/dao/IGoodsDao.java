package by.epam.task3.dao;

import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.IGoods;
import by.epam.task3.entity.Laptop;

import java.util.List;

public interface IGoodsDao<G extends IGoods> {
    void save(G entity);
    void update(G entity);
    void delete(G entity);


    List<G> search(Criteria criteria);
}
