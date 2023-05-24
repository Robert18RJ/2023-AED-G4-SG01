package ACTIVIDADES;

public class BSTree<E extends Comparable<E>> {
    protected Node root;

    public BSTree() {
        root = null;
    }

    protected class Node {
        protected E data;
        protected Node left;
        protected Node right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        public String toString() {
            return data.toString();
        }
    }

    public void insert(E data) throws ItemDuplicated {
        root = insert(root, data);
    }

    private Node insert(Node node, E data) {
        if (node == null) {
            return new Node(data);
        } else {
            int cmp = data.compareTo(node.data);
            if (cmp < 0) {
                node.left = insert(node.left, data);
            } else if (cmp > 0) {
                node.right = insert(node.right, data);
            }
            return node;
        }
    }

    public boolean search(E data) {
        return search(root, data);
    }

    private boolean search(Node node, E data) {
        if (node == null) {
            return false;
        } else {
            int cmp = data.compareTo(node.data);
            if (cmp == 0) {
                return true;
            } else if (cmp < 0) {
                return search(node.left, data);
            } else {
                return search(node.right, data);
            }
        }
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(Node node) {
        if (node != null) {
            printTree(node.left);
            System.out.print(node.data + " ");
            printTree(node.right);
        }
    }
}
