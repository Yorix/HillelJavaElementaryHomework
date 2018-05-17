package com.yorix.hillel.java_elementary.task35_36;

import com.yorix.hillel.java_elementary.task34.Employee;
import com.yorix.hillel.java_elementary.task34.Gender;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import static com.yorix.hillel.java_elementary.task35_36.Utils.averageSalaries;
import static com.yorix.hillel.java_elementary.task35_36.Utils.getListFromStream;
import static org.junit.Assert.assertEquals;


public class UtilsTest {
    private static Stream<Employee> stream;

    @Before
    public void initStream() {
        stream = Stream.of(
                new Employee("1", 4_000_00L, 50, Gender.MALE, true),
                new Employee("2", 6_000_00L, 25, Gender.MALE, true));
    }

    @Test
    public void testAverageSalaries() {
        Optional<Double> average = Optional.of(5_000_00D);
        assertEquals(average, averageSalaries(stream));
    }
}