package ACTIVIDADES;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {
    class NodeAVL extends Node {
        protected int bf;

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        public String toString() {
            return super.toString() + " (BF: " + bf + ")";
        }
    }

    private boolean height;

    public AVLTree() {
        super();
    }

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.right;
        node.right = p.left;
        p.left = node;
        node = p;
        return node;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        node = p;
        return node;
    }

    public void insert(E x) {
        height = false;
        root = insert(x, (NodeAVL) root);
    }

    protected Node insert(E x, NodeAVL node) {
        NodeAVL fat = node;
        if (node == null) {
            height = true;
            fat = new NodeAVL(x);
        } else {
            int resC = node.data.compareTo(x);
            if (resC == 0) {
                return fat; // Ignore duplicate items.
            }
            if (resC < 0) {
                fat.right = insert(x, (NodeAVL) node.right);
                if (height) {
                    switch (fat.bf) {
                        case -1:
                            fat.bf = 0;
                            height = false;
                            break;
                        case 0:
                            fat.bf = 1;
                            height = true;
                            break;
                        case 1: // bf = 2
                            fat = balanceToLeft(fat);
                            height = false;
                            break;
                    }
                }
            } else {
                fat.left = insert(x, (NodeAVL) node.left);
                if (height) {
                    switch (fat.bf) {
                        case 1:
                            fat.bf = 0;
                            height = false;
                            break;
                        case 0:
                            fat.bf = -1;
                            height = true;
                            break;
                        case -1: // bf = -2
                            fat = balanceToRight(fat);
                            height = false;
                            break;
                    }
                }
            }
        }
        return fat;
    }

    private NodeAVL balanceToLeft(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.right;
        switch (hijo.bf) {
            case 1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
                break;
            case -1:
                NodeAVL nieto = (NodeAVL) hijo.left;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.right = rotateSR(hijo);
                node = rotateSL(node);
        }
        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.left;
        switch (hijo.bf) {
            case -1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1:
                NodeAVL nieto = (NodeAVL) hijo.right;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 1;
                        hijo.bf = 0;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = 0;
                        hijo.bf = -1;
                        break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
        }
        return node;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return -1;
        } else {
            return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        }
    }

    public void updateBalance(NodeAVL node) {
        if (node != null) {
            node.bf = getHeight(node.right) - getHeight(node.left);
            updateBalance((NodeAVL) node.left);
            updateBalance((NodeAVL) node.right);
        }
    }

    private int getBalanceFactor(NodeAVL node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.right) - getHeight(node.left);
    }

    private NodeAVL balance(NodeAVL node) {
        if (getBalanceFactor(node) == -2) {
            if (getBalanceFactor((NodeAVL) node.left) <= 0) {
                return rotateSR(node);
            } else {
                node.left = rotateSL((NodeAVL) node.left);
                return rotateSR(node);
            }
        } else if (getBalanceFactor(node) == 2) {
            if (getBalanceFactor((NodeAVL) node.right) >= 0) {
                return rotateSL(node);
            } else {
                node.right = rotateSR((NodeAVL) node.right);
                return rotateSL(node);
            }
        }
        return node;
    }

    private NodeAVL findSuccessor(NodeAVL node) {
        if (node.left == null) {
            return node;
        }
        return findSuccessor((NodeAVL) node.left);
    }

    public void delete(E x) {
        root = delete((NodeAVL) root, x);
    }

    private NodeAVL delete(NodeAVL node, E x) {
        if (node == null) {
            return null;
        }

        int cmp = x.compareTo(node.data);
        if (cmp < 0) {
            node.left = delete((NodeAVL) node.left, x);
            updateBalance(node);
            return balance(node);
        } else if (cmp > 0) {
            node.right = delete((NodeAVL) node.right, x);
            updateBalance(node);
            return balance(node);
        } else {
            // Encontrado el nodo a eliminar
            if (node.left == null && node.right == null) {
                // Caso 1: El nodo es una hoja
                return null;
            } else if (node.left == null) {
                return (NodeAVL) node.right; // Conversión explícita a NodeAVL
            } else if (node.right == null) {
                return (NodeAVL) node.left; // Conversión explícita a NodeAVL
            } else {
                NodeAVL successor = findSuccessor((NodeAVL) node.right);
                node.data = successor.data;
                node.right = delete((NodeAVL) node.right, successor.data);
                updateBalance(node);
                return balance(node);
            }
        }
    }

        private int getNumberOfNodes(NodeAVL node) {
        if (node == null) {
            return 0;
        } else {
            int leftCount = getNumberOfNodes((NodeAVL) node.left);
            int rightCount = getNumberOfNodes((NodeAVL) node.right);
            return leftCount + rightCount + 1;
        }
    }

    public int getNumberOfNodes() {
        return getNumberOfNodes((NodeAVL) root);
    }


}