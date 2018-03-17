package task18;

import task18.abstraction.Element;

public class Node implements Element {
    private String value;
    private Node previous;
    private Node next;

    public Node(String data) {
        value = data;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String getValue() {
        return value;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return value;
    }
}
