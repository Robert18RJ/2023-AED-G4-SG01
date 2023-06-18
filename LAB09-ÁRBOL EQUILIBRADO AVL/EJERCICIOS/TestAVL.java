package EJERCICIOS;

import ACTIVIDADES.AVLTree;

public class TestAVL {
 
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();

        
            // Caso de prueba 1: Desequilibrio por rotación simple a la derecha (RSR)
            avlTree.insert(50);
            avlTree.insert(30);
            avlTree.insert(70);
            avlTree.insert(20);
            avlTree.insert(40);
            avlTree.insert(60);
            avlTree.insert(80);
            avlTree.insert(25);
            avlTree.insert(23);
            avlTree.insert(21);

            // Caso de prueba 2: Desequilibrio por rotación simple a la izquierda (RSL)
            avlTree.insert(10);
            avlTree.insert(5);
            avlTree.insert(15);
            avlTree.insert(3);
            avlTree.insert(6);
            avlTree.insert(13);
            avlTree.insert(17);
            avlTree.insert(2);
            avlTree.insert(1);

            // Caso de prueba 3: Desequilibrio por rotación doble a la derecha (RDR)
            avlTree.insert(50);
            avlTree.insert(20);
            avlTree.insert(70);
            avlTree.insert(10);
            avlTree.insert(30);
            avlTree.insert(25);

            // Caso de prueba 4: Desequilibrio por rotación doble a la izquierda (RDL)
            avlTree.insert(50);
            avlTree.insert(70);
            avlTree.insert(20);
            avlTree.insert(80);
            avlTree.insert(60);
            avlTree.insert(65);

            // Caso de prueba 5: Sin desequilibrio
            avlTree.insert(50);
            avlTree.insert(30);
            avlTree.insert(70);
            avlTree.insert(20);
            avlTree.insert(40);
            avlTree.insert(60);
            avlTree.insert(80);
            avlTree.insert(10);
            avlTree.insert(15);
            avlTree.insert(5);
            avlTree.insert(25);
            avlTree.insert(35);

            // Resto de los casos de prueba...

            // Imprimir el árbol AVL
            avlTree.printTree();
       
    }
}