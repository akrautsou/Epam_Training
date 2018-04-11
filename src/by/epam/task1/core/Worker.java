package by.epam.task1.core;

import by.epam.task1.entity.*;
import by.epam.task1.service.LaptopService;
import by.epam.task1.service.OvenService;
import by.epam.task1.service.RefrigeratorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Worker {
    private List<Oven> ovenList = new ArrayList<>();
    private List<Refrigerator> refrigeratorList = new ArrayList<>();
    private List<Laptop> laptopList = new ArrayList<>();
    private OvenService ovenService;
    private LaptopService laptopService;

    public LaptopService getLaptopService() {
        return laptopService;
    }

    public void setLaptopService(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    public RefrigeratorService getRefrigeratorService() {
        return refrigeratorService;
    }

    public void setRefrigeratorService(RefrigeratorService refrigeratorService) {
        this.refrigeratorService = refrigeratorService;
    }

    private RefrigeratorService refrigeratorService;

    public OvenService getOvenService() {
        return ovenService;
    }

    public void setOvenService(OvenService ovenService) {
        this.ovenService = ovenService;
    }

    public void addValue(String goodsType, String[] value) {
        IGoods iGoods = GoodsFactory.getGoods(GoodsType.valueOf(goodsType.toUpperCase()));
        assert iGoods != null;
        iGoods.setValues(value);
        if (iGoods instanceof Oven) {
            ovenList.add((Oven) iGoods);
        }
        if (iGoods instanceof Laptop) {
            laptopList.add((Laptop) iGoods);
        }
        if (iGoods instanceof Refrigerator) {
            refrigeratorList.add((Refrigerator) iGoods);
        }
    }

    public StringBuilder outputValue() {
        StringBuilder string = new StringBuilder();
        Object[] listOven = ovenList.toArray();
        for (Object listValue : listOven) {
            string.append(listValue);
        }
        Object[] listLaptop = laptopList.toArray();
        for (Object listValue : listLaptop) {
            string.append(listValue);
        }
        Object[] listRefrigerator = refrigeratorList.toArray();
        for (Object listValue : listRefrigerator) {
            string.append(listValue);
        }
        return string;
    }

    public void search(String goodsType, Map<String, String> map) {
        IGoods iGoods = GoodsFactory.getGoods(GoodsType.valueOf(goodsType.toUpperCase()));
        if (iGoods instanceof Oven) {
            ovenService.search(map, ovenList);
        }
        if (iGoods instanceof Laptop) {
            laptopService.search(map, laptopList);
        }
        if (iGoods instanceof Refrigerator) {
            refrigeratorService.search(map, refrigeratorList);
        }
    }
}
