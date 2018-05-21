package com.yorix.hillel.java_elementary.task37;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ReaderFromFile {
    public static List<Employee> getEmployees(String filename) {
        List<Employee> resultList = new LinkedList<>();

        try (BufferedReader bfr = new BufferedReader(new FileReader(filename))) {
            String currentLine;
            while ((currentLine = bfr.readLine()) != null) {
                resultList.add(createEmployee(currentLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
            resultList = Collections.emptyList();
        }
        return resultList;
    }

    private static Employee createEmployee(String s) {
        String[] arrStr = s.split(", ");

        String name = arrStr[0].substring(1, arrStr[0].length() - 1);
        long salary = Long.valueOf(arrStr[1]) * 100;
        int age = Integer.valueOf(arrStr[2]);
        Gender gender = Gender.valueOf(arrStr[3].toUpperCase().substring(1, arrStr[3].length() - 1));
        boolean married = arrStr[4].equals("\"yes\"");

        return new Employee(name, salary, age, gender, married);
    }
}
