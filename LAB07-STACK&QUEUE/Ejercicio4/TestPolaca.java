package Ejercicio4;

public class TestPolaca {
    public static void main(String[] args) {
        Polaca polaca = new Polaca();

        // Prueba 1
        System.out.println("Prueba 1:");
        polaca.readFile(
                "C:/Users/Usuario/OneDrive - Universidad Católica de Santa María/UCSM/V SEMESTRE/ALGORITMOS Y ESTRUCTURA DE DATOS/PRÁCTICA/FASE II/2023-AED-G4-SG01/LAB07-STACK&QUEUE/Ejercicio4/Archivo/archivo1.txt");

        // Prueba 2
        System.out.println("Prueba 2:");
        polaca.readFile(
                "C:/Users/Usuario/OneDrive - Universidad Católica de Santa María/UCSM/V SEMESTRE/ALGORITMOS Y ESTRUCTURA DE DATOS/PRÁCTICA/FASE II/2023-AED-G4-SG01/LAB07-STACK&QUEUE/Ejercicio4/Archivo/archivo1.txt");

        // // Prueba 3
        System.out.println("Prueba 3:");
        polaca.readFile("Ejercicio4/Archivo/archivo1.txt");
    }
}
