package com.yorix.hillel.java_elementary.tasks_from_1_to_29.task20_21;

public class Deque {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(String element) {
        Node current = new Node(element);
        if (head == null) {
            head = tail = current;
            size++;
            return;
        }
        current.next = head;
        head.previous = current;
        head = current;
        size++;
    }

    public void addLast(String element) {
        Node current = new Node(element);
        if (head == null) {
            head = tail = current;
            size++;
            return;
        }
        current.previous = tail;
        tail.next = current;
        tail = current;
        size++;
    }

    public boolean removeFirst() {
        if (head == null) return false;
        if (head == tail) {
            head = tail = null;
            size--;
            return true;
        }
        head = head.next;
        head.previous = null;
        size--;
        return true;
    }

    public boolean removeLast() {
        if (tail == null) return false;
        if (head == tail) {
            head = tail = null;
            size--;
            return true;
        }
        tail = tail.previous;
        tail.next = null;
        size--;
        return true;
    }

    public String peekFirst() {
        if (head == null) return null;
        return head.value;
    }

    public String peekLast() {
        if (tail == null) return null;
        return tail.value;
    }

    public String pop() {
        String value = peekLast();
        removeLast();
        return value;
    }

    public String poll() {
        String value = peekFirst();
        removeFirst();
        return value;
    }

    public boolean contain(String element) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(element)) return true;
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Deque{");
        Node current = head;
        while (current != null) {
            builder.append(current).append(", ");
            current = current.next;
        }
        return builder.append("\b\b}").toString();
    }

    private static class Node {
        private String value;
        private Node previous;
        private Node next;

        private Node(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "\"" + value + "\"";
        }
    }
}
