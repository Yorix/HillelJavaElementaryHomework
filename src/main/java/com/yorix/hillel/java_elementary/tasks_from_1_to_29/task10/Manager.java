package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task10;

public class Manager extends Employee {

    public Manager() {
        super(Workplace.OFFICE);
    }

    public Manager(String name, long rate) {
        super(name, rate, Workplace.OFFICE);
    }

    public Manager(String name) {
        super(name, Workplace.OFFICE);
    }

    public Manager(long rate) {
        super(rate, Workplace.OFFICE);
    }
}
