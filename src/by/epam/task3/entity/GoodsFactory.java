package by.epam.task3.entity;

public class GoodsFactory {
    public static IGoods getGoods(GoodsType type) {
        switch (type) {
            case OVEN:
                return new Oven();
            case LAPTOP:
                return new Laptop();
            case REFRIGERATOR:
                return new Refrigerator();
            case VACUUMCLEANER:
                return new VacuumCleaner();
            case TABLETPC:
                return new TabletPC();
            case SPEAKERS:
                return new Speakers();
            case TEXTBOOK:
                return new TextBook();
            case NEWSPAPER:
                return new Newspaper();
        }
        return null;
    }
}
