package by.epam.task3.dao;

import by.epam.task3.core.Parser;
import by.epam.task3.core.Reader;
import by.epam.task3.entity.Oven;
import org.omg.CORBA.OBJ_ADAPTER;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataEngine {
    private static final String PATH = "c:\\Users\\Drico\\Documents\\IdeaProjects\\epam\\Epam_Training\\src" +
            "\\by\\epam\\task3\\files\\appliances_db.txt";
    private List<Map<String, Object>> dataList = new ArrayList<>();

    public void update(List<Map<String, Object>> list, String type){
        List<String> lines = null;
        List<String> resultList = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get(DataEngine.PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (lines != null) {
            for (String ln : lines) {
                ln = ln.toUpperCase();
                if (!ln.contains(type)) {
                    resultList.add(ln);
                }
            }
        }

        for(Map<String, Object> map : list){
            StringBuilder result = new StringBuilder(type + " : ");
            for (Map.Entry<String, Object> aValue: map.entrySet()) {
                result.append(aValue.getKey()).append("=").append(aValue.getValue()).append(", ");
            }
            result.delete(result.length() - 2, result.length());
            result.append(";");
            resultList.add(result.toString());
        }




        try (FileWriter writer = new FileWriter(DataEngine.PATH, false)) {
            for (String lin : resultList) {
                writer.write(lin + "\r\n");
            }

            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDB() throws FileNotFoundException {
        String string = Reader.reader(PATH);
        string = string.replaceAll(" ", "");
        String[] result = Parser.parseSemicolon(string);
        String[] value;
        for (String aResult : result) {
            String[] array = Parser.parseColon(aResult);
            value = Parser.parseComma(array[1]);
            addValue(array[0], value);
        }

    }

    private void addValue(String goodsType, String[] value) {
        Map<String, Object> mapValue = new HashMap<>();
        mapValue.put("type" , goodsType.toUpperCase());
        for (String aValue : value) {
            String[] array = Parser.parseEqually(aValue);
            mapValue.put(array[0].toUpperCase(), array[1]);
        }
        dataList.add(mapValue);
    }

    public List<Map<String, Object>> getRecords(String type) {
        List<Map<String, Object>> resultList = new ArrayList<>();
        for(Map<String, Object> mapValue : dataList){
           if(mapValue.get("type").equals(type.toUpperCase())){
               resultList.add(mapValue);
           }
        }
        return resultList;
    }
}
