package by.epam.task3.core;

import java.io.*;
import java.util.Scanner;

public class Reader {

    public static String reader(String path) throws FileNotFoundException {
        StringBuilder string = new StringBuilder();
        Scanner in = new Scanner(new File(path));
        while (in.hasNext()) {
            string.append(in.nextLine()).append(" ");
        }
        return string.toString();
    }

}
