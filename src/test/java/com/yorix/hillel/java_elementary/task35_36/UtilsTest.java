package com.yorix.hillel.java_elementary.task35_36;

import com.yorix.hillel.java_elementary.task34.Employee;
import com.yorix.hillel.java_elementary.task34.Gender;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.Stream;

import static com.yorix.hillel.java_elementary.task35_36.Utils.averageSalaries;
import static com.yorix.hillel.java_elementary.task35_36.Utils.getListFromStream;
import static org.junit.Assert.assertEquals;


public class UtilsTest {
    private static Stream<Employee> stream;

    @Before
    public void initStream() {
        stream = Stream.of(
                new Employee("1", 25_000L, 50, Gender.MALE, true),
                new Employee("2", 5_000L, 25, Gender.MALE, true));
    }

    @Test
    public void testAverageSalaries() {
        assertEquals(Optional.of(15_000.0), Optional.of(averageSalaries(stream)));
    }





    @Test
    public void testGetListFromStream1() {
        assertEquals(Employee.class, getListFromStream(stream).get(0).getClass());
    }

    @Test
    public void testGetListFromStream2() {
        assertEquals(2, getListFromStream(stream).size());
    }
}