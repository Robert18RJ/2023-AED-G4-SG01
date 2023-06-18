package ACTIVIDADES;

public class Node<E> {
    int data;
    Node<E> left;
    Node<E> right;
    int no_of_children;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
        this.no_of_children = 0;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node <E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    public int getNo_of_children() {
        return no_of_children;
    }

    public void setNo_of_children(int no_of_children) {
        this.no_of_children = no_of_children;
    }

    public boolean isLeaf() {
        return (no_of_children == 0);
    }

    public boolean isEmpty() {
        return (this == null);
    }
}