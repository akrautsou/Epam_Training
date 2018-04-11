package by.epam.task1;

import by.epam.task1.core.*;
import by.epam.task1.service.LaptopService;
import by.epam.task1.service.OvenService;
import by.epam.task1.service.RefrigeratorService;

import java.io.IOException;

public class MainFirstTask {
    private static final String PATH = "c:\\Users\\Drico\\Documents\\IdeaProjects\\epam\\Epam_Training\\src" +
            "\\by\\epam\\task1\\files\\appliances_db.txt";

    public static void main(String[] args) throws IOException {
        OvenService ovenService = new OvenService();
        LaptopService laptopService = new LaptopService();
        RefrigeratorService refrigeratorService = new RefrigeratorService();
        Worker worker = new Worker();
        worker.setOvenService(ovenService);
        worker.setLaptopService(laptopService);
        worker.setRefrigeratorService(refrigeratorService);
        Menu menu = new Menu();
        menu.setOvenService(ovenService);
        menu.setLaptopService(laptopService);
        menu.setRefrigeratorService(refrigeratorService);
        menu.setWorker(worker);
        String string = Reader.reader(PATH);
        string = string.replaceAll(" ", "");
        String[] result = Parser.parseSemicolon(string);
        String[] value;
        for (String aResult : result) {
            String[] array = Parser.parseColon(aResult);
            value = Parser.parseComma(array[1]);
            worker.addValue(array[0], value);
        }
        Viewer.output(worker.outputValue());
        menu.menuFirst();

    }
}
