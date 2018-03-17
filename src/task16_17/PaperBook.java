package task16_17;

import task16_17.abstraction.Book;

public class PaperBook extends Book {

    public PaperBook() {
        super("paper", 1900);
    }

    @Override
    public String getContent() {
        return "IncompatibleBookFormat";
    }
}
