package com.yorix.hillel.java_elementary.task31;

import java.util.LinkedList;
import java.util.List;

class StudentsList {
    private List<Student> list;

    StudentsList(int size) {
        list = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            String name = (char) (Math.random() * 25 + 'A') + "name";
            int age = (int) (Math.random() * 10 + 16);

            list.add(new Student(name, age));
        }
    }

    List<Student> selectById() {
        FilterStudent filter = student -> student.getId() < 5;

        List<Student> resultList = new LinkedList<>();
        for (Student student : list) {
            if (filter.check(student))
                resultList.add(student);
        }
        return resultList;
    }

    List<Student> selectByAge() {
        FilterStudent filter = student -> student.getAge() < 19;

        List<Student> resultList = new LinkedList<>();
        for (Student student : list) {
            if (filter.check(student))
                resultList.add(student);
        }
        return resultList;
    }

    List<Student> selectByName() {
        FilterStudent filter = student -> student.getName().substring(0, 1).equalsIgnoreCase("a");

        List<Student> resultList = new LinkedList<>();
        for (Student student : list) {
            if (filter.check(student))
                resultList.add(student);
        }
        return resultList;
    }
}
