package com.yorix.hillel.java_elementary.task31;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentsListTest {

    private static StudentsList studentsList;

    @BeforeClass
    public static void init() {
        studentsList = new StudentsList(20);
    }

    @Test
    public void testSelectById() {
        assertEquals(1, studentsList.selectById().get(0).getId());
        assertEquals(2, studentsList.selectById().get(1).getId());
        assertEquals(3, studentsList.selectById().get(2).getId());
        assertEquals(4, studentsList.selectById().get(3).getId());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSelectByIdLength() {
        studentsList.selectById().get(4);
        fail("List is longer than expected.");
    }

    @Test
    public void testSelectByAge() {
        for (Student s : studentsList.selectByAge()) {
            assertTrue(s.getAge() < 19);
        }
    }

    @Test
    public void testSelectByName() {
        for (Student s : studentsList.selectByName()) {
            assertTrue(s.getName().substring(0, 1).equalsIgnoreCase("a"));
        }
    }
}