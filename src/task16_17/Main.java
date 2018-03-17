package task16_17;

import task16_17.abstraction.Book;
import task16_17.abstraction.Digital;
import task16_17.abstraction.ModernDigital;
import task16_17.abstraction.Searchable;

public class Main {
    public static void main(String[] args) {
        Book[] arrayOfBooks = new Book[7];

        Book book1 = new DigitalBook();
        Book book2 = new OldDigitalBook();
        Book book3 = new PaperBook();
        Book book4 = new DigitalBook();
        Book book5 = new OldDigitalBook();
        Book book6 = new PaperBook();
        Book book7 = new ModernDigitalBook();

        arrayOfBooks[0] = book1;
        arrayOfBooks[1] = book2;
        arrayOfBooks[2] = book3;
        arrayOfBooks[3] = book4;
        arrayOfBooks[4] = book5;
        arrayOfBooks[5] = book6;
        arrayOfBooks[6] = book7;

        for (Book book : arrayOfBooks) {
            if (book instanceof Digital) {
                ((Digital) book).display();
                if (book instanceof Searchable) {
                    System.out.println(((Searchable) book).found(""));
                }
            } else {
                System.out.println(book.getContent());
            }
        }
    }
}
