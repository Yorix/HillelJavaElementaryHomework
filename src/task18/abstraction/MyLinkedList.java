package task18.abstraction;

public interface MyLinkedList {
    boolean contains(String node); // проверить наличие данных
    void remove (String data); // удалить элемент
    void insertBefore(String data); // Вставить элемент перед head
    void insertAfter(String data); // Вставить элемент в конец списка tail
    Element find(String data); // поиск по данным
    void clear(); // удалить все элементы из списка

}
