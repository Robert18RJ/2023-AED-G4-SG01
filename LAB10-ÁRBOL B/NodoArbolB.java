public class NodoArbolB {
    public int n; // número de claves almacenadas en el nodo
    public boolean leaf; // indica si el nodo es una hoja (leaf = true) o un nodo interno (leaf = false)
    public int[] key; // arreglo que almacena las claves del nodo
    public NodoArbolB[] child; // arreglo con referencias a los hijos del nodo

    // Constructores
    public NodoArbolB(int t) {
        n = 0;
        leaf = true;
        key = new int[(2 * t - 1)];
        child = new NodoArbolB[(2 * t)];
    }

    // Métodos getters y setters
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public int getKey(int index) {
        return key[index];
    }

    public void setKey(int index, int value) {
        key[index] = value;
    }

    public NodoArbolB getChild(int index) {
        return child[index];
    }

    public void setChild(int index, NodoArbolB value) {
        child[index] = value;
    }

    // Resto de métodos de la clase (imprimir, find, etc.)
    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            if (i < n - 1) {
                System.out.print(key[i] + " | ");
            } else {
                System.out.print(key[i]);
            }
        }
        System.out.print("]");
    }

    public int find(int k) {
        for (int i = 0; i < n; i++) {
            if (key[i] == k) {
                return i;
            }
        }
        return -1;
    }
}
