package com.yorix.hillel.java_elementary.task35_36;

import com.yorix.hillel.java_elementary.task34.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Utils {

    public static long averageSalaries(Stream<Employee> stream) {
        LongStream salariesStream = stream.mapToLong(Employee::getSalary);
        return (long) salariesStream.average().getAsDouble();
    }

    public static List<Employee> getListFromStream(Stream<Employee> stream) {
        return Arrays.asList(stream.toArray(Employee[]::new));
    }
}
