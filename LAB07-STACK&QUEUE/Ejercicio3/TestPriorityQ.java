package Ejercicio3;

import Actividad1.ExceptionIsEmpty;
import Actividad3.PriorityQueue;

public class TestPriorityQ {
    enum Priority {
        LOW,
        MEDIUM,
        HIGH
    }

    public static void main(String[] args) {
        PriorityQueue<String, Priority> queue = new PriorityQueueLinked<>(Priority.values().length);

        try {
            System.out.println("Añadiendo elementos a la cola...");
            queue.enqueue("Tarea de baja prioridad", Priority.LOW);
            queue.enqueue("Tarea de prioridad media", Priority.MEDIUM);
            queue.enqueue("Tarea de alta prioridad", Priority.HIGH);
            queue.enqueue("Otra tarea de alta prioridad", Priority.HIGH);
            System.out.println("Elementos añadidos.\n");

            System.out.println("Estado actual de la cola:\n" + queue + "\n");

            System.out.println("Primer elemento en la cola: \"" + queue.front() + "\"");
            System.out.println("Último elemento en la cola: \"" + queue.back() + "\"\n");

            System.out.println("Desencolando: \"" + queue.dequeue() + "\"");
            System.out.println("Estado de la cola después de desencolar:\n" + queue);

        } catch (ExceptionIsEmpty e) {
            e.printStackTrace();
        }
    }
}
