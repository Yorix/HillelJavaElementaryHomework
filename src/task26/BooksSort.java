package task26;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BooksSort {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<>();

        books.add(new Book("Сильмариллион", "Джон Толкиен", 1977));
        books.add(new Book("Властелин Колец", "Джон Толкиен", 1954));
        books.add(new Book("Хоббит", "Джон Толкиен", 1937));
        books.add(new Book("Элрик из Мелнибонэ", "Майкл Муркок", 1972));
        books.add(new Book("Тень над Иннсмутом", "Говард Лавкрафт", 1931));
        books.add(new Book("Музыка Эриха Цана", "Говард Лавкрафт", 1921));

        System.out.println(books);

        Collections.sort(books);

        System.out.println(books);
    }
}
