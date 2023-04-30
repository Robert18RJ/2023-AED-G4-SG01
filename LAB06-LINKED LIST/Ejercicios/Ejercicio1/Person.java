package Ejercicio1;

public class Person implements Comparable<Person> {
    private String nombre;
    private String apellidos;
    private int edad;

    public Person(String nombre, String apellidos, int edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public int compareTo(Person other) {
        // Ordenar por nombre en orden alfabético
        return this.nombre.compareTo(other.getNombre());
        //return Integer.compare(this.edad, other.getEdad());
        // Si se quiere ordenar por edad:
        // return Integer.compare(this.edad, other.getEdad());
    }
    
    @Override
    public String toString() {
        return nombre + " " + apellidos + " (" + edad + ")";
    }
}
