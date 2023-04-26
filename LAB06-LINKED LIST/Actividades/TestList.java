package Actividades;
public class TestList {
    public static void main(String[] args) {
        // Prueba con Integer
        ListArray<Integer> intList = new ListArray<>();
        intList.insertFirst(1);
        intList.insertLast(2);
        intList.insertLast(3);

        System.out.println("--------------------isEmptyList-----------------------");
        System.out.println("La lista esta vacia?: " + intList.isEmptyList() );
        System.out.println();
        System.out.println("----------------------length--------------------------");
        System.out.println("Lista de enteros: " + intList.length() + " elementos");
        System.out.println();
        System.out.println("--------------------destroyList-----------------------");
        intList.destroyList();
        System.out.println();
        System.out.println("Lista esta vacia?: " + intList.isEmptyList());

        intList.insertFirst(1);
        intList.insertLast(2);
        intList.insertLast(3);
        
        System.out.println();

        System.out.println("------------------------search-----------------------");
        System.out.println("El elemento 2 está en la posición " + intList.search(3));
        System.out.println();
        System.out.println("----------------------removeNode---------------------");
        intList.removeNode(2);
        System.out.println("Después de eliminar el elemento 2, la lista tiene " + intList.length() + " elementos");

        
        // Prueba con String
        // ListArray<String> strList = new ListArray<>();
        // strList.insertFirst("Hola");
        // strList.insertLast("Mundo");
        // strList.insertLast("!");
        // System.out.println("Lista de cadenas: " + strList.length() + " elementos");
        // System.out.println("El elemento \"Mundo\" está en la posición " + strList.search("Mundo"));
        // strList.removeNode("Mundo");
        // System.out.println("Después de eliminar el elemento \"Mundo\", la lista tiene " + strList.length() + " elementos");
    }
}