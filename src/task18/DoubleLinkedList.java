package task18;

import task18.abstraction.MyLinkedList;

public class DoubleLinkedList implements MyLinkedList {
    private Node head;
    private Node tail;

    @Override
    public boolean contains(String data) {
        Node current = head;
        while (current != null) {
            if (current.getValue().equals(data)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void remove(String data) {
        if (head.getValue().equals(data)) {
            head = head.getNext();
            head.setPrevious(null);
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.getNext().getValue().equals(data)) {
                current.setNext(current.getNext().getNext());
                current.getNext().setPrevious(current);
                return;
            }
            current = current.getNext();
        }
    }

    @Override
    public void insertBefore(String data) {
        Node current = new Node(data);
        if (head == null) {
            head = current;
            tail = head;
            return;
        }
        current.setNext(head);
        head.setPrevious(current);
        head = current;
    }

    @Override
    public void insertAfter(String data) {
        Node current = new Node(data);
        if (head == null) {
            head = current;
            tail = head;
            return;
        }
        tail.setNext(current);
        current.setPrevious(tail);
        tail = current;
    }

    @Override
    public Node find(String data) {
        Node current = head;
        while (current != null) {
            if (current.getValue().equals(data)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    @Override
    public void clear() {
        head = tail = null;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder res = new StringBuilder("");
        while (current != null) {
            res.append(current).append("\n");
            current = current.getNext();
        }
        return res.toString();
    }
}
