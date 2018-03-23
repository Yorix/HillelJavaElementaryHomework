package task20;

public class Test {
    public static void main(String[] args) {
        Deque deque = new Deque();


        deque.addFirst("3");
        deque.addFirst("2");
        deque.addFirst("1");
        deque.addFirst("начало"); // добавить в начало
        deque.addLast("4");
        deque.addLast("5");
        deque.addLast("6");
        deque.addLast("конец"); // добавить в конец
        deque.removeFirst(); // удалить элемент из head без извлечения
        deque.removeLast(); // удалить элемент из tail без извлечения
        System.out.println(deque.peekFirst()); // получить первый не удаляя из очереди
        System.out.println(deque.peekLast()); // получить последний элемент не удаляя из очереди
        System.out.println(deque.pop()); // извлекает последний элемент (tail) из очереди и удаляет его
        System.out.println(deque.poll()); // извлекает первый элемент (head) из очереди и удаляет его
        System.out.println(deque.contain("3")); // проверяет наличие элемента в очереди
        System.out.println(deque.size()); // возвращает размер очереди

        System.out.println(deque);

    }
}
