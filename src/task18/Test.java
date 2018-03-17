package task18;

public class Test {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        list.insertBefore("3");
        list.insertBefore("2");
        list.insertBefore("1");
        list.insertAfter("four");
        list.insertAfter("five");
        list.insertAfter("6");
        list.insertAfter("7");
        list.contains("four");
        list.find("five");

        System.out.println(list);
        System.out.println(list.contains("four"));
        System.out.println(list.find("five"));

        list.remove("four");
        list.remove("five");

        System.out.println(list);

        list.clear();

        list.insertAfter("new node");

        System.out.println(list);
    }
}
