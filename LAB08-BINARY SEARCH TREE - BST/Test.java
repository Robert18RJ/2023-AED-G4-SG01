public class Test {
    public static void main(String[] args) {
        // Crear un árbol binario de búsqueda de enteros
        BSTree<Integer> tree = new BSTree<>();

        try {
            // Insertar elementos
            tree.insert(5);
            tree.insert(2);
            tree.insert(8);
            tree.insert(1);
            tree.insert(6);

            // Imprimir el árbol en orden
            System.out.println("Árbol en orden: " + tree.inOrder());

            // Buscar elementos
            System.out.println("Buscar el elemento 2: " + tree.search(2));
            System.out.println("Buscar el elemento 7: " + tree.search(7));  // Esto lanzará una excepción

        } catch (ItemDuplicated | ItemNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            // Eliminar elementos
            tree.remove(2);
            tree.remove(8);

            // Imprimir el árbol en orden
            System.out.println("Árbol en orden después de eliminar elementos: " + tree.inOrder());

        } catch (ItemNotFound e) {
            System.out.println(e.getMessage());
        }
    }
}