package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task10;

public class Worker extends Employee {

    public Worker() {
        super(Workplace.STORE);
    }

    public Worker(String name, long rate) {
        super(name, rate, Workplace.STORE);
    }

    public Worker(String name) {
        super(name, Workplace.STORE);
    }

    public Worker(long rate) {
        super(rate, Workplace.STORE);
    }
}
