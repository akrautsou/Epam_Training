package by.epam.task3.service;

import by.epam.task3.core.Viewer;
import by.epam.task3.dao.OvenDao;
import by.epam.task3.entity.Criteria;
import by.epam.task3.entity.Oven;

import java.util.List;
import java.util.Scanner;

public class OvenService implements IGoodsService<Oven> {
    private OvenDao ovenDao = new OvenDao();

    @Override
    public Criteria getSearchCriteria() {
        Scanner scanner = ServiceFactory.getInstance().getScanner();
        Criteria criteria = new Criteria("Oven".toUpperCase());
        Viewer.output(Oven.POWER_CONSUMPTION + "= ");
        criteria.add(Oven.POWER_CONSUMPTION, scanner.nextLine());
        Viewer.output(Oven.WEIGHT + "= ");
        criteria.add(Oven.WEIGHT, scanner.nextLine());
        Viewer.output(Oven.CAPACITY + "= ");
        criteria.add(Oven.CAPACITY, scanner.nextLine());
        Viewer.output(Oven.DEPTH + "= ");
        criteria.add(Oven.DEPTH, scanner.nextLine());
        Viewer.output(Oven.HEIGHT + "= ");
        criteria.add(Oven.HEIGHT, scanner.nextLine());
        Viewer.output(Oven.WIDTH + "= ");
        criteria.add(Oven.WIDTH, scanner.nextLine());
        return criteria;
    }

    @Override
    public void search(Criteria criteria) {
        List<Oven> goodsList = ovenDao.search(criteria);
        for (Oven anGoodsList : goodsList) {
            Viewer.output(anGoodsList);
        }
    }

    @Override
    public void editor() {
        List<Oven> ovenList = ovenDao.search(new Criteria("Oven".toUpperCase()));
        for (int i = 0; i < ovenList.size(); i++) {
            Viewer.output(i + " - " + ovenList.get(i) + "");
        }
        Viewer.output("Choice");
        String choice = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("POWER_CONSUMPTION");
        String powerConsumption = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("WEIGHT");
        String weight = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("CAPACITY");
        String capacity = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("DEPTH");
        String depth = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("HEIGHT");
        String height = ServiceFactory.getInstance().getScanner().nextLine();
        Viewer.output("WIDTH");
        String width = ServiceFactory.getInstance().getScanner().nextLine();
        try {
            if (ovenList.size() > Integer.parseInt(choice)) {
                Oven oven = ovenList.get(Integer.parseInt(choice));
                oven.setCapacity(Double.valueOf(capacity));
                oven.setDepth(Double.valueOf(depth));
                oven.setHeight(Double.valueOf(height));
                oven.setPowerConsumption(Double.valueOf(powerConsumption));
                oven.setWeight(Double.valueOf(weight));
                oven.setWidth(Double.valueOf(width));
                ovenDao.update(ovenList);
            } else {
                Viewer.output("Error");
                System.exit(0);
            }
        } catch (NumberFormatException e) {
            Viewer.output("Error");
            System.exit(0);
        }
    }


//    @Override
//    public void editor(Criteria searchCriteria) {
//        String result = searchCriteria.getType() + " : "
//                + Oven.POWER_CONSUMPTION + "=" + searchCriteria.getCriteria().get(Oven.POWER_CONSUMPTION) + ", "
//                + Oven.WEIGHT + "=" + searchCriteria.getCriteria().get(Oven.WEIGHT) + ", "
//                + Oven.CAPACITY + "=" + searchCriteria.getCriteria().get(Oven.CAPACITY) + ", "
//                + Oven.DEPTH + "=" + searchCriteria.getCriteria().get(Oven.DEPTH) + ", "
//                + Oven.HEIGHT + "=" + searchCriteria.getCriteria().get(Oven.HEIGHT) + ", "
//                + Oven.WIDTH + "=" + searchCriteria.getCriteria().get(Oven.WIDTH) + ";";
//        //Oven : POWER_CONSUMPTION=1000, WEIGHT=10, CAPACITY=32, DEPTH=60, HEIGHT=45.5, WIDTH=59.5;
//        result = result.replace("{", "").replace("}", "");
//
//        System.out.println(result);
//        List<String> lines = null;
//        List<String> resultList = new ArrayList<>();
//        try {
//            lines = Files.readAllLines(Paths.get(DataEngine.PATH));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        if (lines != null) {
//            for (String ln : lines) {
//                ln = ln.toUpperCase();
//                if (ln.contains(result)) {
//                    System.out.println(result);
//                    ln = ln.replaceAll(result, need);
//                }
//                resultList.add(ln);
//            }
//        }
//        System.out.println();
//        try (FileWriter writer = new FileWriter(DataEngine.PATH, false)) {
//            for (String lin : resultList) {
//                writer.write(lin + "\r\n");
//            }
//
//            writer.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
}