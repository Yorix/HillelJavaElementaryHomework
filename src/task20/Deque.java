package task20;

import task18.DoubleLinkedList;

public class Deque {
    private DoubleLinkedList list = new DoubleLinkedList();

    public boolean addFirst(String element) {
        list.insertBefore(element);
        return true;
    }

    public boolean addLast(String element) {
        list.insertAfter(element);
        return true;
    }

    public boolean removeFirst() {
        if (list.getHead() == null) return false;
        list.removeFirst();
        return true;
    }

    public boolean removeLast() {
        if (list.getHead() == null) return false;
        list.removeLast();
        return true;
    }

    public String peekFirst() {
        return list.getHead().getValue();
    }

    public String peekLast() {
        return list.getTail().getValue();
    }

    public String pop() {
        String value = list.getTail().getValue();
        list.removeLast();
        return value;
    }

    public String poll() {
        String value = list.getHead().getValue();
        list.removeFirst();
        return value;
    }

    public boolean contain(String element) {
        return list.contains(element);
    }

    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
