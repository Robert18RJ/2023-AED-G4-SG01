import java.util.LinkedList;
import java.util.Stack;

public class BSTree<E extends Comparable<E>> {
    protected class Node {
        protected E data;
        protected Node left, right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    public BSTree() {
        root = null;
    }

    public void insert(E x) throws ItemDuplicated {
        if (root == null) {
            root = new Node(x);
        } else {
            insert(root, x);
        }
    }
    
    private void insert(Node node, E x) throws ItemDuplicated {
        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            if (node.left == null) {
                node.left = new Node(x);
            } else {
                insert(node.left, x);
            }
        } else if (cmp > 0) {
            if (node.right == null) {
                node.right = new Node(x);
            } else {
                insert(node.right, x);
            }
        } else {
            throw new ItemDuplicated(x.toString());
        }
    }

    public E search(E x) throws ItemNotFound {
        return search(root, x);
    }

    private E search(Node node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("El elemento no se encuentra en el árbol.");
        }

        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            return search(node.left, x);
        } else if (compareResult > 0) {
            return search(node.right, x);
        } else {
            return node.data;
        }
    }

    public void remove(E x) throws ItemNotFound {
        root = remove(root, x);
    }

    private Node remove(Node node, E x) throws ItemNotFound {
        if (node == null) {
            throw new ItemNotFound("El elemento no se encuentra en el árbol.");
        }

        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            node.left = remove(node.left, x);
        } else if (compareResult > 0) {
            node.right = remove(node.right, x);
        } else {
            if (node.left != null && node.right != null) {
                node.data = findMin(node.right);
                node.right = remove(node.right, node.data);
            } else {
                node = (node.left != null) ? node.left : node.right;
            }
        }

        return node;
    }

    private E findMin(Node node) {
        if (node.left == null) {
            return node.data;
        }
        return findMin(node.left);
    }

    public String toString() {
        return inOrder();
    }

    public String inOrder() {
        StringBuilder sb = new StringBuilder();
        inOrder(root, sb);
        return sb.toString();
    }

    private void inOrder(Node node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(node.data.toString()).append(" ");
            inOrder(node.right, sb);
        }
    }

    public int countNonLeaves() {
        return countNonLeaves(root);
    }

    // Ejercicios :3
    // 1.Retorna el número de nodos no-hojas de un BST
    private int countNonLeaves(Node node) {

        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }

        return 1 + countNonLeaves(node.left) + countNonLeaves(node.right);
    }

    // 2.Retorna la altura de un nodo X cualquiera de un BST siempre y cuando exista en el árbol
    public int getNodeHeight(E x) {
        return getNodeHeight(root, x);
    }

    private int getNodeHeight(Node node, E x) {
        if (node == null) {
            return -1; // Nodo no encontrado, se retorna -1
        }

        int compareResult = x.compareTo(node.data);

        if (compareResult < 0) {
            return getNodeHeight(node.left, x) + 1; // Búsqueda en el subárbol izquierdo
        } else if (compareResult > 0) {
            return getNodeHeight(node.right, x) + 1; // Búsqueda en el subárbol derecho
        } else {
            return getHeight(node); // Se encontró el nodo, se retorna su altura
        }
    }

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1; // Altura máxima entre los subárboles izquierdo y derecho, más 1
    }

    // 3.Método iterative (no recursive) que recorra en PreOrden los nodos de un
    // BST.
    public void preOrderIterative() {
        if (root == null) {
            return; // El árbol está vacío, no hay nodos para recorrer
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    // 4.Retorne el área del árbol binario de búsqueda
    public int getArea() {
        int leafCount = countLeaves(root);
        int height = calculateHeight(root);

        return leafCount * height;
    }

    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null && node.right == null) {
            return 1;
        }

        return countLeaves(node.left) + countLeaves(node.right);
    }

    private int calculateHeight(Node node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // 6.Devuelve el nodo con el valor más bajo (mínimo) de un BST
    public Node getMinNode() {
        if (root == null) {
            return null; // Árbol vacío, no hay nodo mínimo
        }

        Node current = root;
        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // 7.Retorna el nodo con el valor más alto (máximo) de un BST
    public Node getMaxNode() {
        if (root == null) {
            return null; // Árbol vacío, no hay nodo máximo
        }

        Node current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    // 8.La representación entre paréntesis

    public void parenthesize() {
        if (root == null) {
            return;
        }

        // Creando una LinkedList que se comportará como una cola
        LinkedList<Node> queue = new LinkedList<Node>();

        // Encolando el nodo raíz a la cola
        queue.add(root);

        while (!queue.isEmpty()) {
            // Obteniendo el tamaño de la cola, que es el número de nodos en el nivel actual
            int levelSize = queue.size();

            // Recorriendo todos los nodos en el nivel actual
            for (int i = 0; i < levelSize; i++) {
                // Sacando el elemento del frente de la cola
                Node node = queue.poll();

                // Imprimiendo el dato del nodo con tabulaciones
                System.out.print("+".repeat(levelSize) + node.data);

                // Si el nodo tiene un hijo izquierdo, lo encola
                if (node.left != null) {
                    queue.add(node.left);
                }

                // Si el nodo tiene un hijo derecho, lo encola
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // Imprimiendo una línea nueva al final de cada nivel
            System.out.println();
        }

    }     
}
