package task11;

public class Book {
    private String name;
    private Author author;
    private int numberOfPages;


    public Book(String name, int numberOfPages, String authorsName, int yearOfBirth) {
        this.name = name;
        this.numberOfPages = numberOfPages;
        author = new Author(authorsName, yearOfBirth);
    }

    public Book(String name, int numberOfPages, String authorsName) {
        this(name, numberOfPages, authorsName, 0);
    }

    public Book(String name, String authorsName, int yearOfBirth) {
        this(name, 0, authorsName, yearOfBirth);
    }

    public Book(String name, String authorsName) {
        this(name, authorsName, 0);
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return name.equals(book.name) &&
                author.equals(book.author);
    }

    @Override
    public String toString() {
        return numberOfPages > 0 ? name + " : " + author.getName() + " : " + numberOfPages + " pages" : name + " : " + author.getName();
    }
}
