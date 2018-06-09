package com.yorix.hillel.java_elementary.task38;

import com.yorix.hillel.java_elementary.task37.Employee;
import com.yorix.hillel.java_elementary.task37.Reader;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        String path = getPathToResource("input.csv");
        List<Employee> list = Reader.read(path);

        list.stream()
                .filter(employee -> employee.getAge() > 25)
                .peek(employee -> employee.setSalary(employee.getSalary() + 250_00))
                .filter(employee -> employee.getAge() > 30)
                .forEach(employee -> employee.setSalary(employee.getSalary() + 250_00));

        Writer writer = new Writer();
        writer.write(list);
    }

    private static String getPathToResource(String fileName) {
        URI uri;
        try {
            uri = ClassLoader.getSystemResource(fileName).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return fileName;
        }
        return Paths.get(uri).toString();
    }
}
