import java.util.ArrayList;
import java.util.List;

public class ArbolB {

    NodoArbolB root;
    int t;

    // Constructor
    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
    }

    // Busca el valor ingresado y muestra el contenido del nodo que contiene el
    // valor
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = search(root, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }

    // Search
    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0;// se empieza a buscar siempre en la primera posicion

        // Incrementa el indice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            i++;
        }

        // Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            return actual;
        }

        // Si llegamos hasta aqui, entonces hay que buscar los hijos
        // Se revisa primero si tiene hijos
        if (actual.leaf) {
            return null;
        } else {
            // Si tiene hijos, hace una llamada recursiva
            return search(actual.child[i], key);
        }
    }

    public void insertar(int key) {
        NodoArbolB r = root;

        // Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoArbolB s = new NodoArbolB(t);
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            nonFullInsert(s, key);
        } else {
            nonFullInsert(r, key);
        }
    }

    // Caso cuando la raiz se divide
    // x = | | | | | |
    // /
    // |10|20|30|40|50|
    // i = 0
    // y = |10|20|30|40|50|
    private void split(NodoArbolB x, int i, NodoArbolB y) {
        // Nodo temporal que sera el hijo i + 1 de x
        NodoArbolB z = new NodoArbolB(t);
        z.leaf = y.leaf;
        z.n = (t - 1);

        // Copia las ultimas (t - 1) claves del nodo y al inicio del nodo z // z =
        // |40|50| | | |
        for (int j = 0; j < (t - 1); j++) {
            z.key[j] = y.key[(j + t)];
        }

        // Si no es hoja hay que reasignar los nodos hijos
        if (!y.leaf) {
            for (int k = 0; k < t; k++) {
                z.child[k] = y.child[(k + t)];
            }
        }

        // nuevo tamanio de y // x = | | | | | |
        y.n = (t - 1); // / \
        // |10|20| | | |
        // Mueve los hijos de x para darle espacio a z
        for (int j = x.n; j > i; j--) {
            x.child[(j + 1)] = x.child[j];
        }
        // Reasigna el hijo (i+1) de x // x = | | | | | |
        x.child[(i + 1)] = z; // / \
        // |10|20| | | | |40|50| | | |
        // Mueve las claves de x
        for (int j = x.n; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }

        // Agrega la clave situada en la mediana // x = |30| | | | |
        x.key[i] = y.key[(t - 1)]; // / \
        x.n++; // |10|20| | | | |40|50| | | |
    }

    private void nonFullInsert(NodoArbolB x, int key) {
        // Si es una hoja
        if (x.leaf) {
            int i = x.n; // cantidad de valores del nodo
            // busca la posicion i donde asignar el valor
            while (i >= 1 && key < x.key[i - 1]) {
                x.key[i] = x.key[i - 1];// Desplaza los valores mayores a key
                i--;
            }

            x.key[i] = key;// asigna el valor al nodo
            x.n++; // aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            // Busca la posicion del hijo
            while (j < x.n && key > x.key[j]) {
                j++;
            }

            // Si el nodo hijo esta lleno lo separa
            if (x.child[j].n == (2 * t - 1)) {
                split(x, j, x.child[j]);

                if (key > x.key[j]) {
                    j++;
                }
            }

            nonFullInsert(x.child[j], key);
        }
    }

    public void showBTree() {
        print(root);
    }

    // Print en preorder
    private void print(NodoArbolB n) {
        n.imprimir();

        // Si no es hoja
        if (!n.leaf) {
            // recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.child[j] != null) {
                    System.out.println();
                    print(n.child[j]);
                }
            }
        }
    }
