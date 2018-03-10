package task11_15;

public class Book {
    private String title;
    private Author author;
    private int numberOfPages;
    private static int counter; // TASK 15


    public Book(String title, int numberOfPages, String authorsName, int yearOfBirth) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        author = new Author(authorsName, yearOfBirth);
        counter++; // TASK 15
    }

    public Book(String title, int numberOfPages, String authorsName) {
        this(title, numberOfPages, authorsName, 0);
    }

    public Book(String title, String authorsName, int yearOfBirth) {
        this(title, 0, authorsName, yearOfBirth);
    }

    public Book(String title, String authorsName) {
        this(title, authorsName, 0);
    }

    public Author getAuthor() {
        return author;
    }

    // TASK 15
    public static int getCounter() {
        return counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return title.equals(book.title) &&
                author.equals(book.author);
    }

    @Override
    public String toString() {
        return numberOfPages > 0 ? title + " : " + author.getName() + " : " + numberOfPages + " pages" : title + " : " + author.getName();
    }
}
