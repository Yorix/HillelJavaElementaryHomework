package task23;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class Collections {
    public static void main(String[] args) {

        // 1
        System.out.println(reverse(123456798));


        // 2
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        LinkedHashSet<Integer> subSet1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> subSet2 = new LinkedHashSet<>();
        LinkedHashSet<Integer> subSet3 = new LinkedHashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        System.out.println(set);
        for (int i = 0; i < 6; i++) {
            subSet1.add(i);
            subSet2.add(i + 2);
            subSet3.add(i + 4);
        }
        System.out.println(subSet1);
        System.out.println(subSet2);
        System.out.println(subSet3);

        subSet1.retainAll(subSet3);
        System.out.println("subSet1.retainAll(subSet3): " + subSet1);
        subSet2.retainAll(subSet3);
        System.out.println("subSet2.retainAll(subSet3): " + subSet2);


        // 3
        LinkedList<Book> bookList = new LinkedList<>();
        bookList.add(new Book("Открытие себя", "Владимир Савченко"));
        bookList.add(new Book("Террор", "Дэн Симмонс"));
        bookList.add(new Book("Двухсотлетний человек", "Айзек Азимов"));
        bookList.add(new Book("Гиперион", "Дэн Симмонс"));
        bookList.add(new Book("И пала ночь", "Айзек Азимов"));
        bookList.add(new Book("Террор", "Дэн Симмонс"));
        bookList.add(new Book("Футурологический конгресс", "Станислав Лем"));
        bookList.add(new Book("Открытие себя", "Владимир Савченко"));
        bookList.add(new Book("Час быка", "Иван Ефремов"));
        bookList.add(new Book("Футурологический конгресс", "Станислав Лем"));
        System.out.println(bookList);

        LinkedHashSet<Book> bookSet = new LinkedHashSet<>(bookList);
        System.out.println(bookSet);


        // 5
        System.out.println(areBracketCorrect("(qwerty) [qwerty] {qwerty} ( ][ ) "));
    }


    // 1
    private static int reverse(int integer) {
        LinkedList<Character> stack = new LinkedList<>();
        char[] intToChar = Integer.toString(integer).toCharArray();

        for (char c : intToChar) {
            stack.push(c);
        }

        StringBuilder reverse = new StringBuilder();
        while (!stack.isEmpty()) {
            reverse.append(stack.poll());
        }

        return Integer.parseInt(reverse.toString());
    }

    // 5
    private static boolean areBracketCorrect(String expression) {
        LinkedList<String> stack2 = new LinkedList<>();

        for (char c : expression.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack2.add(Character.toString(c));
                    break;
                case ')':
                    if (stack2.isEmpty() || !stack2.pollLast().equals("(")) {
                        System.out.println("Unpaired closing bracket!");
                        return false;
                    }
                    break;
                case ']':
                    if (stack2.isEmpty() || !stack2.pollLast().equals("[")) {
                        System.out.println("Unpaired closing bracket!");
                        return false;
                    }
                    break;
                case '}':
                    if (stack2.isEmpty() || !stack2.pollLast().equals("{")) {
                        System.out.println("Unpaired closing bracket!");
                        return false;
                    }
            }

        }
        if (!stack2.isEmpty()) {
            System.out.println("Unpaired opening bracket!");
            return false;
        }
        return true;
    }

    private static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Book)) return false;

            Book book = (Book) o;

            if (title != null ? !title.equals(book.title) : book.title != null) return false;
            return author != null ? author.equals(book.author) : book.author == null;
        }

        @Override
        public int hashCode() {
            int result = title != null ? title.hashCode() : 0;
            result = 31 * result + (author != null ? author.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return title + " - " + author;
        }
    }
}
