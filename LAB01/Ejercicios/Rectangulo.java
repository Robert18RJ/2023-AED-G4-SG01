package LAB01.Ejercicios;

public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;
    private String colores;
    static int nContadores = 0;

    // Constructor
    public Rectangulo(Coordenada C1, Coordenada C2) {
        this.esquina1 = C1;
        this.esquina2 = C2;
        nContadores++;
        this.colores = controlcolor();
    }

    public Rectangulo(int CompX, int CompY) {
        this.esquina1 = new Coordenada(0, CompY);
        this.esquina2 = new Coordenada(CompX, 0);
        nContadores++;
        this.colores = controlcolor();
    }

    public String controlcolor() {
        String color = "";
        switch (nContadores) {
            case 1:
                color = "Verde";
                break;
            case 2:
                color = "Amarillo";
                break;
            case 3:
                color = "Rojo";
                nContadores = 0;
                break;
        }
        return color;
    }
    // get se encarga de mostrar un valor a una propiedad o atributo de un objeto
    public Coordenada getEsquina1() {
        return esquina1;
    }

    // set permite modificar el valor de un atributo de un objeto
    public void setEsquina1(Coordenada C) {
        this.esquina1 = C;
    }
    public Coordenada getEsquina2() {
        return esquina2;
    }
    public void setEsquina2(Coordenada C) {
        this.esquina2 = C;
    }
    public String toString() {
        return ">>>Coordenada 1: " + esquina1 + ", Coordenada 2: " + esquina2+ ", Color : " + colores;
    }

}
