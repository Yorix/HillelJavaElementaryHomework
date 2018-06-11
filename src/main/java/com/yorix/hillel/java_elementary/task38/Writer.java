package com.yorix.hillel.java_elementary.task38;

import com.yorix.hillel.java_elementary.task37.Employee;

import java.io.*;
import java.util.List;

public class Writer {
    public void write(List<Employee> list) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("res/task38/output.csv"))) {
            for (Employee employee : list) {
                bufferedWriter.write(writeToString(employee));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String writeToString(Employee employee) {
        String salary = Long.toString(employee.getSalary());
        salary = salary.substring(0, salary.length() - 2);

        StringBuilder builder = new StringBuilder();
        builder
                .append("\"")
                .append(employee.getName())
                .append("\", ")
                .append(salary)
                .append(", ")
                .append(employee.getAge())
                .append(", \"")
                .append(employee.getGender().name().toLowerCase())
                .append("\", \"")
                .append(employee.isMarried() ? "yes" : "no")
                .append("\"\n");
        return builder.toString();
    }
}
