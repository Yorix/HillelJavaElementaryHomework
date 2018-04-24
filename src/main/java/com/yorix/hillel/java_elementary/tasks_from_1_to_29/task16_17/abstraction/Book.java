package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task16_17.abstraction;

public abstract class Book {
    private String title;
    private int year;

    public Book(String title, int year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public abstract String getContent();
}
