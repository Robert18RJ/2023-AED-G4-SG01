package LAB01.Ejercicios;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int ComponenteX, ComponenteY;
        System.out.println("Introducir Componente del X : ");
        ComponenteX = entrada.nextInt();
        System.out.println("Introducir Componente del Y : ");
        ComponenteY = entrada.nextInt();
        Rectangulo Rectangle = new Rectangulo(ComponenteX, ComponenteY);
        System.out.println("Color: " + Rectangle.toString());
        System.out.println("Área: " + Manejador.area(Rectangle));
        System.out.println("Perimetro: " + Manejador.perimetro(Rectangle));
        Manejador.moverX(-5, Rectangle);
        System.out.println("Área 2 : " + Manejador.area(Rectangle));
        Manejador.moverY(5, Rectangle);
        Manejador.moverX(5, Rectangle);
        System.out.println("Perimetro: " + Manejador.perimetro(Rectangle));
        System.out.println("Área 3 : " + Manejador.area(Rectangle));
        Rectangulo Rectangle1 = new Rectangulo(ComponenteX, ComponenteY);
        System.out.println("Color : " + Rectangle1.toString());
        Rectangulo Rectangle2 = new Rectangulo(ComponenteX, ComponenteY);
        System.out.println("Color : " + Rectangle2.toString());
        Rectangulo Rectangle3 = new Rectangulo(ComponenteX, ComponenteY);
        System.out.println("Color : " + Rectangle3.toString());
        Rectangulo Rectangle4 = new Rectangulo(ComponenteX, ComponenteY);
        System.out.println("Color : " + Rectangle4.toString());
        Rectangulo Rectangle5 = new Rectangulo(ComponenteX, ComponenteY);
        System.out.println("Color : " + Rectangle5.toString());
        Rectangulo Rectangle6 = new Rectangulo(ComponenteX, ComponenteY);
        System.out.println("Color : " + Rectangle6.toString());
        Rectangulo Rectangle7 = new Rectangulo(ComponenteX, ComponenteY);
        System.out.println("Color : " + Rectangle7.toString());
        Rectangulo Rectangle8 = new Rectangulo(ComponenteX, ComponenteY);
        System.out.println("Color : " + Rectangle8.toString());
        Rectangulo Rectangle9 = new Rectangulo(new Coordenada(4, 5), new Coordenada(6, 7));
        System.out.println("Color : " + Rectangle9.toString());
        Manejador.moverY(10, Rectangle);
        entrada.close();
    }

}
