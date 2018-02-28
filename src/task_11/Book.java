package task_11;

public class Book {
    private String title;
    private Author author;
    private int numberOfPages;


    public Book(String title, int numberOfPages, String authorsName, int yearOfBirth) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        author = new Author(authorsName, yearOfBirth);
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
