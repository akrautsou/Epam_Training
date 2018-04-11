package by.epam.task1.entity;

public class GoodsFactory {
    public static IGoods getGoods(GoodsType type) {
        switch (type) {
            case OVEN:
                return new Oven();
            case LAPTOP:
                return new Laptop();
            case REFRIGERATOR:
                return new Refrigerator();
        }
        return null;
    }
}
