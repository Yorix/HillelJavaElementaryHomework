package com.yorix.hillel.java_elementary.task37;

public class Employee {
    private String name;
    private long salary; // it holds in copeecs(cents).
    private int age;
    private Gender gender;
    private boolean married;

    public Employee(String name, long salary, int age, Gender gender, boolean married) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.gender = gender;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isMarried() {
        return married;
    }
}
