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

    public void removeFirst() {
        if (head == null) return;
        if (head == tail) {
            clear();
            return;
        }
        head = head.getNext();
        head.setPrevious(null);
        count--;
    }

    public void removeLast() {
        if (head == null) return;
        if (head == tail) {
            clear();
            return;
        }
        tail = tail.getPrevious();
        tail.setNext(null);
        count--;
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
}
