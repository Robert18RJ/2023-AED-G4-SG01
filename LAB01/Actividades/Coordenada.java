package LAB01.Ejercicios;

public class Coordenada {
    private double x;
    private double y;

    // Constructor
    public Coordenada() {
        this.x = 0;
        this.y = 0;
    }

    public Coordenada(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Coordenada(Coordenada C) {
        this.x = C.x;
        this.y = C.y;
    }

    // set permite modificar el valor de un atributo de un objeto
    public void setx(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }

    // get se encarga de mostrar un valor a una propiedad o atributo de un objeto
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static double distancia(Coordenada C) {
        double resultado;
        resultado = Math.pow(C.x - 0, 2) + Math.pow(C.y - 0, 2);
        resultado = Math.sqrt(resultado);
        return resultado;
    }

    public static double distancia(Coordenada C1, Coordenada C2) {
        double resultado;
        resultado = Math.pow(C2.x - C1.x, 2) + Math.pow(C2.y - C1.y, 2);
        resultado = Math.sqrt(resultado);
        return resultado;
    }

    public String toString() {
        return ">>>Coordenadas, X:" + x + ", Y: " + y;
    }

}
