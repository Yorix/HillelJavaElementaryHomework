package com.yorix.hillel.java_elementary.task37;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static com.yorix.hillel.java_elementary.task37.ReaderFromFile.*;

public class ReaderFromFileTest {

    @Test
    public void TestGetEmployeesFromFile() {
        List<Employee> list = getEmployeesFromFile("input.csv");
        assertEquals(list.get(1).getName(), "Katerina Ivanenko");
    }
}