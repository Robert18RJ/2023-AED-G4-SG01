public class Golosinas implements Comparable<Golosinas> {
    private String nombre;

    public Golosinas(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Golosinas o) {
        return nombre.compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return nombre;
    }
}


