package LAB01.Ejercicios;

import java.util.*;

public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        // Ingresar valores para el Rectangulo A
        System.out.println("Ingrese una esquina del 1er rectangulo: ");
        double x1A = sc.nextDouble();
        double y1A = sc.nextDouble();
        System.out.println("Ingrese la esquina opuesta del 1er rectangulo: ");
        double x2A = sc.nextDouble();
        double y2A = sc.nextDouble();
    
        // Ingresar valores para el Rectangulo B
        System.out.println("Ingrese una esquina del 2do rectangulo: ");
        double x1B = sc.nextDouble();
        double y1B = sc.nextDouble();
        System.out.println("Ingrese la esquina opuesta del 2do rectangulo: ");
        double x2B = sc.nextDouble();
        double y2B = sc.nextDouble();
    
        // Crear los objetos Rectangulo A y B
        Rectangulo A = new Rectangulo(new Coordenada(x1A, y1A), new Coordenada(x2A, y2A));
        Rectangulo B = new Rectangulo(new Coordenada(x1B, y1B), new Coordenada(x2B, y2B));
    
        // Verificar en qué caso se encuentran los dos rectángulos
        int caso = Verificador.verificar(A, B);
    
        // Mostrar la información de cada rectángulo
        System.out.println("Rectangulo A = " + A);
        System.out.println("Rectangulo B = " + B);
    
        // Mostrar el caso en el que se encuentran los dos rectángulos
        if (caso == 1) {
            System.out.println("Rectangulos A y B se sobreponen.");
            Rectangulo sobreposicion = Rectangulo.rectanguloSobre(A, B);
            double areaSobreposicion = sobreposicion.calculoArea();
            System.out.println("Area de sobreposicion = " + areaSobreposicion);
        } else if (caso == 2) {
            System.out.println("Rectangulos A y B estan juntos.");
        } else {
            System.out.println("Rectangulos A y B son disjuntos.");
        }
    
        sc.close();
    }  
}






