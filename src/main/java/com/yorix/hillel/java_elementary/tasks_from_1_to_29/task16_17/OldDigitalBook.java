package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task16_17;

import com.yorix.hillel.java_elementary.tasks_from_1_to_29.task16_17.abstraction.Book;
import com.yorix.hillel.java_elementary.tasks_from_1_to_29.task16_17.abstraction.Digital;

public class OldDigitalBook extends Book implements Digital {

    public OldDigitalBook() {
        super("old digital", 2000);
    }

    @Override
    public String getContent() {
        return getTitle() + " - " + getYear();
    }

    @Override
    public void display() {
        System.out.println(getContent());
    }
}
