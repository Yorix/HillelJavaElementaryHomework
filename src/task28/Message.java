package task28;

import task26.Book;

public class Message<T> {
    private T value;

    public Message() {
    }

    public Message(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public static void main(String[] args) {
        Message<String> stringMessage = new Message<>("String 1");
        Message<Integer> integerMessage = new Message<>(123);
        Message<Book> bookMessage = new Message<>();
        bookMessage.setValue(new Book("Золотой телёнок", "Ильф, Петров", 1933));

        System.out.println(stringMessage);
        System.out.println(integerMessage.getValue());
        System.out.println(bookMessage);
    }
}
