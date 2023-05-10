package Actividad2;

import Actividad1.ExceptionIsEmpty;
import Actividad1.ExceptionFull;

public interface Queue<E> {
    void enqueue(E element) throws ExceptionIsEmpty, ExceptionFull;
    E dequeue() throws ExceptionIsEmpty;
    E front() throws ExceptionIsEmpty;
    E back() throws ExceptionIsEmpty;
    boolean isEmpty();
}
