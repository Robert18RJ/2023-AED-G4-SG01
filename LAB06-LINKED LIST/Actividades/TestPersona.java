package Actividades;

public class TestPersona {
    public static void main(String[] args) {
        // Creamos una lista de arreglos que almacena objetos Person
        ListArray<Person> arrList = new ListArray<>(10);

        // Agregamos objetos Person a la lista
        arrList.insertLast(new Person("Juan", "Pérez", 30));
        arrList.insertLast(new Person("María", "Gómez", 25));
        arrList.insertLast(new Person("Pedro", "López", 40));

        // Imprimimos el tamaño de la lista
        System.out.println("Tamaño de la lista de arreglos: " + arrList.length());

        // Buscamos una persona en la lista
        Person person = new Person("Juan", "Pérez", 30);
        int pos = arrList.search(person);
        if (pos != -1) {
            System.out.println("La persona " + person.getNombre() + " " + person.getApellidos() + " está en la posición " + pos);
        } else {
            System.out.println("La persona " + person.getNombre() + " " + person.getApellidos() + " no está en la lista");
        }

        // Eliminamos una persona de la lista
        arrList.removeNode(person);

        // Imprimimos el tamaño de la lista después de eliminar una persona
        System.out.println("Tamaño de la lista de arreglos después de eliminar una persona: " + arrList.length());

        // Creamos una lista enlazada que almacena objetos Person
        ListLinked<Person> linkedList = new ListLinked<>();

        // Agregamos objetos Person a la lista
        linkedList.insertLast(new Person("Ana", "Sánchez", 28));
        linkedList.insertLast(new Person("Carlos", "Martínez", 35));
        linkedList.insertLast(new Person("Laura", "García", 22));

        // Imprimimos el tamaño de la lista
        System.out.println("Tamaño de la lista enlazada: " + linkedList.length());

        // Buscamos una persona en la lista
        person = new Person("Ana", "Sánchez", 28);
        pos = linkedList.search(person);
        if (pos != -1) {
            System.out.println("La persona " + person.getNombre() + " " + person.getApellidos() + " está en la posición " + pos);
        } else {
            System.out.println("La persona " + person.getNombre() + " " + person.getApellidos() + " no está en la lista");
        }

        // Eliminamos una persona de la lista
        linkedList.removeNode(person);

        // Imprimimos el tamaño de la lista después de eliminar una persona
        System.out.println("Tamaño de la lista enlazada después de eliminar una persona: " + linkedList.length());
    }
}
