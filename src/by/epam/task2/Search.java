package by.epam.task2;

import java.io.*;
import java.util.*;

public class Search implements Menu, SelectItems, SetConditions, FindItem {

    public static void main(String[] args) {
        Search s = new Search();
        try {
            s.menu();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void searchMenu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String item, value;
        StringBuilder row;
        System.out.println("Select condition, you want to but, from current list:");
        item = selectConditions();
        System.out.println("Enter the value of " + item);
        value = scanner.next();
        row = findDescription(item, value);
        if (!(Objects.equals(row.toString(), ""))) {
            System.out.println(row);
            System.out.println("Do you wanna see more condition?\nfor the affirmative answer, enter yes");
            if ((scanner.next().equals("yes"))) {
                System.out.println("Select condition, you want to but, from current list:");
                item = selectConditions();
                System.out.println("Enter the value of " + item);
                value = scanner.next();
                findCertainDescription(row, value, item);
            }
        }
    }

    @Override
    public void menu() throws IOException {
        List<String> conditions;
        String item;
        int choice = 0;
        System.out.println("\n Select search conditions\n 1 - Items \n 2 - Conditions");
        Scanner scanner = new Scanner(System.in);
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Error: Invalid value");
            menu();
        }
        switch (choice) {
            case 1:
                System.out.println("Select item, you want to buy, from current list: ");
                item = selectItems();
                conditions = setConditions(item);
                findItem(item, conditions);
                break;
            case 2:
                searchMenu();
                break;
            default:
                System.out.println("Error");
        }

    }

    @Override
    public String selectItems() throws IOException {
        Set<String> items = new TreeSet<>();
        String row;

        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\by\\epam\\task2\\appliances_db.txt"));
        while ((row = br.readLine()) != null) {
            String[] getItem = row.split(":");
            items.add(getItem[0].toLowerCase());
        }
        for (String l_item : items)
            System.out.println(l_item);
        System.out.println("\nYour choice: ");
        br = new BufferedReader(new InputStreamReader(System.in));
        while (!items.contains((row = br.readLine().toLowerCase()))) {
            System.out.println("Incorrect choice! Repeat please!");
        }
        return row;
    }

    @Override
    public List<String> setConditions(String item) throws IOException {
        List<String> conditions = new ArrayList<>();
        String conditionList;
        BufferedReader br;
        String row;

        br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\by\\epam\\task2\\appliances_db.txt"));
        while (!(conditionList = br.readLine().toLowerCase()).contains(item)) {
        }
        System.out.println("\nExample of existing conditions: \n" + conditionList.toUpperCase().replace('_', ' '));
        System.out.println("\nPlease, enter some conditions of search (case insensitive)\n" + "P.S. q - for stop\n" + "    WARNING: if your " +
                "condition contains 2 words, please, enter them like in example row :WARNING");

        br = new BufferedReader(new InputStreamReader(System.in));
        while (!(row = br.readLine().toLowerCase()).equals("q")) {
            conditions.add(row);
        }
        return conditions;
    }

    @Override
    public void findItem(String item, List<String> conditions) throws IOException {
        BufferedReader br;
        String row;
        Boolean flag = true;

        br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\src\\by\\epam\\task2\\appliances_db.txt"));
        while ((row = br.readLine()) != null) {
            if (row.toLowerCase().contains(item)) {
                String[] existingConditions = row.split(":");
                existingConditions = existingConditions[1].split(",");
                Map<String, String> checkConditions = new TreeMap<>();
                for (String existingCondition : existingConditions) {
                    String[] forLoop = existingCondition.toLowerCase().replace(" ", "").split("=");
                    checkConditions.put(forLoop[0], forLoop[1]);
                }
                int countValidConditions = 0;
                for (String condition : conditions) {
                    String[] forloop = condition.split(" ");
                    if (forloop.length == 2) {
                        if (checkConditions.containsKey(forloop[0])) {
                            if (forloop[1].equals(checkConditions.get(forloop[0])))
                                countValidConditions++;
                        }
                    } else {
                        if (checkConditions.containsKey((forloop[0] + "_" + forloop[1]))) {
                            if (forloop[2].equals(checkConditions.get((forloop[0] + "_" + forloop[1]))))
                                countValidConditions++;
                        }
                    }
                }
                if (countValidConditions == conditions.size()) {
                    System.out.println("\nThe item for you can be:\n" + row);
                    flag = false;
                }
            }
        }
        if (flag)
            System.out.println("Sorry, there is on item fill your conditions.");
    }

    @Override
    public StringBuilder findDescription(String item, String value) throws IOException {
        String row;
        boolean flag = false;
        StringBuilder result = new StringBuilder();
        File f = new File(System.getProperty("user.dir") + "\\src\\by\\epam\\task2\\appliances_db.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));
        while ((row = fin.readLine()) != null) {
            if (row.toLowerCase().contains(item)) {
                if ((row.toLowerCase().contains(item + "=" + value + ",")
                        || (row.toLowerCase().contains(item + "=" + value + ";")))) {
                    result.append(row).append("\n");
                    flag = true;
                }
            }
        }
        if (!flag) {
            System.out.println("Empty");
        }
        return result;

    }

    @Override
    public void findCertainDescription(StringBuilder description, String value, String item) {
        boolean flag = false;
        String row = description.toString();
        String[] strings = row.split("\n");
        for (String string1 : strings) {
            if ((string1.toLowerCase().contains(item + "=" + value + ",")
                    || (string1.toLowerCase().contains(item + "=" + value + ";")))) {
                System.out.println(string1);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Empty");
        }
    }

    @Override
    public String selectConditions() throws IOException {
        Set<String> items = new HashSet<>();
        String row;
        File f = new File(System.getProperty("user.dir") + "\\src\\by\\epam\\task2\\appliances_db.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));
        while ((row = fin.readLine()) != null) {
            if (!(Objects.equals(row, ""))) {
                String[] existingConditions = row.split(":");
                String[] getItem = existingConditions[1].split(",");
                for (String aGetItem : getItem) {
                    String[] strings = aGetItem.toLowerCase().replace(" ", "").split("=");
                    items.add(strings[0]);
                }
            }
        }
        for (String item : items)
            System.out.println(item);
        System.out.println("\nYour choice: ");
        fin = new BufferedReader(new InputStreamReader(System.in));
        while (!items.contains((row = fin.readLine().toLowerCase()))) {
            System.out.println("Incorrect choice! Repeat please!");
        }
        return row;
    }
}