/////Ejercicio 1
    public void eliminar(int key) {
        eliminarClave(root, key);
    }

    private void eliminarClave(NodoArbolB nodo, int key) {
         int indice = nodo.find(key); // Buscar el índice de la clave en el nodo

        if (indice != -1) {
            // Caso 1: El nodo es una hoja
            if (nodo.leaf) {
                moverClavesIzquierda(nodo, indice);
                nodo.n--;
            }
            // Caso 2: El nodo es un nodo interno
            else {
                NodoArbolB hijoIzquierdo = nodo.child[indice];
                NodoArbolB hijoDerecho = nodo.child[indice + 1];

                // Caso 2a: El hijo izquierdo tiene al menos t claves
                if (hijoIzquierdo.n >= t) {
                    int predecesor = obtenerPredecesor(hijoIzquierdo);
                    nodo.key[indice] = predecesor;
                    eliminarClave(hijoIzquierdo, predecesor);
                }
                // Caso 2b: El hijo derecho tiene al menos t claves
                else if (hijoDerecho.n >= t) {
                    int sucesor = obtenerSucesor(hijoDerecho);
                    nodo.key[indice] = sucesor;
                    eliminarClave(hijoDerecho, sucesor);
                }
                // Caso 2c: Ambos hijos tienen menos de t claves, se realiza una fusión
                else {
                    fusionarNodos(nodo, indice);
                    eliminarClave(hijoIzquierdo, key);
                }
            }
        } else {
            // La clave no está presente en el nodo actual, buscar en el nodo hijo adecuado
            int i = 0;
            while (i < nodo.n && key > nodo.key[i]) {
                i++;
            }

            NodoArbolB hijo = nodo.child[i];

            if (hijo.n >= t) {
                eliminarClave(hijo, key);
            } else {
                if (i < nodo.n && nodo.child[i + 1].n >= t) {
                    moverClavesDerecha(hijo, i);
                    hijo = nodo.child[i];
                } else if (i > 0 && nodo.child[i - 1].n >= t) {
                    moverClavesIzquierda(hijo, i - 1);
                    hijo = nodo.child[i];
                } else {
                    fusionarNodos(nodo, i);
                    hijo = nodo.child[i];
                }
                eliminarClave(hijo, key);
            }
        }
    }

    private int obtenerPredecesor(NodoArbolB nodo) {
        while (!nodo.leaf) {
            nodo = nodo.child[nodo.n];
        }
        return nodo.key[nodo.n - 1];
    }

    private int obtenerSucesor(NodoArbolB nodo) {
        while (!nodo.leaf) {
            nodo = nodo.child[0];
        }
        return nodo.key[0];
    }

    private void moverClavesDerecha(NodoArbolB nodo, int indice) {
        NodoArbolB hijo = nodo.child[indice];
        NodoArbolB hermano = nodo.child[indice + 1];

        hijo.key[hijo.n] = nodo.key[indice];
        nodo.key[indice] = hermano.key[0];

        if (!hijo.leaf) {
            hijo.child[hijo.n + 1] = hermano.child[0];
        }

        for (int i = 1; i < hermano.n; i++) {
            hermano.key[i - 1] = hermano.key[i];
        }

        if (!hermano.leaf) {
            for (int i = 1; i <= hermano.n; i++) {
                hermano.child[i - 1] = hermano.child[i];
            }
        }

        hijo.n++;
        hermano.n--;
    }

    private void moverClavesIzquierda(NodoArbolB nodo, int indice) {
    NodoArbolB hijo = nodo.child[indice];
    NodoArbolB hermano = nodo.child[indice - 1];

    if (hijo != null) {
        for (int i = hijo.n - 1; i >= 0; i--) {
            hijo.key[i + 1] = hijo.key[i];
        }

        hijo.key[0] = nodo.key[indice - 1];
        nodo.key[indice - 1] = hermano.key[hermano.n - 1];

        if (!hijo.leaf) {
            for (int i = hijo.n; i >= 0; i--) {
                hijo.child[i + 1] = hijo.child[i];
            }
            hijo.child[0] = hermano.child[hermano.n];
        }

        hijo.n++;
        hermano.n--;
    }
}


    private void fusionarNodos(NodoArbolB nodo, int indice) {
        NodoArbolB hijoIzquierdo = nodo.child[indice];
        NodoArbolB hijoDerecho = nodo.child[indice + 1];

        hijoIzquierdo.key[t - 1] = nodo.key[indice];

        for (int i = 0; i < hijoDerecho.n; i++) {
            hijoIzquierdo.key[i + t] = hijoDerecho.key[i];
        }

        if (!hijoIzquierdo.leaf) {
            for (int i = 0; i <= hijoDerecho.n; i++) {
                hijoIzquierdo.child[i + t] = hijoDerecho.child[i];
            }
        }

        for (int i = indice + 1; i < nodo.n; i++) {
            nodo.key[i - 1] = nodo.key[i];
        }

        for (int i = indice + 2; i <= nodo.n; i++) {
            nodo.child[i - 1] = nodo.child[i];
        }

        hijoIzquierdo.n += hijoDerecho.n + 1;
        nodo.n--;
    }

    /////Ejercicio 2//////////////

    // Método que retorna el camino recorrido durante la búsqueda, inserción o eliminación
    public List<NodoArbolB> obtenerCaminoRecorrido(int valor) {
        List<NodoArbolB> camino = new ArrayList<>();
        buscarNodoPorClave(root, valor, camino);
        return camino;
    }

    // Método auxiliar para buscar un valor y almacenar el camino recorrido
    private void buscarNodoPorClave(NodoArbolB nodo, int valor, List<NodoArbolB> camino) {
        int i = 0;
        while (i < nodo.n && valor > nodo.key[i]) {
            i++;
        }

        camino.add(nodo);

        if (i < nodo.n && valor == nodo.key[i]) {
            return;
        }

        if (nodo.leaf) {
            return;
        }

        buscarNodoPorClave(nodo.child[i], valor, camino);
    }


    /////Ejercicio 3//////////    
    // Método que busca un valor y retorna todas las claves del nodo que lo contiene
    public List<Integer> buscarClavesDelNodo(int valor) {
        List<Integer> claves = new ArrayList<>();
        NodoArbolB nodo = buscarNodoPorClave(root, valor);
        if (nodo != null) {
            for (int i = 0; i < nodo.n; i++) {
                claves.add(nodo.key[i]);
            }
        }
        return claves;
    }

    // Método auxiliar para buscar un valor y retornar el nodo que lo contiene
    private NodoArbolB buscarNodoPorClave(NodoArbolB nodo, int valor) {
        int i = 0;
        while (i < nodo.n && valor > nodo.key[i]) {
            i++;
        }

        if (i < nodo.n && valor == nodo.key[i]) {
            return nodo;
        }

        if (nodo.leaf) {
            return null;
        }

        return buscarNodoPorClave(nodo.child[i], valor);
    }


    /////Ejercicio 4//////////
    // Método que retorna el valor máximo del árbol B
    public int obtenerValorMaximo() {
        if (root == null) {
            throw new IllegalStateException("El árbol está vacío");
        }

        NodoArbolB nodo = obtenerNodoMaximo(root);
        return nodo.key[nodo.n - 1];
    }


    
    // Método auxiliar para obtener el nodo con el valor máximo
    private NodoArbolB obtenerNodoMaximo(NodoArbolB nodo) {
        if (nodo.leaf) {
            return nodo;
        } else {
            return obtenerNodoMaximo(nodo.child[nodo.n]);
        }
    }

    /////Ejercicio 5//////////
    // Método que retorna el nodo mínimo de la raíz del árbol B
    public NodoArbolB obtenerNodoMinimo() {
        if (root == null) {
            throw new IllegalStateException("El árbol está vacío");
        }

        NodoArbolB nodo = obtenerNodoMinimoRecursivo(root);
        return nodo;
    }

    // Método auxiliar recursivo para obtener el nodo mínimo
    private NodoArbolB obtenerNodoMinimoRecursivo(NodoArbolB nodo) {
        if (nodo.leaf) {
            return nodo;
        } else {
            return obtenerNodoMinimoRecursivo(nodo.child[0]);
        }
    }
}