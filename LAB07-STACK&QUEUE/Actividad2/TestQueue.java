package Actividad2;

import Actividad1.ExceptionIsEmpty;

public class TestQueue {
    public static void main(String[] args) {
        // Prueba con enteros
        Queue<Integer> colaEnteros = new QueueLink<>();
        try {
            // colaEnteros.enqueue(1);
           // colaEnteros.enqueue(2);
         //   colaEnteros.enqueue(3);
            System.out.println("Cola de enteros: " + colaEnteros);
            System.out.println("Frente de la cola de enteros: " + colaEnteros.front());
            colaEnteros.dequeue();
            System.out.println("Cola de enteros después de hacer dequeue: " + colaEnteros);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        // Prueba con cadenas
        Queue<String> colaCadenas = new QueueLink<>();
        try {
            //colaCadenas.enqueue("hola");
            //colaCadenas.enqueue("mundo");
            System.out.println("Cola de cadenas: " + colaCadenas);
            System.out.println("Frente de la cola de cadenas: " + colaCadenas.front());
            colaCadenas.dequeue();
            System.out.println("Cola de cadenas después de hacer dequeue: " + colaCadenas);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        // Prueba con caracteres
        Queue<Character> colaCaracteres = new QueueLink<>();
        try {
            //colaCaracteres.enqueue('a');
            //colaCaracteres.enqueue('b');
            //colaCaracteres.enqueue('c');
            System.out.println("Cola de caracteres: " + colaCaracteres);
            System.out.println("Frente de la cola de caracteres: " + colaCaracteres.front());
            colaCaracteres.dequeue();
            System.out.println("Cola de caracteres después de hacer dequeue: " + colaCaracteres);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}
