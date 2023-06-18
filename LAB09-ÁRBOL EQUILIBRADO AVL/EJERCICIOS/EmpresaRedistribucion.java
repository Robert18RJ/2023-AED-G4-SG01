package EJERCICIOS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import ACTIVIDADES.AVLTree;

public class EmpresaRedistribucion {
    private AVLTree<Integer> comercialTree;
    private AVLTree<Integer> produccionTree;
    private AVLTree<Integer> comunicacionesTree;

    public EmpresaRedistribucion() {
        comercialTree = new AVLTree<>();
        produccionTree = new AVLTree<>();
        comunicacionesTree = new AVLTree<>();
    }

    public void redistribuirRegistros(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine(); // Ignorar la primera línea (encabezado)
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                if (campos.length == 3) {
                    int numeroIdt = Integer.parseInt(campos[0].trim());
                    int origen = Integer.parseInt(campos[1].trim());
                    int destino = Integer.parseInt(campos[2].trim());

                    switch (origen) {
                        case 1:
                            comercialTree.insert(numeroIdt);
                            break;
                        case 2:
                            produccionTree.insert(numeroIdt);
                            break;
                        case 3:
                            comunicacionesTree.insert(numeroIdt);
                            break;
                        default:
                            System.out.println("Departamento de origen inválido: " + origen);
                            break;
                    }

                    switch (destino) {
                        case 1:
                            comercialTree.delete(numeroIdt);
                            break;
                        case 2:
                            produccionTree.delete(numeroIdt);
                            break;
                        case 3:
                            comunicacionesTree.delete(numeroIdt);
                            break;
                        default:
                            System.out.println("Departamento de destino inválido: " + destino);
                            break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumEmpleadosComercial() {
        return comercialTree.getNumberOfNodes();
    }

    public int getNumEmpleadosProduccion() {
        return produccionTree.getNumberOfNodes();
    }

    public int getNumEmpleadosComunicaciones() {
        return comunicacionesTree.getNumberOfNodes();
    }

    public static void main(String[] args) {
        EmpresaRedistribucion empresa = new EmpresaRedistribucion();
        empresa.redistribuirRegistros("C:/Users/Usuario/OneDrive - Universidad Católica de Santa María/UCSM/V SEMESTRE/ALGORITMOS Y ESTRUCTURA DE DATOS/PRÁCTICA/FASE II/2023-AED-G4-SG01/LAB9-ÁRBOL EQUILIBRADO AVL/EJERCICIOS/EMPRESA.txt");

        System.out.println("Número de empleados en el departamento Comercial: " + empresa.getNumEmpleadosComercial());
        System.out.println("Número de empleados en el departamento Producción: " + empresa.getNumEmpleadosProduccion());
        System.out.println("Número de empleados en el departamento Comunicaciones: " + empresa.getNumEmpleadosComunicaciones());
    }
}
