package task16_17;

import task16_17.abstraction.Book;
import task16_17.abstraction.Digital;
import task16_17.abstraction.Searchable;

public class DigitalBook extends Book implements Searchable, Digital {

    public DigitalBook() {
        super("digital", 2010);
    }

    @Override
    public String getContent() {
        return getTitle() + " - " + getYear();
    }

    @Override
    public void display() {
        System.out.println(getContent());
    }

    @Override
    public int found(String text) {
        return (int) (Math.random() * 1001);
    }
}
