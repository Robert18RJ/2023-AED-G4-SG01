package EJERCICIOS;
import ACTIVIDADES.*;
public class Main {
    public static void main(String[] args) throws ItemDuplicated {
        // Caso de prueba 1: Inserción desbalanceada
        System.out.println("Caso de prueba 1: Inserción desbalanceada");

        // Árbol BST
        BSTree<Integer> bst = new BSTree<Integer>();
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        bst.insert(40);
        bst.insert(50);

        System.out.println("BST:");
        bst.printTree();
        System.out.println("Búsqueda en BST:");
        System.out.println("Elemento 50 encontrado: " + bst.search(50));

        // Árbol AVL
        AVLTree<Integer> avl = new AVLTree<>();
        avl.insert(10);
        avl.insert(20);
        avl.insert(30);
        avl.insert(40);
        avl.insert(50);

        System.out.println("AVL:");
        avl.printTree();
        System.out.println("Búsqueda en AVL:");
        System.out.println("Elemento 50 encontrado: " + avl.search(50));

        System.out.println("-----------------------------------");

        // Caso de prueba 2: Inserción de elementos duplicados
        System.out.println("Caso de prueba 2: Inserción de elementos duplicados");

        // Árbol BST
        BSTree<Integer> bst2 = new BSTree<>();
        try {
            bst2.insert(10);
            bst2.insert(20);
            bst2.insert(30);
            bst2.insert(20); // Elemento duplicado, no lanza excepción
            bst2.insert(40);
        } catch (ItemDuplicated e) {
            System.out.println("Excepción ItemDuplicated en BST: " + e.getMessage());
        }

        // Árbol AVL
        AVLTree<Integer> avl2 = new AVLTree<>();

            avl2.insert(10);
            avl2.insert(20);
            avl2.insert(30);
            avl2.insert(20); // Elemento duplicado, lanza excepción
            avl2.insert(40);
        
    }
}
