package LAB01.Ejercicios;

public class Verificador {
    public static int verificar(Rectangulo A, Rectangulo B) {
        if (A.getEsquina1().getX() < B.getEsquina2().getX() && A.getEsquina2().getX() > B.getEsquina1().getX() && A.getEsquina1().getY() > B.getEsquina2().getY() && A.getEsquina2().getY() < B.getEsquina1().getY()) {
            // Caso 1: Los rectángulos A y B se sobreponen.
            Rectangulo sobreposicion = rectanguloSobre(A, B);
            System.out.println("Los rectángulos A y B se sobreponen.");
            System.out.println("Rectángulo A: " + A.toString());
            System.out.println("Rectángulo B: " + B.toString());
            System.out.println("Rectángulo de sobreposición: " + sobreposicion.toString());
            double areaSobreposicion = sobreposicion.calculoArea();
            System.out.println("Área de sobreposición: " + areaSobreposicion);
            return 1;
        } else if (A.getEsquina1().getX() == B.getEsquina2().getX() && A.getEsquina1().getY() == B.getEsquina2().getY() || A.getEsquina2().getX() == B.getEsquina1().getX() && A.getEsquina2().getY() == B.getEsquina1().getY()) {
            // Caso 2: Los rectángulos A y B están juntos.
            System.out.println("Los rectángulos A y B están juntos.");
            System.out.println("Rectángulo A: " + A.toString());
            System.out.println("Rectángulo B: " + B.toString());
            return 2;
        } else {
            // Caso 3: Los rectángulos A y B son disjuntos.
            System.out.println("Los rectángulos A y B son disjuntos.");
            System.out.println("Rectángulo A: " + A.toString());
            System.out.println("Rectángulo B: " + B.toString());
            return 3;
        }
    }
    
    public static Rectangulo rectanguloSobre(Rectangulo A, Rectangulo B) {
        double x1 = Math.max(A.getEsquina1().getX(), B.getEsquina1().getX());
        double y1 = Math.min(A.getEsquina1().getY(), B.getEsquina1().getY());
        double x2 = Math.min(A.getEsquina2().getX(), B.getEsquina2().getX());
        double y2 = Math.max(A.getEsquina2().getY(), B.getEsquina2().getY());
        return new Rectangulo(new Coordenada(x1, y1), new Coordenada(x2, y2));
    }
}


