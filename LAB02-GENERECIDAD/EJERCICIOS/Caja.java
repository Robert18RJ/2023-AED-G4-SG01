import java.util.ArrayList;
import java.util.Iterator;

public class Caja<T> implements Iterable<T> {
    private String color;
    private ArrayList<T> lista = new ArrayList<T>();
    private int tope;

    public Caja(String color, int tope) {
        this.color = color;
        this.tope = tope;
    }

    public void add(T objeto) {
        if (lista.size() < tope) {
            lista.add(objeto);
        } else {
            throw new RuntimeException("La caja está llena");
        }
    }

    public Iterator<T> iterator() {
        return lista.iterator();
    }
}