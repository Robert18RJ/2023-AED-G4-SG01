package Ejercicio1;

public class TestList {
    public static void main(String[] args) {
        // Prueba con Integer
        System.out.println("--------------------Prueba con enteros-----------------------");
        ListLinked<Integer> intList = new ListLinked<>();
        intList.insertFirst(1);
        intList.insertLast(2);
        intList.insertLast(3);
        intList.insertLast(4);
        intList.insertLast(5);
        
        System.out.println();

        System.out.println("------------------------search-----------------------");
        System.out.println("El elemento 3 está en la posición " + intList.search(3));
        System.out.println();
        System.out.println("----------------------removeNode---------------------");
        intList.removeNode(2);
        System.out.println("Después de eliminar n elemento , la lista tiene " + intList.length() + " elementos");
        System.out.println();
        
        //Prueba con String
        System.out.println("--------------------Prueba con cadena-----------------------");
        System.out.println();
        ListLinked<String> strList = new ListLinked<>();
        strList.insertFirst("Manzana");
        strList.insertLast("Limon");
        strList.insertLast("Naranja");
        strList.insertLast("Pera");
        System.out.println();

        System.out.println("------------------------search-----------------------");
        System.out.println("El elemento Naranja está en la posición " + strList.search("Naranja"));
        System.out.println();

        System.out.println("----------------------removeNode---------------------");
        strList.removeNode("Limon");
        System.out.println("Después de eliminar n elemento , la lista tiene " + strList.length() + " elementos");
        System.out.println();

        //Prueba con Double
        System.out.println("--------------------Numeros decimal-----------------------");
        System.out.println();
        ListLinked<Double> doubleList = new ListLinked<>();
        doubleList.insertFirst(1.0);
        doubleList.insertLast(2.5);
        doubleList.insertLast(3.8);

        System.out.println("------------------------search-----------------------");
        System.out.println("El elemento 2.5 está en la posición " + doubleList.search(2.5));
        System.out.println();

        System.out.println("----------------------removeNode---------------------");
        doubleList.removeNode(1.0);
        System.out.println("Después de eliminar n elemento , la lista tiene " + doubleList.length() + " elementos");
        System.out.println();
    }
}
