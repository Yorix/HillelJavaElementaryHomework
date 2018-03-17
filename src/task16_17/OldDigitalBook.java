package task16_17;

import task16_17.abstraction.Book;
import task16_17.abstraction.Digital;

public class OldDigitalBook extends Book implements Digital {

    public OldDigitalBook() {
        super("old digital", 2000);
    }

    @Override
    public String getContent() {
        return getTitle() + " - " + getYear();
    }

    @Override
    public void display() {
        System.out.println(getContent());
    }
}
