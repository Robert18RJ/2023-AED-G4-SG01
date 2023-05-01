package Actividades;

public class TestListLikend {
    public static void main(String[] args) {
        // Prueba con Integer
        System.out.println("--------------------Int-----------------------");
        System.out.println();
        ListLinked<Integer> intList = new ListLinked<>();
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

        
        System.out.println();
        //Prueba con String
        System.out.println("--------------------String-----------------------");
        System.out.println();
        ListLinked<String> strList = new ListLinked<>();
        strList.insertFirst("Hola");
        strList.insertLast("Mundo");
        strList.insertLast("!");
        
        System.out.println("--------------------isEmptyList-----------------------");
        System.out.println("La lista esta vacia?: " + strList.isEmptyList() );
        System.out.println();
        System.out.println("----------------------length--------------------------");
        System.out.println("Lista de enteros: " + strList.length() + " elementos");
        System.out.println();
        System.out.println("--------------------destroyList-----------------------");
        strList.destroyList();
        System.out.println();
        System.out.println("Lista esta vacia?: " + strList.isEmptyList());

        strList.insertFirst("Hola");
        strList.insertLast("Mundo");
        strList.insertLast("!");
        
        System.out.println();

        System.out.println("------------------------search-----------------------");
        System.out.println("El elemento 2 está en la posición " + strList.search("Mundo"));
        System.out.println();
        System.out.println("----------------------removeNode---------------------");
        strList.removeNode("!");
        System.out.println("Después de eliminar el elemento 2, la lista tiene " + strList.length() + " elementos");

    }
}