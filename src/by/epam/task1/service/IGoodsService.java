package by.epam.task1.service;

import by.epam.task1.entity.IGoods;

import java.util.List;
import java.util.Map;

public interface IGoodsService<G extends IGoods> {
    Map<String, String> getSearchDataMap();
    void search(Map<String, String> map, List<G> list);
}
