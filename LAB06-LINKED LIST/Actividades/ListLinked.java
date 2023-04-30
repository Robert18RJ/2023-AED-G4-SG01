package Actividades;

public class ListLinked<T> implements TDAList <T>{
    private Node<T> head;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    public boolean isEmptyList() {
        return head == null;
    }

    public int length() {
        return size;
    }

    public void destroyList() {
        head = null;
        size = 0;
    }

    public int search(T x) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(x)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public void insertFirst(T x) {
        Node<T> newNode = new Node<T>(x);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void insertLast(T x) {
        Node<T> newNode = new Node<>(x);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void removeNode(T x) {
        if (head == null) {
            return;
        }
        if (head.data.equals(x)) {
            head = head.next;
            size--;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.equals(x)) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }
}