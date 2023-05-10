package Ejercicio2;

import Actividad1.ExceptionIsEmpty;
import Actividad2.Queue;
import Actividad1.ExceptionFull;

public class TestQueueArray {
    public static void main(String[] args) {
        Queue<String> queue = new QueueArray<>(10);

        try {
            queue.enqueue("Persona 1");
            queue.enqueue("Persona 2");
            queue.enqueue("Persona 3");
            queue.enqueue("Persona 4");
            queue.enqueue("Persona 5");

            System.out.println("Primera persona en la cola: " + queue.front()); // Debería imprimir "Persona 1"
            System.out.println("Primera persona en ser atendida y sale de la cola: " + queue.dequeue()); // Debería imprimir "Persona 1"

            System.out.println("Nueva primera persona en la cola después de atender a la primera: " + queue.front());  // Debería imprimir "Persona 2"

            queue.enqueue("Persona 6");
            queue.enqueue("Persona 7");
            queue.enqueue("Persona 8");
            queue.enqueue("Persona 9");
            queue.enqueue("Persona 10");
            queue.enqueue("Persona 11");  // Como la capacidad máxima de la cola es 10, intentar añadir una persona más lanzará la excepción ExceptionFull

        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        } catch (ExceptionFull e) {
            e.printStackTrace();
        }
    }
}
