package Ejercicio1;

public class ListLinked<T extends Comparable<T>> implements TDAList<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }

        T getData() {
            return data;
        }

        void setData(T data) {
            this.data = data;
        }

        Node<T> getNext() {
            return next;
        }

        void setNext(Node<T> next) {
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

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
            if (current.data.compareTo(x) == 0) {
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
        Node<T> newNode = new Node<T>(x);
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
        if (head.data.compareTo(x)==0) {
            head = head.next;
            size--;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            if (current.next.data.compareTo(x)==0) {
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
    }

    public void insertOrdered(T x) {
        if (isEmptyList()) {
            insertFirst(x);
        } else if (x.compareTo(head.getData()) < 0) {
            insertFirst(x);
        } else if (x.compareTo(getLastNode().getData()) > 0) {
            insertLast(x);
        } else {
            Node<T> current = head;
            while (current.getNext() != null && x.compareTo(current.getNext().getData()) > 0) {
                current = current.getNext();
            }
            Node<T> newNode = new Node<>(x);
            newNode.setNext(current.getNext());
            current.setNext(newNode);
            size++;
        }
    } 

    private Node<T> getLastNode() {
        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data.toString()).append("\n");
            current = current.next;
        }
        return sb.toString();
    }

    public void removeNode(String string, String string2, int i) {
    }

}
