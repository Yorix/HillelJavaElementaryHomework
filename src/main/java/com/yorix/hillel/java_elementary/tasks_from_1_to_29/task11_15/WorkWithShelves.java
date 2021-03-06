package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task11_15;

public class WorkWithShelves {
    public static void main(String[] args) {
        BookShelf shelf1 = new BookShelf();
        BookShelf shelf2 = new BookShelf();


        shelf1.put(new Book("Открытие себя", 304, "Владимир Савченко", 1933));
        shelf1.put(new Book("Террор", 896, "Дэн Симмонс", 1948));
        shelf1.put(new Book("Двухсотлетний человек", "Айзек Азимов", 1920));
        shelf1.put(new Book("Гиперион", 704, "Дэн Симмонс", 1948));
        shelf1.put(new Book("И пала ночь", "Айзек Азимов", 1920));
        shelf1.put(new Book("Террор", "Дэн Симмонс"));
        shelf1.put(new Book("Футурологический конгресс", 192, "Станислав Лем", 1921));
        shelf1.put(new Book("Открытие себя", 304, "Владимир Савченко"));
        shelf1.put(new Book("Час быка", 471, "Иван Ефремов", 1908));
        shelf1.put(new Book("Футурологический конгресс", 192, "Станислав Лем", 1921));



        System.out.println("shelves before separation:");
        System.out.println(shelf1 + "" + shelf2);

        separate(shelf1, shelf2);

        System.out.println("shelves after separation:");
        System.out.println(shelf1 + "" + shelf2);

        // TASK 15
        System.out.println("Total number of books: " + Book.getCounter());

    }

    public static void separate(BookShelf src, BookShelf rcp) {
        for (int i = 0; i < src.getFilling(); i++) {
            for (int j = i + 1; j < src.getFilling(); j++) {
                if (src.getBook(i).equals(src.getBook(j))) {
                    rcp.put(src.getBook(j));
                    src.remove(j);
                }
            }
        }
    }
}
