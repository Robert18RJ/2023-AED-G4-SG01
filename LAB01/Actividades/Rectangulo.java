package LAB01.Ejercicios;

public class Rectangulo {
    private Coordenada esquina1;
    private Coordenada esquina2;

    // Constructor
    public Rectangulo(Coordenada C1, Coordenada C2) {
        this.esquina1 = C1;
        this.esquina2 = C2;
    }

    public Rectangulo(int CompX, int CompY) {
        this.esquina1 = new Coordenada(0, CompY);
        this.esquina2 = new Coordenada(CompX, 0);
    }

    // set permite modificar el valor de un atributo de un objeto
    public void setEsquina1(Coordenada C) {
        this.esquina1 = C;
    }

    public void setEsquina2(Coordenada C) {
        this.esquina2 = C;
    }

    // get se encarga de mostrar un valor a una propiedad o atributo de un objeto
    public Coordenada getEsquina1() {
        return esquina1;
    }

    public Coordenada getEsquina2() {
        return esquina2;
    }

    // Método para calcular el área de un rectángulo
    public double calculoArea() {
        double base = Math.abs(esquina1.getX() - esquina2.getX());
        double altura = Math.abs(esquina1.getY() - esquina2.getY());
        double area = base * altura;
        return area;
    }

    public String toString() {
        return ">>>Coordenada 1: " + esquina1 + ", Coordenada 2: " + esquina2;
    }

    public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) {
        double x1 = Math.max(r1.getEsquina1().getX(), r2.getEsquina1().getX());
        double y1 = Math.max(r1.getEsquina1().getY(), r2.getEsquina1().getY());
        double x2 = Math.min(r1.getEsquina2().getX(), r2.getEsquina2().getX());
        double y2 = Math.min(r1.getEsquina2().getY(), r2.getEsquina2().getY());
        return new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
    }

    

    // metodo para calcular la distancia euclideana entre los vertices opuestos del rectangulo
    public double distancia() {
    //se obtienen las coordenadas de los vertices opuestos del rectangulo
        double base = Math.abs(esquina1.getX() - esquina2.getX());
        double altura = Math.abs(esquina1.getY() - esquina2.getY());
        //double x1 = this.x;
        double x1 = esquina1.getX();
        //double y1 = this.y;
        double y1 = esquina2.getY();
        //double x2 = this.x + this.ancho;        
        double x2 = esquina1.getX() + base;
        //double y2 = this.y + this.alto;
        double y2 = esquina2.getY() + altura;

    //se aplica la formula de la distancia euclidea entre dos puntos
        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

    //se retorna el valor de la distancia
        return d;
    }

    //metodo para calcular el area del rectangulo
    //public double area() {
    //se aplica la formula del area del rectangulo: base por altura
        //double a = this.ancho * this.alto;

        // se retorna el valor del area
        //return a;
    //}
    
}

