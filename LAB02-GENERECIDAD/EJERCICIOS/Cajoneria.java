import java.util.ArrayList;
import java.util.Iterator;

public class Cajoneria<T> implements Iterable<Caja<T>> {
    private ArrayList<Caja<T>> lista = new ArrayList<>();
    private int tope;

    public Cajoneria(int tope) {
        super();
        this.tope = tope;
    }

    public void add(Caja<T> caja) {
        if (lista.size() >= tope) {
            lista.add(caja);
        } else {
            throw new RuntimeException("no caben mas cajas");
        }
    }

    public void addAll(Cajoneria<T> cajoneria) {
        for (Caja<T> caja : cajoneria) {
            add(caja);
        }
    }

    public Iterator<Caja<T>> iterator() {
        return lista.iterator();
    }
}
