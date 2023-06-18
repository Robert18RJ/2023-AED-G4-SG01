public class TestArbolB {
    public static void main(String[] args) {
        ArbolB arbol = new ArbolB(3); // Crear un árbol B con grado mínimo 3

        // Insertar claves en el árbol
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30);
        arbol.insertar(40);
        arbol.insertar(50);
        arbol.insertar(60);
        arbol.insertar(70);
        arbol.insertar(80);
        arbol.insertar(90);

        // Mostrar el árbol
        System.out.println("Árbol B:");
        arbol.showBTree();

        // Buscar un valor en el árbol y mostrar las claves del nodo encontrado
        System.out.println("\nBuscando el nodo con el valor 80:");
        arbol.buscarNodoPorClave(80);

        // Eliminar una clave del árbol
        System.out.println("\nEliminando la clave 30:");
        arbol.eliminar(30);

        // Mostrar el árbol después de la eliminación
        System.out.println("\nÁrbol B después de la eliminación:");
        arbol.showBTree();

        // Obtener el valor máximo del árbol
        System.out.println("\nValor máximo del árbol B: " + arbol.obtenerValorMaximo());

        // Obtener el nodo mínimo de la raíz del árbol
        System.out.println("\nNodo mínimo de la raíz del árbol B:");
        arbol.obtenerNodoMinimo().imprimir();
    }
}
