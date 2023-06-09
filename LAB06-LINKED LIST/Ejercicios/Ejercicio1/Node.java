package Ejercicio1;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T data) {
        this(data, null);
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    // funcion para devolver la informacion almacenada en el nodo
    // poscondicion: devuelve informacion
    public String toString() {
        // aqui escribe tu codigo
        return "index" + getNext();
    }
}