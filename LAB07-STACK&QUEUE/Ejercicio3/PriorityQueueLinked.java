package Ejercicio3;

import Actividad1.ExceptionIsEmpty;
import Actividad2.QueueLink;
import Actividad3.PriorityQueue;

public class PriorityQueueLinked<E, P extends Enum<P> & Comparable<P>> implements PriorityQueue<E, P>{

    private QueueLink<E>[] queues;
    private int priorities;

    public PriorityQueueLinked(int priorities) {
        this.priorities = priorities;
        this.queues = (QueueLink<E>[]) new QueueLink[priorities];
        for (int i = 0; i < priorities; i++) {
            queues[i] = new QueueLink<>();
        }
    }
    
    public void enqueue(E x, P pr) {
        int index = pr.ordinal();
        if (index >= 0 && index < priorities) {
            queues[index].enqueue(x);
        } else {
            throw new IllegalArgumentException("Invalid priority: " + pr);
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (QueueLink<E> queue : queues) {
            if (!queue.isEmpty()) {
                return queue.dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cannot remove from an empty priority queue");
    }

    public E front() throws ExceptionIsEmpty {
        for (QueueLink<E> queue : queues) {
            if (!queue.isEmpty()) {
                return queue.front();
            }
        }
        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    public E back() throws ExceptionIsEmpty {
        for (int i = queues.length - 1; i >= 0; i--) {
            if (!queues[i].isEmpty()) {
                return queues[i].back();
            }
        }
        throw new ExceptionIsEmpty("Priority queue is empty");
    }

    public boolean isEmpty() {
        for (QueueLink<E> queue : queues) {
            if (!queue.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < queues.length; i++) {
            sb.append("Priority ").append(i).append(": ");
            sb.append(queues[i].toString());
            if (i < queues.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}