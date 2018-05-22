package com.yorix.hillel.java_elementary.task37;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static com.yorix.hillel.java_elementary.task37.Reader.*;

public class ReaderTest {

    @Test
    public void TestGetEmployees() {
        String path = ClassLoader.getSystemResource("input.csv").getFile();
        List<Employee> list = read(path);
        assertEquals(list.get(1).getName(), "Katerina Ivanenko");
    }
}