package task18;

public class DoubleLinkedList {
    private Node head;
    private Node tail;

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
    }

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
