package Ejercicio1;
public class TestPersonList {
    public static void main(String[] args) {
        ListLinked<Person> personList = new ListLinked<>();

        // Insertamos personas en orden alfabético por nombre
        personList.insertOrdered(new Person("Ana", "García", 25));
        personList.insertOrdered(new Person("Carlos", "López", 32));
        personList.insertOrdered(new Person("Juan", "Pérez", 18));
        personList.insertOrdered(new Person("María", "Fernández", 40));
        personList.insertOrdered(new Person("Pedro", "González", 50));

        // Imprimimos la lista completa
        System.out.println("Lista completa:");
        System.out.println(personList);

        // Eliminamos a la persona con nombre "Juan"
        System.out.println("\nEliminando a Juan:");
        personList.removeNode(new Person("Juan", "Pérez", 18));
        System.out.println(personList);

        // Buscamos a la persona con nombre "Ana"
        System.out.println("\nBuscando a Ana:");
        int position = personList.search(new Person("Ana", "García", 25));
        if (position != -1) {
            System.out.println("Encontrado en la posición " + position);
        } else {
            System.out.println("No se encontró a Ana");
        }

        // Destruimos la lista
        personList.destroyList();

        // Verificamos que la lista está vacía
        System.out.println("\n¿La lista está vacía? " + personList.isEmptyList());
    }
}
