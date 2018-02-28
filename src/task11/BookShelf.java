package task11;

public class BookShelf {
    private Book[] books;
    private int size = 50;
    private int filling;


    public BookShelf() {
        books = new Book[size];
    }

    public boolean put(Book book) {
        if (filling < size) {
            books[filling++] = book;
            return true;
        }
        return false;
    }

    public boolean remove(int index) {
        if (books[index] != null) {
            books[index] = null;
            filling--;
            return true;
        }
        return false;
    }

    public Book getBook(int index) {
        return books[index];
    }

    public int getFilling() {
        return filling;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (books[i] != null) {
            stringBuilder.append(books[i]).append("\n");
            i++;
        }
        return stringBuilder.toString();
    }


}
