package com.yorix.hillel.java_elementary.tasks_from_1_to_29.binarytree;

public class BinaryTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    public void add(int data) {
        Node n = new Node(data);
        if (root == null) {
            root = n;
            return;
        }
        Node parent;
        Node current = root;
        while (true) {
            parent = current;
            if (data < current.getData()) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
            if (current == null) break;
        }
        if (data < parent.getData()) {
            parent.setLeft(n);
        } else {
            parent.setRight(n);
        }
    }

    public Node find(int data) {
        if (root == null) return null;
        Node current = root;

        while (current != null) {
            if (current.getData() == data) return current;
            if (data < current.getData())
                current = current.getLeft();
            else
                current = current.getRight();
        }
        return null;
    }

    public boolean remove(int data) {
        Node current = root;
        Node parent = current;
        while (current != null) {
            if (current.getData() == data) break;
            parent = current;
            if (data < current.getData())
                current = current.getLeft();
            else
                current = current.getRight();
        }
        if (current == null) return false;

        if (current.getData() < parent.getData()) {
            if (current.getRight() == null && current.getLeft() == null) {
                parent.setLeft(null);
                return true;
            }
            if (current.getLeft() != null && current.getRight() == null) {
                parent.setLeft(current.getLeft());
                return true;
            }
            if (current.getLeft() == null && current.getRight() != null) {
                parent.setLeft(current.getRight());
                return true;
            }
            if (current.getLeft() != null && current.getRight() != null) {
                parent.setLeft(searchInBranch(current));
            }
        } else {
            if (current.getRight() == null && current.getLeft() == null) {
                parent.setRight(null);
                return true;
            }
            if (current.getLeft() != null && current.getRight() == null) {
                parent.setRight(current.getLeft());
                return true;
            }
            if (current.getLeft() == null && current.getRight() != null) {
                parent.setRight(current.getRight());
                return true;
            }
            if (current.getLeft() != null && current.getRight() != null) {
                parent.setRight(searchInBranch(current));
            }
            return true;
        }
        return false;
    }

    private Node searchInBranch(Node root) {
        Node parent = root.getLeft();
        Node current = parent;
        while (current.getRight() != null) {
            parent = current;
            current = current.getRight();
        }
        parent.setRight(null);
        current.setLeft(root.getLeft());
        current.setRight(root.getRight());
        return current;
    }

    public int getMaxValue() {
        Node current = root;
        while (current.getRight() != null)
            current = current.getRight();
        return current.getData();
    }

    public int getMinValue() {
        Node current = root;
        while (current.getLeft() != null)
            current = current.getLeft();
        return current.getData();
    }

    public void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        node.show();
        inOrder(node.getRight());
    }

    public void reverseOrder(Node node) {
        if (node == null) {
            return;
        }
        reverseOrder(node.getRight());
        node.show();
        reverseOrder(node.getLeft());
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        node.show();
        inOrder(node.getLeft());
        inOrder(node.getRight());
    }

    public void postOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeft());
        inOrder(node.getRight());
        node.show();
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(30);
        binaryTree.add(20);
        binaryTree.add(45);
        binaryTree.add(15);
        binaryTree.add(25);
        binaryTree.add(40);
        binaryTree.add(60);
        binaryTree.add(5);
        binaryTree.add(17);
        binaryTree.add(22);
        binaryTree.add(28);
        binaryTree.add(35);
        binaryTree.add(43);
        binaryTree.add(57);
        binaryTree.add(90);
        binaryTree.add(95);

        System.out.println("In order traverse:");
        binaryTree.inOrder(binaryTree.getRoot());

        System.out.println("\nReverse order");
        binaryTree.reverseOrder(binaryTree.getRoot());

        System.out.println("\nPre order");
        binaryTree.preOrder(binaryTree.getRoot());

        System.out.println("\nPost order");
        binaryTree.postOrder(binaryTree.getRoot());

        System.out.println("\nMax element:");
        System.out.println(binaryTree.getMaxValue());

        System.out.println("\nMin element: ");
        System.out.println(binaryTree.getMinValue());

        System.out.println("Trying to find exist element element:");
        System.out.println(binaryTree.find(60));

        System.out.println("Trying to find not exist element: ");
        System.out.println(binaryTree.find(1000));

        System.out.println("Trying to remove an element, a leaf or last element that" +
                "has only one child: ");
        binaryTree.remove(20);
        System.out.println("and show again the new tree below: ");
        binaryTree.inOrder(binaryTree.getRoot());
    }
}
