package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task22.catalog;

public class Test {
    public static void main(String[] args) {

        Catalog catalog = new Catalog();

        Catalog.Book book1 = catalog.new Book("Три товарища", "Ремарк");
        Catalog.Issue issue1 = catalog.new Issue(book1, "22.11.2017");
        Catalog.Issue issue2 = catalog.new Issue(book1, "29.03.2018");

        catalog.show();
    }
}
