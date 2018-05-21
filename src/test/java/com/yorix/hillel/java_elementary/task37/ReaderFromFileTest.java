package com.yorix.hillel.java_elementary.task37;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static com.yorix.hillel.java_elementary.task37.ReaderFromFile.*;

public class ReaderFromFileTest {

    @Test
    public void TestGetEmployees() {
        String path = ClassLoader.getSystemResource("input.csv").getFile();
        List<Employee> list = getEmployees(path);
        assertEquals(list.get(1).getName(), "Katerina Ivanenko");
    }
}