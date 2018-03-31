package task18;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int count = 0;

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

    public void remove(String data) {
        if (head.getValue().equals(data)) {
            head = head.getNext();
            head.setPrevious(null);
            count--;
            return;
        }
        if (tail.getValue().equals(data)) {
            tail = tail.getPrevious();
            tail.setNext(null);
            count--;
            return;
        }
        Node current = head;
        while (current != null) {
            if (current.getNext().getValue().equals(data)) {
                current.setNext(current.getNext().getNext());
                current.getNext().setPrevious(current);
                count--;
                return;
            }
            current = current.getNext();
        }
    }

    public void insertBefore(String data) {
        Node current = new Node(data);
        if (head == null) {
            head = tail = current;
            count++;
            return;
        }
        current.setNext(head);
        head.setPrevious(current);
        head = current;
        count++;
    }

    public void insertAfter(String data) {
        Node current = new Node(data);
        if (head == null) {
            head = tail = current;
            count++;
            return;
        }
        tail.setNext(current);
        current.setPrevious(tail);
        tail = current;
        count++;
    }

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

    public void clear() {
        head = tail = null;
        count = 0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int size() {
        return count;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder res = new StringBuilder("");
        while (current != null) {
            res.append("{").append(current).append("}");
            current = current.getNext();
        }
        return res.toString();
    }

    private static class Node {
        private String value;
        private Node previous;
        private Node next;

        private Node(String data) {
            value = data;
        }

        private void setPrevious(Node previous) {
            this.previous = previous;
        }

        private void setNext(Node next) {
            this.next = next;
        }

        private String getValue() {
            return value;
        }

        private Node getPrevious() {
            return previous;
        }

        private Node getNext() {
            return next;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
