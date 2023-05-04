package Actividad1;

public class Test {
    public static void main(String[] args) {
        // Prueba con enteros
        Stack<Integer> pilaEnteros = new StackArray<>(5);
        try {
            pilaEnteros.push(1);
            pilaEnteros.push(2);
            pilaEnteros.push(3);
            System.out.println("Pila de enteros: " + pilaEnteros);
            System.out.println("Tope de la pila de enteros: " + pilaEnteros.top());
            pilaEnteros.pop();
            System.out.println("Pila de enteros después de hacer pop: " + pilaEnteros);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        // Prueba con cadenas
        Stack<String> pilaCadenas = new StackArray<>(5);
        try {
            pilaCadenas.push("hola");
            pilaCadenas.push("mundo");
            System.out.println("Pila de cadenas: " + pilaCadenas);
            System.out.println("Tope de la pila de cadenas: " + pilaCadenas.top());
            pilaCadenas.pop();
            System.out.println("Pila de cadenas después de hacer pop: " + pilaCadenas);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }

        // Prueba con caracteres
        Stack<Character> pilaCaracteres = new StackArray<>(5);
        try {
            pilaCaracteres.push('a');
            pilaCaracteres.push('b');
            pilaCaracteres.push('c');
            System.out.println("Pila de caracteres: " + pilaCaracteres);
            System.out.println("Tope de la pila de caracteres: " + pilaCaracteres.top());
            pilaCaracteres.pop();
            System.out.println("Pila de caracteres después de hacer pop: " + pilaCaracteres);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
    }
}