package com.yorix.hillel.java_elementary.task35_36;

import com.yorix.hillel.java_elementary.task34.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Utils {

    public static Optional<Double> averageSalaries(Stream<Employee> stream) {
        OptionalDouble average = stream.mapToDouble(Employee::getSalary).average();
        if (average.isPresent())
            return Optional.of(average.getAsDouble());
        else return Optional.empty();
    }

    public static List<Employee> getListFromStream(Stream<Employee> stream) {
        return stream.collect(Collectors.toList());
//        return Arrays.asList(stream.toArray(Employee[]::new));
    }
}
