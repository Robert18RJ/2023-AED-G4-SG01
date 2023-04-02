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
        if (lista.size() < tope) {
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

    //Método buscar
    public String search(T elemento) {
        for (int i = 0; i < lista.size(); i++) {
            Caja<T> caja = lista.get(i);
            if (caja.contiene(elemento)) {
                return "Posición " + i + " - Color Caja " + caja.getColor() + " - " + elemento.toString();
            }
        }
        return "El elemento no se encuentra en ninguna caja";
    }

    //Método eliminar
    public T delete(T elemento) {
        for (Caja<T> caja : lista) {
            if (caja.contiene(elemento)) {
                T objetoEliminado = caja.eliminar(elemento);
                return objetoEliminado;
            }
        }
        return null;
    }

    //Métod toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-10s%-15s%-15s%n", "Posicion", "Color Caja", "Objeto"));
        int i = 1;
        for (Caja<T> caja : lista) {
            for (T objeto : caja) {
                sb.append(String.format("%-10d%-15s%-15s%n", i, caja.getColor(), objeto.toString()));
                i++;
            }
        }
        return sb.toString();
    }
        
    public Caja<T> get(int index) {
        return lista.get(index);
    }
        
    public T eliminar(T objeto) {
        for (Caja<T> caja : lista) {
            if (!caja.isEmpty() && caja.contiene(objeto)) {
                return caja.eliminar(objeto);
            }
        }
        return null;
    }       
    
}


