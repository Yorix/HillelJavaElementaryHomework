package task22.catalog;

import java.util.LinkedList;

public class Catalog {
    private LinkedList<Book> books = new LinkedList<>();
    private LinkedList<Issue> issuance = new LinkedList<>();

    public void show() {
        for (Issue lending : issuance) {
            System.out.println(lending);
        }
    }


    public class Issue {
        private Book book;
        private String dateOfLending;

        public Issue(Book book, String dateOfLending) {
            this.book = book;
            this.dateOfLending = dateOfLending;
            issuance.add(this);
        }

        @Override
        public String toString() {
            return "Issue {book: " + book + "; date of lending: " + dateOfLending + "}";
        }
    }


    public class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            books.add(this);
        }

        @Override
        public String toString() {
            return title + " - " + author;
        }
    }
}
