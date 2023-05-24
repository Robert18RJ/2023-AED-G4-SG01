package ACTIVIDADES;
public class TestAVL {
    public static void main(String[] args) {
        AVLTree<Integer> avlTree = new AVLTree<>();
        AVLTree<Integer> avlTree2 = new AVLTree<>();
        AVLTree<Integer> avlTree3= new AVLTree<>();
        AVLTree<Integer> avlTree4 = new AVLTree<>();
        AVLTree<Integer> avlTree5 = new AVLTree<>();

        try {
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
            avlTree.printTree();
            // Caso de prueba 2: Desequilibrio por rotación simple a la izquierda (RSL)
            avlTree2.insert(10);
            avlTree2.insert(5);
            avlTree2.insert(15);
            avlTree2.insert(3);
            avlTree2.insert(6);
            avlTree2.insert(13);
            avlTree2.insert(17);
            avlTree2.insert(2);
            avlTree2.insert(1);
avlTree2.printTree();
            // Caso de prueba 3: Desequilibrio por rotación doble a la derecha (RDR)
            avlTree3.insert(50);
            avlTree3.insert(20);
            avlTree3.insert(70);
            avlTree3.insert(10);
            avlTree3.insert(30);
            avlTree3.insert(25);
avlTree3.printTree();
            // Caso de prueba 4: Desequilibrio por rotación doble a la izquierda (RDL)
            avlTree4.insert(50);
            avlTree4.insert(70);
            avlTree4.insert(20);
            avlTree4.insert(80);
            avlTree4.insert(60);
            avlTree4.insert(65);
avlTree4.printTree();
            // Caso de prueba 5: Sin desequilibrio
            avlTree5.insert(50);
            avlTree5.insert(30);
            avlTree5.insert(70);
            avlTree5.insert(20);
            avlTree5.insert(40);
            avlTree5.insert(60);
            avlTree5.insert(80);
            avlTree5.insert(10);
            avlTree5.insert(15);
            avlTree5.insert(5);
            avlTree5.insert(25);
            avlTree5.insert(35);
avlTree5.printTree();
            // Resto de los casos de prueba...

            // Imprimir el árbol AVL
        } catch (ItemDuplicated e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}