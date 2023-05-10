package Ejercicio1;

import Actividad1.ExceptionIsEmpty;

public class Test {

    public static void main(String[] args) throws ExceptionIsEmpty {
        StackLink<Integer> stack1 = new StackLink<Integer>();
        StackLink<String> stack2 = new StackLink<String>();

        // Insertar elementos en la pila de enteros
        stack1.push(10);
        stack1.push(20);
        stack1.push(30);
        System.out.println("Pila de enteros: " + stack1);

        // Eliminar elementos de la pila de enteros
        stack1.pop();
        System.out.println("Pila de enteros después de eliminar un elemento: " + stack1);

        // Obtener el elemento superior de la pila de enteros
        System.out.println("Elemento superior de la pila de enteros: " + stack1.top());

        // Insertar elementos en la pila de cadenas
        stack2.push("Hola");
        stack2.push("Mundo");
        stack2.push("!");
        System.out.println("Pila de cadenas: " + stack2);

        // Eliminar elementos de la pila de cadenas
        stack2.pop();
        System.out.println("Pila de cadenas después de eliminar un elemento: " + stack2);

        // Obtener el elemento superior de la pila de cadenas
        System.out.println("Elemento superior de la pila de cadenas: " + stack2.top());
    }
}
