package Actividad1;
//import java.util.Arrays;

public class StackArray<E> implements Stack<E> {
    private E[] arreglo;
    private int indiceTope;

    public StackArray(int n) {
        this.arreglo = (E[]) new Object[n];
        indiceTope = -1;
    }

    public void push(E x) {
        if (estaLlena()) {
            throw new IllegalStateException("La pila está llena");
        }
        arreglo[++indiceTope] = x;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        E elementoExtraido = arreglo[indiceTope];
        arreglo[indiceTope--] = null;
        return elementoExtraido;
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("La pila está vacía");
        }
        return arreglo[indiceTope];
    }

    public boolean isEmpty() {
        return indiceTope == -1;
    }

    public boolean estaLlena() {
        return indiceTope == arreglo.length - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = indiceTope; i >= 0; i--) {
            sb.append(arreglo[i]);
            if (i > 0) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}