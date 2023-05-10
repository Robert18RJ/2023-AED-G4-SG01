package Actividad1;

public class ExceptionFull extends Exception {
    public ExceptionFull() {
        super("La lista está llena");
    }

    public ExceptionFull(String message) {
        super(message);
    }
}