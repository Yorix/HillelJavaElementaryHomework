package task26;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int yearOfPublication;

    public Book(String title, String author, int yearOfPublication) {
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                '\'' + title + '\'' +
                " : " + author +
                " : " + yearOfPublication +
                "}";
    }

    @Override
    public int compareTo(Book o) {
        return this.yearOfPublication - o.yearOfPublication;
    }
}
