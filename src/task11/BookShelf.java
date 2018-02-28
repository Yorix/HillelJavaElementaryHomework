package task11;

public class BookShelf {
    private static int numOfShelves;
    private int id;
    private Book[] books;
    private int size = 20;
    private int filling;

    public BookShelf() {
        numOfShelves++;
        id = numOfShelves;
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
            System.arraycopy(books, index + 1, books, index, books.length - index - 1);
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
        StringBuilder stringBuilder = new StringBuilder("\n-------------------------------BookShelf " + id + "\n");
        int i = 0;
        while (books[i] != null) {
            stringBuilder.append(books[i]).append("\n");
            i++;
        }
        return stringBuilder.toString();
    }
}
