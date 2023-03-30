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

    // Método para buscar un elemento en las cajas de la Cajoneria
    public String search(T elemento) {
        for (int i = 0; i < lista.size(); i++) {
            Caja<T> caja = lista.get(i);
            if (caja.contains(elemento)) {
                return "Posicion " + (i + 1) + " " + caja.getColor() + " " + caja.getContenido();
            }
        }
        return "El elemento no se encuentra en ninguna de las cajas";
    }

    // Método para eliminar un elemento de las cajas de la Cajoneria
    public T delete(T elemento) {
        for (int i = 0; i < lista.size(); i++) {
            Caja<T> caja = lista.get(i);
            if (caja.contains(elemento)) {
                return caja.remove(elemento);
            }
        }
        return null;
    }

    // Método para devolver una cadena con los datos de los objetos guardados en las cajas de la Cajoneria
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lista.size(); i++) {
            Caja<T> caja = lista.get(i);
            ArrayList<T> contenido = caja.getContenido();
            for (T elemento : contenido) {
                sb.append("Posicion ").append(i + 1).append(" ").append(caja.getColor()).append(" ").append(elemento).append("\n");
            }
        }
        return sb.toString();
    }
}
