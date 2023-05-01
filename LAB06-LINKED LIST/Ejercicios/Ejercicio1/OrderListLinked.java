package Ejercicio1;

class OrderListLinked<T extends Comparable<T>> extends ListLinked <T> {

    private Node<T> first;
    private Node<T> head;
    private int size;
    

    public OrderListLinked() {
        super();
    }

        
    public int search(T item) {
        Node<T> aux = this.first;
        int index = 0;
        while (aux != null && aux.getData().compareTo(item) != 0) {
            aux = aux.getNext();
            index++;
        }
        if (aux != null) {
            return index;
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

// b. ¿Cuáles métodos de la clase ListLinked no serían pertinentes usar en la una lista del
//tipo OrderListLinked?
//En una lista enlazada de tipo OrderListLinked, algunos métodos de la ListLinkedclase pueden no ser pertinentes ya que no mantienen el orden de la lista. Por ejemplo, el add()método de la ListLinkedclase agrega un elemento al final de la lista, que puede no mantener el orden de la lista en una lista enlazada ordenada. De manera similar, el remove()método de la ListLinkedclase elimina un elemento de la lista sin considerar el orden de la lista, lo que puede no mantener el orden de la lista en una lista enlazada ordenada.
//Otros métodos de la ListLinkedclase, como get(), set()y size(), aún pueden ser útiles en una lista enlazada ordenada ya que no modifican el orden de la lista.
//En general, los métodos de la ListLinkedclase que modifican el orden de la lista, como add()y remove(), pueden no ser pertinentes para usar en una lista enlazada ordenada de tipo OrderListLinked.
