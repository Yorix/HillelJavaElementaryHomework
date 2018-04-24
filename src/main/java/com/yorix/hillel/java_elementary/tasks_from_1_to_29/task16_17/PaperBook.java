package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task16_17;

import com.yorix.hillel.java_elementary.tasks_from_1_to_29.task16_17.abstraction.Book;

public class PaperBook extends Book {

    public PaperBook() {
        super("paper", 1900);
    }

    @Override
    public String getContent() {
        return "IncompatibleBookFormat";
    }
}
