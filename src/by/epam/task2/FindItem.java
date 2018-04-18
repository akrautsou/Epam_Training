package by.epam.task2;

import java.io.IOException;
import java.util.List;

public interface FindItem {
    void findItem(String item, List<String> conditions) throws IOException;
    StringBuilder findDescription(String item, String value) throws IOException;
    void findCertainDescription(StringBuilder description, String value, String item);

}
